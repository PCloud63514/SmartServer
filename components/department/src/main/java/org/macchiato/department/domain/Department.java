package org.macchiato.department.domain;

import org.macchiato.department.library.body.response.DepartmentResponse;

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

    default DepartmentResponse toResponse() {
        return new DepartmentResponse(departmentId(), departmentName(), description());
    }
}
