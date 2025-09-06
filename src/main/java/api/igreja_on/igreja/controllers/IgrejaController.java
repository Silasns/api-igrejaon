package api.igreja_on.igreja.controllers;

import api.igreja_on.igreja.domain.Requestigrejausuario;
import api.igreja_on.igreja.domain.UsuarioRepository;
import api.igreja_on.igreja.domain.igrejausuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/igreja")
public class IgrejaController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity getALLigreja() {
        var alligreja = repository.findAll();
        return ResponseEntity.ok(alligreja);
    }

    @PostMapping
    public ResponseEntity registerigrejausuario(@RequestBody @Valid Requestigrejausuario data){
        igrejausuario newIgrejausuario = new igrejausuario(data);
        repository.save(newIgrejausuario);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateigrejausuario(@PathVariable String id, @RequestBody @Valid Requestigrejausuario data){
        System.out.println(data);
        igrejausuario igrejaUsuario = repository.getReferenceById(id);
        igrejaUsuario.setLogin(data.login());
        igrejaUsuario.setSenha(data.senha());
        igrejaUsuario.setDtNascimento(data.dtNascimento());
        igrejaUsuario.setRole(data.role());
        return ResponseEntity.ok(igrejaUsuario);
    }
}
