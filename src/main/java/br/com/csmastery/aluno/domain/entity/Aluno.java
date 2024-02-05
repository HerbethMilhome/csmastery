package br.com.csmastery.aluno.domain.entity;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "alunos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String nomeSocio;
    private String emailSocio;
    private String telefoneSocio;
    private String statusFinanceiro;
    private String nota;
    private String satisfacao;
    private String responsavel;
    private Timestamp dataEntrada;
    private Timestamp dataCriacao;
    private Timestamp dataRenovacao;
    private Timestamp dataUltimoContrato;
    private Timestamp ultimoAcompanhamento;
    private Timestamp proximoContato;
    private Integer vigenciaContrato;
    private Integer ultimaResposta;
    private Integer mentoria;
    private Integer cicloMatricula;
    private Integer renovado;

    public Aluno(AlunoRequest aluno) {

        aluno.id().ifPresent(id -> this.id = id);

        this.nome = aluno.nome();
        this.cpf = aluno.cpf();
        this.email = aluno.email();
        this.telefone = aluno.telefone();

        aluno.nomeSocio().ifPresent(n -> this.nomeSocio = n);
        aluno.emailSocio().ifPresent(e -> this.emailSocio = e);
        aluno.telefoneSocio().ifPresent(t -> this.telefoneSocio = t);
        aluno.statusFinanceiro().ifPresent(s -> this.statusFinanceiro = s);
        aluno.nota().ifPresent(n -> this.nota = n);
        aluno.satisfacao().ifPresent(s -> this.satisfacao = s);
        aluno.responsavel().ifPresent(r -> this.responsavel = r);
        aluno.dataEntrada().ifPresent(d -> this.dataEntrada = d);
        aluno.dataCriacao().ifPresent(d -> this.dataCriacao = d);
        aluno.dataRenovacao().ifPresent(d -> this.dataRenovacao = d);
        aluno.dataUltimoContrato().ifPresent(d -> this.dataUltimoContrato = d);
        aluno.ultimoAcompanhamento().ifPresent(u -> this.ultimoAcompanhamento = u);
        aluno.proximoContato().ifPresent(p -> this.proximoContato = p);
        aluno.vigenciaContrato().ifPresent(v -> this.vigenciaContrato = v);
        aluno.ultimaResposta().ifPresent(u -> this.ultimaResposta = u);
        aluno.mentoria().ifPresent(m -> this.mentoria = m);
        aluno.cicloMatricula().ifPresent(c -> this.cicloMatricula = c);
        aluno.renovado().ifPresent(r -> this.renovado = r);

    }

}
