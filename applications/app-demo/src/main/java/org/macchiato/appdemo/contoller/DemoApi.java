package org.macchiato.appdemo.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Demo Hello!");
    }
}
