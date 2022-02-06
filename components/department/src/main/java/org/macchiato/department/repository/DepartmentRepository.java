package org.macchiato.department.repository;

import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    Optional<Department> findBy(DepartmentId departmentId);
    List<Department> findAll();
    void save(Department department);
    void delete(DepartmentId departmentId);
}
