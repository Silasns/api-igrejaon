package api.igreja_on.controllers.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/igreja")
public class Controller {
    @GetMapping
    public ResponseEntity getALLigreja() {
        return ResponseEntity.ok("Tudo certo");
    }
}
