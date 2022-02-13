package org.macchiato.department.domain;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class DepartmentId {
    @NonNull
    UUID departmentId;
}
