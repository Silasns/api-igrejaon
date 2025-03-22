package api.igreja_on.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Requestigrejausuario(String id,
                                   @NotBlank String login, Number senha,
                                   @NotNull String dtNascimento, String role) {

}
