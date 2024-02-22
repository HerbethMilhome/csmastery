package br.com.csmastery.aluno.services;

import br.com.csmastery.aluno.domain.entity.SituacaoFinanceira;

import java.util.List;

public interface SituacaoFinanceiraService {

    public List<SituacaoFinanceira> getAllSituacoes();

    public SituacaoFinanceira saveSituacao(SituacaoFinanceira situacaoFinanceira);

    SituacaoFinanceira updateSituacao(SituacaoFinanceira situacaoFinanceira);

    void deleteSituacao(String id);

    SituacaoFinanceira findById(String id);
}
