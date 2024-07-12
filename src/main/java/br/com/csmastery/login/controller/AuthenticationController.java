package br.com.csmastery.login.controller;

import br.com.csmastery.login.services.AuthorizarionService;
import br.com.csmastery.login.usuario.domain.CredencialUsuario;
import br.com.csmastery.login.usuario.domain.dto.AuthenticationDTO;
import br.com.csmastery.login.usuario.domain.dto.RegistroDTO;
import br.com.csmastery.login.usuario.domain.dto.TokenDTO;
import br.com.csmastery.login.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthorizarionService authorizarionService;

    @PostMapping("login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AuthenticationDTO dto) {
        TokenDTO token = this.authorizarionService.auth(dto);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistroDTO dto) {

        if (this.repository.findByLogin(dto.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
        CredencialUsuario usuario = new CredencialUsuario(dto.login(), encryptedPassword, dto.role());

        this.repository.save(usuario);

        return ResponseEntity.ok().build();
    }

}
