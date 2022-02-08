package org.macchiato.department.library.network;

import org.macchiato.department.library.body.request.AddDepartmentRequest;
import org.macchiato.department.library.body.request.UpdateDepartmentRequest;
import org.macchiato.department.library.body.response.DepartmentResponse;

import java.util.List;
import java.util.UUID;

public interface DepartmentRestApi {
    // 부서 추가
    UUID addDepartment(AddDepartmentRequest request) throws Exception;
    // 부서 목록 조회
    List<DepartmentResponse> getDepartments() throws Exception;
    // 부서 단일 조회
    DepartmentResponse getDepartment(UUID departmentId) throws Exception;
    // 부서 수정
    void updateDepartment(UUID departmentId, UpdateDepartmentRequest request) throws Exception;
    // 부서 삭제
    void deleteDepartment(UUID departmentId) throws Exception;
}
