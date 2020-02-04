package br.com.blue.back.service;

import br.com.blue.back.model.Usuario;
import br.com.blue.back.repository.UsuarioRepository;
import br.com.blue.back.dto.AutenticarDto;
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
            if (usuario.getId() == null && usuario.getEmail() != null) {
                Usuario usuarioValidacao = consultaPorEmail(usuario.getEmail().toLowerCase());
                if (usuarioValidacao != null) {
                    return new ResponseEntity("Usuário já cadastrado com o email informado", HttpStatus.BAD_REQUEST);
                }
            }

            usuario.setEmail(usuario.getEmail().toLowerCase());
            usuario.setNome(usuario.getNome().toUpperCase());
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

    public Usuario consultaPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public ResponseEntity<Usuario> aunteticar(AutenticarDto autenticarDto) {
        if (autenticarDto.getEmail() != null && autenticarDto.getSenha() != null) {
            try {
                Usuario usuario = usuarioRepository.findByEmailAndSenha(autenticarDto.getEmail().toLowerCase(),
                        geraHashSenha(autenticarDto.getSenha()));

                if (usuario == null) {
                    return new ResponseEntity("Falha ao fazer login, verifique o email e senha", HttpStatus.BAD_REQUEST);
                }

                return ResponseEntity.ok(usuario);

            } catch (NoSuchAlgorithmException e) {
                logger.error(e.getMessage());
                return new ResponseEntity("Falha ao fazer login, verifique o email e senha", HttpStatus.BAD_REQUEST);
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage());
                return new ResponseEntity("Falha ao fazer login, verifique o email e senha", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Informe o email e a senha", HttpStatus.BAD_REQUEST);
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
