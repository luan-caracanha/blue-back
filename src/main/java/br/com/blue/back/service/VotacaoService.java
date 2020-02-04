package br.com.blue.back.service;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.model.Votacao;
import br.com.blue.back.repository.UsuarioRepository;
import br.com.blue.back.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotacaoService {

    @Autowired
    private VotacaoRepository votacaoRepository;

    public ResponseEntity<Votacao> consultaPorId(Long id) {
        Optional<Votacao> votacao  = votacaoRepository.findById(id);
        if (votacao.isPresent()) {
            return ResponseEntity.ok(votacao.get());
        } else {
            return new ResponseEntity("Votação não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

}
