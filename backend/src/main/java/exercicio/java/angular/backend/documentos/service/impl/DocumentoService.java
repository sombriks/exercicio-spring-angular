package exercicio.java.angular.backend.documentos.service.impl;

import exercicio.java.angular.backend.documentos.model.Documento;
import exercicio.java.angular.backend.documentos.model.Situacao;
import exercicio.java.angular.backend.documentos.repository.DocumentoRepository;
import exercicio.java.angular.backend.documentos.repository.SituacaoRepository;
import exercicio.java.angular.backend.documentos.service.IDocumentoService;
import exercicio.java.angular.backend.pastas.model.Pasta;
import exercicio.java.angular.backend.pastas.repository.PastaRepository;
import exercicio.java.angular.backend.setores.model.Setor;
import exercicio.java.angular.backend.setores.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService implements IDocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Autowired
    private PastaRepository pastaRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private SituacaoRepository situacaoRepository;

    @Override
    public List<Documento> listAll(Long setorId, Long pastaId, String q) {
        return repository.listAll(setorId, pastaId, q);
    }

    @Override
    public Optional<Documento> findById(Long setorId, Long pastaId, Long id) {
        return repository.findById(setorId, pastaId, id);
    }

    @Override
    @Transactional
    public Documento insert(Long setorId, Long pastaId, Documento documento) {
        Pasta pasta = validacoes(setorId, pastaId);
        documento.setPasta(pasta);
        Situacao novo = situacaoRepository.findById(Situacao.NOVO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "situação inválida"));
        documento.setSituacao(novo);
        return repository.save(documento);
    }

    @Override
    @Transactional
    public Documento update(Long setorId, Long pastaId, Documento documento) {
        Pasta pasta = validacoes(setorId, pastaId);
        Documento existente = repository.findById(documento.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "documento não existe"));
        if (!existente.getPasta().equals(pasta)) {
            Situacao transferido = situacaoRepository.findById(Situacao.TRANSFERIDO)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "situação inválida"));
            documento.setSituacao(transferido);
        }
        existente.setTitulo(documento.getTitulo());
        return repository.save(existente);
    }

    private Pasta validacoes(Long setorId, Long pastaId) {
        Setor setor = setorRepository.findById(setorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "setor inválido"));
        Pasta pasta = pastaRepository.findById(pastaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "pasta inválida"));
        if (!pasta.getSetor().equals(setor))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "pasta de setor diferente");
        return pasta;
    }

}
