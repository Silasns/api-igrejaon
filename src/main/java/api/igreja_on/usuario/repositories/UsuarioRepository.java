package api.igreja_on.usuario.repositories;

import api.igreja_on.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    UserDetails findByLogin(String login);
}
