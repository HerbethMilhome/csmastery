package br.com.csmastery.aluno.repository;

import br.com.csmastery.aluno.domain.entity.SituacaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoFinanceiraRepository extends JpaRepository<SituacaoFinanceira, String> {

}
