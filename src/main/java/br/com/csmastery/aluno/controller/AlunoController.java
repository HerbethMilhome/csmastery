package br.com.csmastery.aluno.controller;


import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity getAllAlunos() {
        var allAlunos = service.getAllAlunos();
        return ResponseEntity.ok(allAlunos);
    }

    @PostMapping
    public ResponseEntity saveAluno(@RequestBody @Valid AlunoRequest aluno) {
        service.saveAluno(aluno);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateAluno(@RequestBody @Valid AlunoRequest aluno) {
        service.updateAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAluno(@PathVariable String id) {
        service.deleteAluno(id);
        return ResponseEntity.ok().build();
    }

}
