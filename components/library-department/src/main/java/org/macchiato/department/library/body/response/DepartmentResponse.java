package org.macchiato.department.library.body.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DepartmentResponse {
    private final UUID departmentId;
    private final String departmentName;
    private final String description;
}
