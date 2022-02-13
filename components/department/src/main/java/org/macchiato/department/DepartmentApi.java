package org.macchiato.department;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;
import org.macchiato.department.library.body.request.AddDepartmentRequest;
import org.macchiato.department.library.body.request.UpdateDepartmentRequest;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.macchiato.department.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentApi {
    private final DepartmentService departmentService;

    @GetMapping("{id}")
    public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable("id") UUID departmentId) throws Exception {
        Department department = departmentService.getDepartment(new DepartmentId(departmentId));

        return ResponseEntity.ok(department.toResponse());
    }

    @GetMapping("list")
    public ResponseEntity<List<DepartmentResponse>> getDepartments() throws Exception {
        List<Department> departmentList = departmentService.getDepartments();
        List<DepartmentResponse> collect = departmentList.stream().map(Department::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
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

    /**
     * 거주지 내 유저 조회
     */
    @GetMapping("{departmentId}/user")
    public void getUsersToDepartment(@PathVariable UUID departmentId) {

    }
    /**
     * 거주지에 유저 추가
     */
    @PostMapping("{departmentId}/uesr")
    public void addUserToDepartment(@PathVariable UUID departmentId, @RequestBody AddUserToDepartmentRequest request) {

    }


    /**
     * 거주지에 유저 제외
     */
    @DeleteMapping("{departmentId}/user/{userId}")
    public void removeUserToDepartment(@PathVariable UUID departmentId, @PathVariable String userId) {

    }

    public class AddUserToDepartmentRequest {

    }
}
