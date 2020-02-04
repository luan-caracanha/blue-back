package br.com.blue.back.controller;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/empreendimento")
public class EmpreendimentoController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id) {
        return  usuarioService.consultaPorId(id);
    }
}