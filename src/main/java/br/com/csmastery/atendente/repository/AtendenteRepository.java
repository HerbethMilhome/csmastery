package br.com.csmastery.atendente.repository;

import br.com.csmastery.atendente.domain.entity.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, String> {

}
