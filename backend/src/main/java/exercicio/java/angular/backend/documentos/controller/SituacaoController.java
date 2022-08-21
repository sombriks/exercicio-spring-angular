package exercicio.java.angular.backend.documentos.controller;

import exercicio.java.angular.backend.documentos.model.Situacao;
import exercicio.java.angular.backend.documentos.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("situacoes")
public class SituacaoController {

    @Autowired
    private SituacaoRepository repository;

    @GetMapping
    public List<Situacao> listAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Situacao findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
