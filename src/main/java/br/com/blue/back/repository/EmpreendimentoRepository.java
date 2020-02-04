package br.com.blue.back.repository;

import br.com.blue.back.model.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
}