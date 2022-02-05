package org.macchiato.department.repository;

import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;

import java.util.Optional;

public interface DepartmentRepository {

    Optional<Department> findBy(DepartmentId departmentId);
    void save(Department department);
}
