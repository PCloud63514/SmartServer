package org.macchiato.department.service;

import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department) throws Exception;
    // 부서 조회
    Department getDepartment(DepartmentId departmentId) throws Exception;
    // 부서 목록 조회
    List<Department> getDepartments() throws Exception;
    // 부서 정보 수정
    void modifyDepartment(DepartmentInformation departmentInformation) throws Exception;
    // 부서 내 직원 목록 조회
    void getMemberInDepartment(DepartmentId departmentId) throws Exception;
    // 부서 삭제
    void deleteDepartment(DepartmentId departmentId) throws Exception;
}
