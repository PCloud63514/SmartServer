package org.macchiato.departmentdata.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class GetDepartmentApiResponse extends DepartmentResponse {
    private UUID id;
    private String name;
    private String description;
}
