package org.macchiato.department.domain;

import java.util.UUID;

public interface Department {
    default UUID departmentId() {
        return getDepartmentInformation().getDepartmentId().getDepartmentId();
    }

    default String departmentName() {
        return getDepartmentInformation().getDepartmentName();
    }

    default String description() {
        return getDepartmentInformation().getDescription();
    }

    DepartmentInformation getDepartmentInformation();
}
