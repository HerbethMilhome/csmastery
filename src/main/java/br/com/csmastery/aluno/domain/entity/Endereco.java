package br.com.csmastery.aluno.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Optional;

@Entity
@Table(name = "enderecos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Column(length = 255)
    private String logradouro;

    @Column(length = 10)
    private String numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 100)
    private String bairro;

    @NotNull
    @NotBlank
    @Column(length = 100)
    private String cidade;

    @NotNull
    @NotBlank
    @Column(length = 50)
    private String estado;

    @NotNull
    @NotBlank
    @Column(length = 10)
    private String cep;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aluno_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Aluno aluno;

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        if (aluno != null && !aluno.getEndereco().equals(this)) {
            aluno.setEndereco(Optional.of(this));
        }
    }

}
