package com.example.demo.teste;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/teste")
public class TesteController {

    @Value("${app.teste}")
    private String teste;


    @GetMapping
    public ResponseEntity runTeste(){
        return ResponseEntity.ok(teste);
    }
}
