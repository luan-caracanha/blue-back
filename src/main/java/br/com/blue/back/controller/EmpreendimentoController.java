package br.com.blue.back.controller;

import br.com.blue.back.model.Empreendimento;
import br.com.blue.back.service.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/empreendimento")
public class EmpreendimentoController {

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Empreendimento> consultaPorId(@PathVariable Long id) {
        return  empreendimentoService.consultaPorId(id);
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Empreendimento>> consultaTodos() {
        return  empreendimentoService.consultaTodos();
    }
}
