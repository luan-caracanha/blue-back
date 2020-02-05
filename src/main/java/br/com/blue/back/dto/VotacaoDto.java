package br.com.blue.back.dto;

import javax.validation.constraints.NotBlank;

public class VotacaoDto {

    @NotBlank
    private Long idUsuario;

    @NotBlank
    private Long idEmpreendimento;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdEmpreendimento() {
        return idEmpreendimento;
    }

    public void setIdEmpreendimento(Long idEmpreendimento) {
        this.idEmpreendimento = idEmpreendimento;
    }
}
