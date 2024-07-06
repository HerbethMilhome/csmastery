package br.com.csmastery.login.config;

import br.com.csmastery.login.usuario.domain.CredencialUsuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(CredencialUsuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Date today = new Date();
            return JWT.create()
                    .withIssuer("auth-api-csmastery")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(genExpiracaoData())
                    .withIssuedAt(today)
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gerar o token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("auth-api-csmastery")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {
            return "";
        }
    }

    private Instant genExpiracaoData() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
