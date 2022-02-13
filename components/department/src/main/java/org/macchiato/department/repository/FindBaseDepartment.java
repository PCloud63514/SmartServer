package org.macchiato.department.repository;

import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.DepartmentId;

import java.util.Optional;

@FunctionalInterface
public interface FindBaseDepartment {
    Optional<BaseDepartment> findBaseDepartmentBy(DepartmentId departmentId);
}
