package org.macchiato.department.library.network;

import feign.Client;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.macchiato.department.library.body.request.AddDepartmentRequest;
import org.macchiato.department.library.body.request.UpdateDepartmentRequest;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.List;
import java.util.UUID;

@EnableFeignClients
@ImportAutoConfiguration
class DepartmentClientTest {
    DepartmentClient departmentClient;

    @BeforeEach
    void setUp() throws Exception {
        departmentClient = Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .contract(new SpringMvcContract())
                .target(DepartmentClient.class, "http://localhost:8080/department");
    }

    @Test
    void test() throws Exception {
        UUID department1 = departmentClient.addDepartment(new AddDepartmentRequest("부서1", "1번 부서 설명"));
        DepartmentResponse department = departmentClient.getDepartment(department1);

        departmentClient.updateDepartment(department1, new UpdateDepartmentRequest("부서1", "부서1 설명 업데이트"));

        DepartmentResponse departmentUpdate = departmentClient.getDepartment(department1);

        List<DepartmentResponse> departments = departmentClient.getDepartments();

        System.out.println("hello");
    }
}