package exercicio.java.angular.backend.pastas.service.impl;

import exercicio.java.angular.backend.pastas.model.Pasta;
import exercicio.java.angular.backend.pastas.repository.PastaRepository;
import exercicio.java.angular.backend.pastas.service.IPastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PastaService implements IPastaService {

    @Autowired
    private PastaRepository repository;

    @Override
    public List<Pasta> listAll(Long setorId, String q) {
        return repository.listAll(setorId, q);
    }

    @Override
    public Optional<Pasta> findById(Long setorId, Long id) {
        return repository.findById(setorId, id);
    }
}
