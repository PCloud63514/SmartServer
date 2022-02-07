package org.macchiato.department;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentApi {
    private final DepartmentService departmentService;

    @GetMapping
    public void getDepartment() {

    }

    @GetMapping("list")
    public void getDepartments() {

    }

    @PostMapping
    public void addDepartment() {

    }

    @PatchMapping
    public void updateDepartment() {

    }

    @DeleteMapping
    public void deleteDepartment() {

    }
}
