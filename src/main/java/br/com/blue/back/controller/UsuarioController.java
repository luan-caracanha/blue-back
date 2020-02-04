package br.com.blue.back.controller;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.service.UsuarioService;
import br.com.blue.back.dto.AutenticarDto;
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

    @PostMapping(path = "/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return  usuarioService.salvar(usuario);
    }

    @PostMapping(path = "/autenticar")
    public ResponseEntity<Usuario> autenticar(@RequestBody AutenticarDto autenticarDto) {
        return  usuarioService.aunteticar(autenticarDto);
    }
}
