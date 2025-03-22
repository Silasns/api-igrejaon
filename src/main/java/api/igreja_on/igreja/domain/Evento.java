package api.igreja_on.igreja.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name="eventos")
@Entity(name="eventos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private String local;
    @OneToOne
    @JoinColumn(name = "id")
    private Horario horario;

}
