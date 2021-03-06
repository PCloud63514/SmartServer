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
@RequestMapping("/departments")
public class DepartmentApi {
    private final DepartmentService departmentService;

    @GetMapping("{id}")
    public DepartmentResponse getDepartment(@PathVariable("id") UUID departmentId) throws Exception {
        Department department = departmentService.getDepartment(new DepartmentId(departmentId));

        return department.toResponse();
    }

    @GetMapping
    public List<DepartmentResponse> getDepartments() throws Exception {
        List<Department> departmentList = departmentService.getDepartments();
        return departmentList.stream().map(Department::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    public UUID addDepartment(@RequestBody AddDepartmentRequest request) throws Exception {
        BaseDepartment department = BaseDepartment.create(request.getName(), request.getDescription());
        departmentService.addDepartment(department);
        return department.departmentId();
    }

    @PatchMapping("{departmentId}")
    public void updateDepartment(@PathVariable UUID departmentId, @RequestBody UpdateDepartmentRequest request) throws Exception {
        departmentService.modifyDepartment(DepartmentInformation.create(departmentId, request.getName(), request.getDescription()));
    }

    @DeleteMapping("{departmentId}")
    public void deleteDepartment(@PathVariable UUID departmentId) throws Exception {
        departmentService.deleteDepartment(new DepartmentId(departmentId));
    }

    /**
     * ????????? ??? ?????? ??????
     */
    @GetMapping("{departmentId}/user")
    public void getUsersToDepartment(@PathVariable UUID departmentId) {

    }
    /**
     * ???????????? ?????? ??????
     */
    @PostMapping("{departmentId}/uesr")
    public void addUserToDepartment(@PathVariable UUID departmentId, @RequestBody AddUserToDepartmentRequest request) {

    }

    /**
     * ???????????? ?????? ??????
     */
    @DeleteMapping("{departmentId}/user/{userId}")
    public void removeUserToDepartment(@PathVariable UUID departmentId, @PathVariable String userId) {

    }

    public class AddUserToDepartmentRequest {

    }
}
