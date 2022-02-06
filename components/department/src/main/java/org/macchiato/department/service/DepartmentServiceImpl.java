package org.macchiato.department.service;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;
import org.macchiato.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public void addDepartment(Department department) throws Exception {
        Optional<Department> opt = repository.findBy(department.getDepartmentInformation().getDepartmentId());
        if (opt.isPresent()) {
            throw new Exception("해당 부서가 이미 존재합니다.");
        }
        repository.save(department);
    }

    @Override
    public Department getDepartment(DepartmentId departmentId) throws Exception {
        Optional<Department> opt = repository.findBy(departmentId);
        if (opt.isEmpty()) {
            throw new Exception("부서가 존재하지 않습니다.");
        }
        return opt.get();
    }

    @Override
    public List<Department> getDepartmentList() {
        return repository.findAll();
    }

    @Override
    public void modifyDepartment(DepartmentInformation departmentInformation) throws Exception {
        this.getDepartment(departmentInformation.getDepartmentId());
        repository.save(new BaseDepartment(departmentInformation));
    }

    @Override
    public void getMemberInDepartment(DepartmentId departmentId) {

    }

    @Override
    public void deleteDepartment(DepartmentId departmentId) {
        repository.delete(departmentId);
    }
}
