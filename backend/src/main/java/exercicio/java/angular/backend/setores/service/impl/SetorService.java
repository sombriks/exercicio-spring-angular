package exercicio.java.angular.backend.setores.service.impl;

import exercicio.java.angular.backend.setores.model.Setor;
import exercicio.java.angular.backend.setores.repository.SetorRepository;
import exercicio.java.angular.backend.setores.service.ISetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService implements ISetorService {

    @Autowired
    private SetorRepository repository;

    @Override
    public List<Setor> listAll(String q) {
        return repository.listAll(q);
    }

    @Override
    public Optional<Setor> findById(Long id) {
        return repository.findById(id);
    }
}
