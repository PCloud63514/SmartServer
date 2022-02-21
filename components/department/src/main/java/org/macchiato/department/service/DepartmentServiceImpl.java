package org.macchiato.department.service;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;
import org.macchiato.department.exception.AlreadyExistsDepartmentException;
import org.macchiato.department.exception.NotExistsDepartmentException;
import org.macchiato.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public void addDepartment(Department department) {
        repository.findBy(department.getDepartmentInformation().getDepartmentId())
                .ifPresentOrElse(entity -> {
                    throw new AlreadyExistsDepartmentException();
            }, ()-> {
                repository.save(department);
        });
    }

    @Override
    public Department getDepartment(DepartmentId departmentId) throws Exception {
        return repository.findBy(departmentId).orElseThrow(NotExistsDepartmentException::new);
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
        repository.findBy(departmentId).ifPresentOrElse(entity -> {
            repository.delete(departmentId);
        }, () -> {
            throw new NotExistsDepartmentException();
        });
    }
}