package br.com.blue.back.service;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Usuario> consultaPorId(Long id) {
        Optional<Usuario> usuario  = usuarioRepository.findById(id);
        if (usuario.isPresent())
            return ResponseEntity.ok(usuario.get());
        else return new ResponseEntity("Usuário não encontrado", HttpStatus.BAD_REQUEST);
    }

}
