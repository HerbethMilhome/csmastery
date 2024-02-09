package br.com.csmastery.aluno.controller;


import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity getAllAlunos() {
        var allAlunos = service.getAllAlunos();
        return ResponseEntity.ok(allAlunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable String id) {
        var aluno = service.findById(id);
        return aluno.map(result -> ResponseEntity.ok().body(result))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno saveAluno(@RequestBody @Valid Aluno aluno) {
        return service.saveAluno(aluno);
        //return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PutMapping
    public ResponseEntity updateAluno(@RequestBody @Valid Aluno aluno) {
        service.updateAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAluno(@PathVariable String id) {
        service.deleteAluno(id);
        return ResponseEntity.ok().build();
    }

}
