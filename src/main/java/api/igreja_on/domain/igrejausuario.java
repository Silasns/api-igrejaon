package api.igreja_on.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name="igrejausuario")
@Entity(name="igreja")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class igrejausuario {

    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String login;

    private Number senha;

    private String dtNascimento;

    private String role;

    public igrejausuario(Requestigrejausuario requestigrejausuario) {
        this.login = requestigrejausuario.login();
        this.senha = requestigrejausuario.senha();
        this.dtNascimento = requestigrejausuario.dtNascimento();
        this.role = requestigrejausuario.role();
    }
}
