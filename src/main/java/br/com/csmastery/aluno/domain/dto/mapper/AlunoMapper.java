package br.com.csmastery.aluno.domain.dto.mapper;

import br.com.csmastery.aluno.domain.dto.AlunoRequest;
import br.com.csmastery.aluno.domain.entity.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public AlunoRequest toRequest(Aluno aluno) {

        if (aluno == null) {
            return null;
        }

        return new AlunoRequest(
            aluno.getId(),
            aluno.getNome(),
            aluno.getCpf(),
            aluno.getEmail(),
            aluno.getTelefone(),
            aluno.getNomeSocio(),
            aluno.getEmailSocio(),
            aluno.getTelefoneSocio(),
            aluno.getStatusFinanceiro(),
            aluno.getNota(),
            aluno.getSatisfacao(),
            aluno.getDataEntrada(),
            aluno.getDataCriacao(),
            aluno.getDataRenovacao(),
            aluno.getDataUltimoContrato(),
            aluno.getUltimoAcompanhamento(),
            aluno.getProximoContato(),
            aluno.getVigenciaContrato(),
            aluno.getUltimaResposta(),
            aluno.getMentoria(),
            aluno.getCicloMatricula(),
            aluno.getRenovado(),
            aluno.getRemovido(),
            aluno.getSituacaoAluno(),
            aluno.getEndereco(),
            aluno.getAtendente());
    }

    public Aluno toEntity(AlunoRequest alunoRequest) {

        if (alunoRequest == null) {
            return null;
        }

        Aluno aluno = new Aluno();
        if (alunoRequest.id() != null) {
            aluno.setId(alunoRequest.id());
        }
        aluno.setNome(alunoRequest.nome());
        aluno.setCpf(alunoRequest.cpf());
        aluno.setEmail(alunoRequest.email());
        aluno.setTelefone(alunoRequest.telefone());
        aluno.setNomeSocio(alunoRequest.nomeSocio());
        aluno.setEmailSocio(alunoRequest.emailSocio());
        aluno.setTelefoneSocio(alunoRequest.telefoneSocio());
        aluno.setStatusFinanceiro(alunoRequest.statusFinanceiro());
        aluno.setNota(alunoRequest.nota());
        aluno.setSatisfacao(alunoRequest.satisfacao());
        aluno.setDataEntrada(alunoRequest.dataEntrada());
        aluno.setDataCriacao(alunoRequest.dataCriacao());
        aluno.setDataRenovacao(alunoRequest.dataRenovacao());
        aluno.setDataUltimoContrato(alunoRequest.dataUltimoContrato());
        aluno.setUltimoAcompanhamento(alunoRequest.ultimoAcompanhamento());
        aluno.setProximoContato(alunoRequest.proximoContato());
        aluno.setVigenciaContrato(alunoRequest.vigenciaContrato());
        aluno.setUltimaResposta(alunoRequest.ultimaResposta());
        aluno.setMentoria(alunoRequest.mentoria());
        aluno.setCicloMatricula(alunoRequest.cicloMatricula());
        aluno.setRenovado(alunoRequest.renovado());
        aluno.setRemovido(alunoRequest.removido());
        aluno.setSituacaoAluno(alunoRequest.situacao());
        aluno.setEndereco(alunoRequest.endereco());
        aluno.setAtendente(alunoRequest.atendente());

        return aluno;
    }
    
}
