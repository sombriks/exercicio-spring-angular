package exercicio.java.angular.backend.documentos.model;

import exercicio.java.angular.backend.pastas.model.Pasta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estados_documento_id")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "pastas_id")
    private Pasta pasta;

    private String titulo;
}
