package api.igreja_on.usuario.model;

import java.util.UUID;

public record Usuario(
        UUID id,
        String nome,
        String email,
        String dtNascimento,
        String senha,

) {
}
