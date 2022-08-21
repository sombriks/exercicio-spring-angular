package exercicio.java.angular.backend.pastas.service;

import exercicio.java.angular.backend.pastas.model.Pasta;

import java.util.List;
import java.util.Optional;

public interface IPastaService {

    List<Pasta> listAll(Long setorId, String q);

    Optional<Pasta> findById(Long setorId, Long id);
}
