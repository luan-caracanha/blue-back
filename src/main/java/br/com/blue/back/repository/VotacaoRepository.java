package br.com.blue.back.repository;

import br.com.blue.back.model.Empreendimento;
import br.com.blue.back.model.Usuario;
import br.com.blue.back.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    @Query(value = "SELECT v FROM Votacao v LEFT JOIN v.usuario u WHERE u.id = :id")
    Votacao findByUsuarioId(@Param("id") Long id);

    long countVotacaoByEmpreendimento(Empreendimento empreendimento);
}