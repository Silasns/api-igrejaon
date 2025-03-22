package api.igreja_on.usuario.model;

import api.igreja_on.usuario.enums.UserRole;

public record RegistrarDTO(
        String login,
        String senha,
        String dtNascimento,
        UserRole role
) {
}
