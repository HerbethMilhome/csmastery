package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.dto.mapper.AlunoMapper;
import br.com.csmastery.aluno.domain.entity.SituacaoFinanceira;
import br.com.csmastery.aluno.repository.SituacaoFinanceiraRepository;
import br.com.csmastery.exception.RecordNotFindException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service(value = "SituacaoFinanceira")
public class SituacaoFinanceiraServiceImpl implements SituacaoFinanceiraService {

    @Autowired
    private SituacaoFinanceiraRepository repository;

    @Override
    public List<SituacaoFinanceira> getAllSituacoes(){
        return repository.findAll();
    }

    @Override
    public SituacaoFinanceira saveSituacao(SituacaoFinanceira situacaoFinanceira) {
        return repository.save(situacaoFinanceira);
    }

    @Override
    public SituacaoFinanceira updateSituacao(@NotNull SituacaoFinanceira situacaoFinanceira) {
        return repository.save(situacaoFinanceira);
    }

    @Override
    public void deleteSituacao(@NotNull String id) {
        repository.deleteById(id);
    }

    @Override
    public SituacaoFinanceira findById(@NotNull String id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFindException(id));
    }
}
