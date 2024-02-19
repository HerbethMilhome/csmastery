package br.com.csmastery.atendente.domain.entity;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import br.com.csmastery.aluno.domain.entity.Endereco;
import br.com.csmastery.aluno.domain.entity.SituacaoAluno;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atendentes")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atendente {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Column(length = 100)
    private String nome;

    @NotNull
    @NotBlank
    @Column(length = 100)
    private String email;

    @NotNull
    @NotBlank
    @Column(length = 11)
    private String telefone;

    @OneToMany(mappedBy = "atendente", fetch = FetchType.LAZY)
    @JsonManagedReference
    @Null
    private List<Aluno> alunos = new ArrayList<>();

    public Atendente(String id) {
        this.id = id;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
        for (Aluno aluno : alunos) {
            if (aluno != null && !aluno.getAtendente().equals(this)) {
                aluno.setAtendente(this);
            }
        }
    }

}
