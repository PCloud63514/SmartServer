package org.macchiato.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AppDepartmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppDepartmentApplication.class, args);
    }
}
