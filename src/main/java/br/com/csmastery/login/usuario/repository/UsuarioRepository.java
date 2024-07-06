package br.com.csmastery.login.usuario.repository;

import br.com.csmastery.login.usuario.domain.CredencialUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<CredencialUsuario, String> {

    UserDetails findByLogin(String login);

}
