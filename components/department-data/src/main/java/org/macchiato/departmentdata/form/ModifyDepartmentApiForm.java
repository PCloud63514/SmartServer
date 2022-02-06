package org.macchiato.departmentdata.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ModifyDepartmentApiForm extends DepartmentForm {
    private UUID id;
    private String name;
    private String description;
}
