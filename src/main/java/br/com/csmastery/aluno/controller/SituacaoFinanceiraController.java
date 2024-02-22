package br.com.csmastery.aluno.controller;

import br.com.csmastery.aluno.domain.entity.SituacaoFinanceira;
import br.com.csmastery.aluno.services.SituacaoFinanceiraService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/situacao-financeira")
@Validated
public class SituacaoFinanceiraController {

    @Autowired
    private SituacaoFinanceiraService service;

    @GetMapping
    public ResponseEntity getAllSituacoes() {
        var situacoes = service.getAllSituacoes();
        return ResponseEntity.ok(situacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoFinanceira> getById(@PathVariable @NotNull String id) {
        var situacao = service.findById(id);
        if (situacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(situacao);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public SituacaoFinanceira saveSituacaoFinanceira(@RequestBody @Valid SituacaoFinanceira situacao) {
        return service.saveSituacao(situacao);
    }

    @PutMapping
    public ResponseEntity<SituacaoFinanceira> updateSituacaoFinanceira(@RequestBody @Valid SituacaoFinanceira situacaoFinanceira) {
        service.updateSituacao(situacaoFinanceira);
        return ResponseEntity.ok(situacaoFinanceira);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void deleteSituacaoFinanceira(@PathVariable @NotNull String id) {
        service.deleteSituacao(id);
    }

}
