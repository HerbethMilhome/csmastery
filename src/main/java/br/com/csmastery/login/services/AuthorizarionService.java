package br.com.csmastery.login.services;

import br.com.csmastery.login.config.TokenService;
import br.com.csmastery.login.usuario.domain.CredencialUsuario;
import br.com.csmastery.login.usuario.domain.dto.AuthenticationDTO;
import br.com.csmastery.login.usuario.domain.dto.TokenDTO;
import br.com.csmastery.login.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizarionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizarionService(@Lazy AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public TokenDTO auth (AuthenticationDTO dto) {

        if (validaSenha(dto)) {
            var loginSenha = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
            Authentication auth = authenticationManager.authenticate(loginSenha);
            CredencialUsuario principal = (CredencialUsuario) auth.getPrincipal();
            String token = tokenService.generateToken(principal);
            String login = principal.getLogin();
            String role = principal.getRole().name();

            return TokenDTO.builder().token(token).type("Bearer").login(login).role(role).build();

        }
        return TokenDTO.builder().token(null).type("Bearer").build();
    }

    private boolean validaSenha(AuthenticationDTO dto) {
        String pass = loadUserByUsername(dto.login()).getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(dto.senha(), pass);
    }
}
