package br.com.blue.back.service;

import br.com.blue.back.dto.VotacaoDto;
import br.com.blue.back.model.Votacao;
import br.com.blue.back.repository.EmpreendimentoRepository;
import br.com.blue.back.repository.UsuarioRepository;
import br.com.blue.back.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VotacaoService {

    @Autowired
    private VotacaoRepository votacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    public ResponseEntity<Votacao> consultaPorId(Long id) {
        Optional<Votacao> votacao = votacaoRepository.findById(id);
        if (votacao.isPresent()) {
            return ResponseEntity.ok(votacao.get());
        } else {
            return new ResponseEntity("Votação não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Votacao> consultaPorUsuarioId(Long id) {
        Votacao votacao = votacaoRepository.findByUsuarioId(id);
        if (votacao != null) {
            return ResponseEntity.ok(votacao);
        } else {
            return new ResponseEntity("Votação não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Votacao> salvar(VotacaoDto votacaoDto) {
        Votacao votacao = new Votacao();
        votacao.setData(LocalDateTime.now());
        votacao.setUsuario(usuarioRepository.findById(votacaoDto.getIdUsuario()).get());
        votacao.setEmpreendimento(empreendimentoRepository.findById(votacaoDto.getIdEmpreendimento()).get());

        votacaoRepository.saveAndFlush(votacao);
        return ResponseEntity.ok(votacao);
    }
}
