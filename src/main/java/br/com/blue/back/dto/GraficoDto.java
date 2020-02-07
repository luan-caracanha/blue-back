package br.com.blue.back.dto;

public class GraficoDto {

    private Long votos;

    private String nomeEempreendimento;

    public Long getVotos() {
        return votos;
    }

    public void setVotos(Long votos) {
        this.votos = votos;
    }

    public String getNomeEempreendimento() {
        return nomeEempreendimento;
    }

    public void setNomeEempreendimento(String nomeEempreendimento) {
        this.nomeEempreendimento = nomeEempreendimento;
    }
}
