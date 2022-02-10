package org.macchiato.department.library.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.macchiato.department.library.network.DepartmentClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NetworkConfiguration {
    @Bean
    public DepartmentClient departmentClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .contract(new SpringMvcContract())
                .target(DepartmentClient.class, "http://localhost:8180/department");
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
