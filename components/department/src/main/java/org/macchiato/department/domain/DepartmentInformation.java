package org.macchiato.department.domain;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class DepartmentInformation {
    @NonNull
    DepartmentId departmentId;

    @NonNull
    String departmentName;

    String description;

    public static DepartmentInformation create(UUID id, String departmentName, String description) {
        return new DepartmentInformation(new DepartmentId(id), departmentName, description);
    }
}
