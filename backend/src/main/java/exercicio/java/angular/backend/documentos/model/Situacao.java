package exercicio.java.angular.backend.documentos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="estados_documento")
public class Situacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
