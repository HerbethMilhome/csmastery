package br.com.csmastery.atendente.controller;

import br.com.csmastery.atendente.domain.entity.Atendente;
import br.com.csmastery.atendente.repository.AtendenteRepository;
import br.com.csmastery.exception.RecordNotFindException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atendente")
@Validated
public class AtendenteController {

    @Autowired
    private AtendenteRepository repository;

    @GetMapping
    public ResponseEntity<List<Atendente>> getAllAtendentes() {
        var atendentes = repository.findAll();
        return ResponseEntity.ok(atendentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendente> getById(@PathVariable @NotNull String id) {
        var atendente = repository.findById(id).orElseThrow(() -> new RecordNotFindException(id));
        return ResponseEntity.ok().body(atendente);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Atendente saveAtendente(@RequestBody @Valid Atendente atendente) {
        return repository.save(atendente);
    }

    @PutMapping
    public ResponseEntity<Atendente> updateAtendente(@RequestBody @Valid Atendente atendente) {
        repository.save(atendente);
        return ResponseEntity.ok(atendente);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void deleteAtendente(@PathVariable @NotNull String id) {
        repository.deleteById(id);
    }

}
