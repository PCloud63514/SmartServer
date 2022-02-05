package org.macchiato.department.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
@EqualsAndHashCode(of = "departmentInformation")
public class BaseDepartment implements Department {
    @NonNull
    DepartmentInformation departmentInformation;

    public BaseDepartment(DepartmentId departmentId, String departmentName, String description) {
        this(new DepartmentInformation(departmentId, departmentName, description));
    }
}
