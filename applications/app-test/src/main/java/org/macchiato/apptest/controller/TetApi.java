package org.macchiato.apptest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TetApi {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Success");
    }
}
