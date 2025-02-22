package com.bunt.docker.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello - Docker";
    }
}