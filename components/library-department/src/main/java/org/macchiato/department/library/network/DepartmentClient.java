package org.macchiato.department.library.network;

import org.macchiato.department.library.body.request.AddDepartmentRequest;
import org.macchiato.department.library.body.request.UpdateDepartmentRequest;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "department", url = "localhost:8080/department")
public interface DepartmentClient {
    @PostMapping
    UUID addDepartment(AddDepartmentRequest request) throws Exception;

    @GetMapping("list")
    List<DepartmentResponse> getDepartments() throws Exception;

    @GetMapping("{departmentId}")
    DepartmentResponse getDepartment(@PathVariable(name = "departmentId") UUID departmentId) throws Exception;

    @PatchMapping({"{departmentId}"})
    void updateDepartment(@PathVariable(name = "departmentId") UUID departmentId, @RequestBody UpdateDepartmentRequest request) throws Exception;

    @DeleteMapping("{departmentId}")
    void deleteDepartment(@PathVariable(name = "departmentId") UUID departmentId) throws Exception;
}
