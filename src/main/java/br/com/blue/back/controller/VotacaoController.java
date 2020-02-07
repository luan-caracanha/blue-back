package br.com.blue.back.controller;

import br.com.blue.back.dto.AutenticarDto;
import br.com.blue.back.dto.GraficoDto;
import br.com.blue.back.dto.VotacaoDto;
import br.com.blue.back.model.Usuario;
import br.com.blue.back.model.Votacao;
import br.com.blue.back.service.UsuarioService;
import br.com.blue.back.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Votacao> consultaPorId(@PathVariable Long id) {
        return  votacaoService.consultaPorId(id);
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<Votacao> salvar(@RequestBody VotacaoDto votacaoDto) {
        return  votacaoService.salvar(votacaoDto);
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<Votacao> consultaPorUsuarioId(@PathVariable Long id) {
        return  votacaoService.consultaPorUsuarioId(id);
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Votacao>> consultaTodos() {
        return  votacaoService.consultaTodos();
    }

    @GetMapping(path = "/grafico")
    public ResponseEntity<List<GraficoDto>> consultaGrafico() {
        return  votacaoService.consultaGrafico();
    }
}
