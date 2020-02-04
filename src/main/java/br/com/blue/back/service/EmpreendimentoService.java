package br.com.blue.back.service;

import br.com.blue.back.model.Empreendimento;
import br.com.blue.back.repository.EmpreendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpreendimentoService {

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    public ResponseEntity<Empreendimento> consultaPorId(Long id) {
        Optional<Empreendimento> empreendimento = empreendimentoRepository.findById(id);
        if (empreendimento.isPresent()) {
            return ResponseEntity.ok(empreendimento.get());
        } else {
            return new ResponseEntity("Empreendimento não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

}
