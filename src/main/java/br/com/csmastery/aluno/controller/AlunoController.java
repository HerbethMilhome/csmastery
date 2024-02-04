package br.com.csmastery.aluno.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @GetMapping
    public ResponseEntity getAllAlunos() {
        return ResponseEntity.ok("deu certo");
    }
}
