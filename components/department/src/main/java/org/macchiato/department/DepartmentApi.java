package org.macchiato.department;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentApi {
    private final DepartmentService departmentService;

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") UUID departmentId) throws Exception {
        Department department = departmentService.getDepartment(new DepartmentId(departmentId));

        return ResponseEntity.ok(department);
    }

    @GetMapping("list")
    public ResponseEntity<List<Department>> getDepartments() throws Exception {
        List<Department> departmentList = departmentService.getDepartments();
        return ResponseEntity.ok(departmentList);
    }

    @PostMapping
    public void addDepartment() {
        departmentService.addDepartment();
    }

    @PatchMapping
    public void updateDepartment() {

    }

    @DeleteMapping
    public void deleteDepartment(UUID id) throws Exception {
        departmentService.deleteDepartment(new DepartmentId(id));
    }
}
