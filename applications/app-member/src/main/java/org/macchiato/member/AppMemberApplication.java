package org.macchiato.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AppMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppMemberApplication.class, args);
    }
}
