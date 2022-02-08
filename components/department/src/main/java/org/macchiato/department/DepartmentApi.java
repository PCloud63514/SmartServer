package org.macchiato.department;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;
import org.macchiato.department.request.AddDepartmentRequest;
import org.macchiato.department.request.UpdateDepartmentRequest;
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
    public ResponseEntity<UUID> addDepartment(@RequestBody AddDepartmentRequest request) throws Exception {
        BaseDepartment department = BaseDepartment.create(request.getName(), request.getDescription());
        departmentService.addDepartment(department);
        return ResponseEntity.ok(department.departmentId());
    }

    @PatchMapping("{departmentId}")
    public ResponseEntity updateDepartment(@PathVariable UUID departmentId, @RequestBody UpdateDepartmentRequest request) throws Exception {
        departmentService.modifyDepartment(DepartmentInformation.create(departmentId, request.getName(), request.getDescription()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity deleteDepartment(@PathVariable UUID departmentId) throws Exception {
        departmentService.deleteDepartment(new DepartmentId(departmentId));
        return ResponseEntity.ok().build();
    }
}
