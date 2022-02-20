package org.macchiato.department.service;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;
import org.macchiato.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public void addDepartment(Department department) {
        repository.findBy(department.getDepartmentInformation().getDepartmentId())
                .ifPresentOrElse(entity -> {
                    throw new IllegalStateException("해당 부서가 이미 존재합니다.");
            }, ()-> {
                repository.save(department);
        });
    }

    @Override
    public Department getDepartment(DepartmentId departmentId) throws Exception {
        return repository.findBy(departmentId).orElseThrow(IllegalStateException::new);
    }

    @Override
    public List<Department> getDepartments() {
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