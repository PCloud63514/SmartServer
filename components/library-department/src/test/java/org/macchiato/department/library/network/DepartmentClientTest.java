package org.macchiato.department.library.network;

import org.junit.jupiter.api.Test;
import org.macchiato.department.library.config.FeignClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@ImportAutoConfiguration(value = FeignClientConfiguration.class)
class DepartmentClientTest {
    @Autowired
    DepartmentClient departmentClient;

    @Test
    void test() {
        System.out.println("hello");
    }
}