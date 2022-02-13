package org.macchiato.department.service;

import org.junit.jupiter.api.*;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;
import org.macchiato.department.domain.DepartmentInformation;
import org.macchiato.department.repository.DepartmentDatabaseRepository;
import org.macchiato.department.repository.DepartmentRepository;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class DepartmentServiceImplTest {
    private static DepartmentService departmentService;
    private static String givenName = "departmentName";
    private static String givenDescription = "description";
    private static DepartmentId addedId = null;
    @BeforeAll
    static void beforeAll() {
        DepartmentRepository repository = new DepartmentDatabaseRepository();
        departmentService = new DepartmentServiceImpl(repository);
    }

    @Test
    @Order(1)
    void addDepartmentTest() throws Exception {
        DepartmentId givenDepartmentId = new DepartmentId(UUID.randomUUID());
        addedId = new DepartmentId(UUID.randomUUID());
        DepartmentInformation givenDepartmentInformation = new DepartmentInformation(addedId, givenName, givenDescription);
        BaseDepartment baseDepartment = new BaseDepartment(givenDepartmentInformation);

        DepartmentInformation givenDepartmentInformation2 = new DepartmentInformation(givenDepartmentId, givenName, givenDescription);
        BaseDepartment baseDepartment2 = new BaseDepartment(givenDepartmentInformation2);

        departmentService.addDepartment(baseDepartment);
        departmentService.addDepartment(baseDepartment2);
    }

    @Test
    @Order(2)
    void getDepartmentTest() throws Exception {
        Department department = departmentService.getDepartment(addedId);

        assertThat(givenName).isEqualTo(department.departmentName());
        assertThat(givenDescription).isEqualTo(department.description());
    }

    @Test
    @Order(3)
    void addDepartmentExceptionTest() {
        DepartmentInformation givenDepartmentInformation = new DepartmentInformation(addedId, givenName, givenDescription);
        BaseDepartment baseDepartment = new BaseDepartment(givenDepartmentInformation);

        assertThrows(Exception.class, ()->{
            departmentService.addDepartment(baseDepartment);
        });
    }

    @Test
    @Order(4)
    void getDepartmentListTest() throws Exception {
        List<Department> departmentList = departmentService.getDepartments();
        assertThat(departmentList.size()).isEqualTo(2);
    }

    @Test
    @Order(5)
    void modifyDepartmentTest() throws Exception {
        String givenModifyName = "modifyName";
        String givenModifyDescription = "modifyDescription";
        DepartmentInformation givenModifyInformation = new DepartmentInformation(addedId, givenModifyName, givenModifyDescription);

        departmentService.modifyDepartment(givenModifyInformation);
        Department department = departmentService.getDepartment(addedId);

        assertThat(department.departmentName()).isEqualTo(givenModifyName);
        assertThat(department.description()).isEqualTo(givenModifyDescription);
    }

    @Test
    @Order(6)
    void deleteDepartmentTest() throws Exception {
        departmentService.deleteDepartment(addedId);

        assertThrows(Exception.class, ()-> {
           departmentService.getDepartment(addedId);
        });
    }
}