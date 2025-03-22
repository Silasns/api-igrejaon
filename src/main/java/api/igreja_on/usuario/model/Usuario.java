package api.igreja_on.usuario.model;

import api.igreja_on.usuario.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String login;
    private String senha;
    private String dtNascimento;
    private UserRole role;

    public Usuario(String login, String senha, String dtNascimento, UserRole role) {
        this.login = login;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"),
                    new SimpleGrantedAuthority("ROLE_MODERATOR"));
        } else if (this.role == UserRole.MODERATOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_MODERATOR"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {return List.of(new SimpleGrantedAuthority("ROLE_USER"));}
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
