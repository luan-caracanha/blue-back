package br.com.blue.back.repository;

import br.com.blue.back.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}