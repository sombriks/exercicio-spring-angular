package exercicio.java.angular.backend.documentos.service;

import exercicio.java.angular.backend.documentos.model.Documento;

import java.util.List;
import java.util.Optional;

public interface IDocumentoService {

    List<Documento> listAll(Long setorId, Long pastaId, String q);

    Optional<Documento> findById(Long setorId, Long pastaId, Long id);
}
