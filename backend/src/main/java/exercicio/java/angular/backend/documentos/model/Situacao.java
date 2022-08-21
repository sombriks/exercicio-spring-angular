package exercicio.java.angular.backend.documentos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="estados_documento")
public class Situacao {

    public static final Long NOVO = 1L;

    public static final Long TRANSFERIDO = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
