package br.com.csmastery.login.controller;

import br.com.csmastery.login.config.TokenService;
import br.com.csmastery.login.usuario.domain.Usuario;
import br.com.csmastery.login.usuario.domain.dto.AuthenticationDTO;
import br.com.csmastery.login.usuario.domain.dto.RegistroDTO;
import br.com.csmastery.login.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO dto) {
        var loginSenha = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        org.springframework.security.core.Authentication auth = null;
        try {
            auth = authenticationManager.authenticate(loginSenha);
        } catch (Exception e) {
            e.printStackTrace();
            String convertJSON = "{\"token\": \"\"}";
            return ResponseEntity.ok(convertJSON);
        }

        String token = tokenService.generateToken((Usuario) auth.getPrincipal());
        Usuario principal = (Usuario) auth.getPrincipal();
        String login = principal.getLogin();
        String role = principal.getRole().name();

        String convertJSON = "{\"token\": \"" + token + "\", " +
                " \"user\": \"" + login + "\", \"role\": \"" + role + "\"}";

        return ResponseEntity.ok(convertJSON);
    }

    @PostMapping("registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistroDTO dto) {

        if (this.repository.findByLogin(dto.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
        Usuario usuario = new Usuario(dto.login(), encryptedPassword, dto.role());

        this.repository.save(usuario);

        return ResponseEntity.ok().build();
    }

}
