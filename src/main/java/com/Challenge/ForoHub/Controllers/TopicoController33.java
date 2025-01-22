package com.Challenge.ForoHub.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class TopicoController33 {

    @GetMapping
    public String holi(){
        return "say im marica";
    }
}
