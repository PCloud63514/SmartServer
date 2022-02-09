package org.macchiato.department.library.network;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.macchiato.department.library.config.NetworkConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ExtendWith({SpringExtension.class})
@ImportAutoConfiguration(value = NetworkConfiguration.class)
class DepartmentRestTemplateTest {
    static DepartmentRestTemplate departmentRestTemplate;

    @BeforeAll
    static void setUp(@Autowired RestTemplate restTemplate) {
        departmentRestTemplate = new DepartmentRestTemplate(restTemplate);
    }

    @Test
    void test() throws Exception {
        List<DepartmentResponse> departments = departmentRestTemplate.getDepartments();
    }
}