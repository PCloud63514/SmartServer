package org.macchiato.department.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
@EqualsAndHashCode(of = "departmentInformation")
public class BaseDepartment implements Department {
    @NonNull
    DepartmentInformation departmentInformation;

    public BaseDepartment(DepartmentId departmentId, String departmentName, String description) {
        this(new DepartmentInformation(departmentId, departmentName, description));
    }

    public static BaseDepartment create(String departmentName, String description) {
        return new BaseDepartment(new DepartmentId(UUID.randomUUID()), departmentName, description);
    }
}
