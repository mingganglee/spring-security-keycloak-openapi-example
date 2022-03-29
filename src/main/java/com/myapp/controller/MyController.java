package com.myapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/myapp")
@SecurityRequirement(name = "security_auth")
public class MyController {
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "security_auth"))
    @GetMapping("/myendpoint")
    public String myendpoint() {
        return "hello";
    }

}
