package exercicio.java.angular.backend.documentos.service.impl;

import exercicio.java.angular.backend.documentos.model.Documento;
import exercicio.java.angular.backend.documentos.repository.DocumentoRepository;
import exercicio.java.angular.backend.documentos.service.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService implements IDocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Override
    public List<Documento> listAll(Long setorId, Long pastaId, String q) {
        return repository.listAll(setorId, pastaId, q);
    }

    @Override
    public Optional<Documento> findById(Long setorId, Long pastaId, Long id) {
        return repository.findById(setorId, pastaId, id);
    }

}
