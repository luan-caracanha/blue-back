package br.com.blue.back.service;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Usuario> consultaPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return new ResponseEntity("Usuário não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Usuario> salvar(Usuario usuario) {
        try {
            usuario.setSenha(geraHashSenha(usuario.getSenha()));
            usuarioRepository.saveAndFlush(usuario);

            return ResponseEntity.ok(usuario);

        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
            return new ResponseEntity("Erro ao salvar usuário", HttpStatus.BAD_REQUEST);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            return new ResponseEntity("Erro ao salvar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    protected String geraHashSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();
    }

}
