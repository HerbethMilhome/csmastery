package br.com.csmastery.aluno.repository;

import br.com.csmastery.aluno.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

}
