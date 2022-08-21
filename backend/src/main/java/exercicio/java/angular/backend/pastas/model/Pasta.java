package exercicio.java.angular.backend.pastas.model;

import exercicio.java.angular.backend.setores.model.Setor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="pastas")
public class Pasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="setores_id")
    private Setor setor;

    private String nome;
}
