package org.macchiato.department.library.network;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.List;

class DepartmentRestTemplateTest {
    DepartmentRestTemplate departmentRestTemplate;

    @BeforeEach
    void setUp() {
        departmentRestTemplate = new DepartmentRestTemplate(new RestTemplateBuilder().build());
    }

    @Test
    void test() throws Exception {
        List<DepartmentResponse> departments = departmentRestTemplate.getDepartments();
    }
}