package api.igreja_on.usuario.controller;

import api.igreja_on.usuario.infra.security.TokenService;
import api.igreja_on.usuario.model.AuthenticationDTO;
import api.igreja_on.usuario.model.LoginResponseDTO;
import api.igreja_on.usuario.model.RegistrarDTO;
import api.igreja_on.usuario.model.Usuario;
import api.igreja_on.usuario.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernameSenha = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = authenticationManager.authenticate(usernameSenha);

        var token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistrarDTO data){
        if(this.usuarioRepository.findByLogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedSenha = new BCryptPasswordEncoder().encode(data.senha());
        Usuario usuario = new Usuario(data.login(), encryptedSenha, data.dtNascimento(), data.role());
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

}
