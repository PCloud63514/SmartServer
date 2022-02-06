package org.macchiato.departmentdata.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddDepartmentApiForm extends DepartmentForm {
    private String name;
    private String description;
}
