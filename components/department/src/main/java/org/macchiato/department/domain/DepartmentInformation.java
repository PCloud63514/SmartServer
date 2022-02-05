package org.macchiato.department.domain;

import lombok.NonNull;
import lombok.Value;

@Value
public class DepartmentInformation {
    @NonNull
    DepartmentId departmentId;

    @NonNull
    String departmentName;

    String description;
}
