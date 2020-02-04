package br.com.blue.back.controller;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.model.Votacao;
import br.com.blue.back.service.UsuarioService;
import br.com.blue.back.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Votacao> consultaPorId(@PathVariable Long id) {
        return  votacaoService.consultaPorId(id);
    }
}
