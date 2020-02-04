package br.com.blue.back.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Votacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Empreendimento empreendimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Votacao)) return false;
        Votacao votacao = (Votacao) o;
        return Objects.equals(getId(), votacao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
