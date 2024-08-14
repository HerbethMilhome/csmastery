package br.com.csmastery.aluno.controller;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.services.AlunoService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
@Validated
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity getAllAlunos(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                       @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize,
                                       @RequestParam(required = false) String filter) {
        if (filter != null && !filter.isEmpty()) {
            return ResponseEntity.ok(service.findByNomeContainingIgnoreCase(filter, page, pageSize));
        } else {
            return ResponseEntity.ok(service.getAllAlunos(page, pageSize));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoRequest> getById(@PathVariable @NotNull String id) {
        var aluno = service.findById(id);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno saveAluno(@RequestBody @Valid Aluno aluno) {
        return service.saveAluno(aluno);
    }

    @PostMapping("/import")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> importListAluno(@RequestBody List<Aluno> alunos) {
        service.importListAluno(alunos);
        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity<Aluno> updateAluno(@RequestBody @Valid Aluno aluno) {
        service.updateAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void deleteAluno(@PathVariable @NotNull String id) {
        service.deleteAluno(id);
    }

}
