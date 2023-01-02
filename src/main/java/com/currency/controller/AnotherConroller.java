package com.currency.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/checkApiKey")
public class AnotherConroller {

    @Value("${api-key}")
    private String appApiKey;

    @GetMapping
    public HttpStatus getConnection(@RequestParam String apiKey, HttpServletResponse response) {
        if (!appApiKey.equals(apiKey)) {
            response.setStatus(403);
           return HttpStatus.FORBIDDEN;
        }
        return HttpStatus.ACCEPTED;
    }
}
