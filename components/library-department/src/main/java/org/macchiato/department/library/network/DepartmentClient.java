package org.macchiato.department.library.network;

import feign.Headers;
import org.macchiato.department.library.body.request.AddDepartmentRequest;
import org.macchiato.department.library.body.request.UpdateDepartmentRequest;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.macchiato.department.library.body.response.SampleResponse;
import org.macchiato.department.library.body.response.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "department", url = "localhost:8180/department")
public interface DepartmentClient {

    @GetMapping("{departmentId}")
    DepartmentResponse getDepartment(@PathVariable(name = "departmentId") UUID departmentId) throws Exception;

    @GetMapping("list")
    List<DepartmentResponse> getDepartments() throws Exception;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    UUID addDepartment(@RequestBody AddDepartmentRequest request) throws Exception;

//    @Headers("Content-Type: application/json")
    @PatchMapping(value = {"{departmentId}"},
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE})
    void updateDepartment(@PathVariable(name = "departmentId") UUID departmentId, @RequestBody UpdateDepartmentRequest request) throws Exception;

    @DeleteMapping("{departmentId}")
    void deleteDepartment(@PathVariable(name = "departmentId") UUID departmentId) throws Exception;

    @GetMapping("{message}/sample")
    SampleResponse<TestResponse> sample(@PathVariable(name = "message") String message);
}
