package org.macchiato.department.library.body.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DepartmentResponse {
    private UUID departmentId;
    private String departmentName;
    private String description;
}
