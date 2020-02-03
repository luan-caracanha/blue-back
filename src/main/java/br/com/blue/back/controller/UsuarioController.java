package br.com.blue.back.controller;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id) {
        return  usuarioService.consultaPorId(id);
    }
}
