package exercicio.java.angular.backend.setores.service;

import exercicio.java.angular.backend.setores.model.Setor;

import java.util.List;
import java.util.Optional;

public interface ISetorService {

    List<Setor> listAll(String q);

    Optional<Setor> findById(Long id);
}
