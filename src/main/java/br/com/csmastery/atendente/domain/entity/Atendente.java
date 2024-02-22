package br.com.csmastery.atendente.domain.entity;

import br.com.csmastery.aluno.domain.entity.Aluno;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atendentes")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atendente implements Serializable {

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
    @JsonBackReference
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
