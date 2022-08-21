package exercicio.java.angular.backend.setores.controller;

import exercicio.java.angular.backend.setores.model.Setor;
import exercicio.java.angular.backend.setores.service.ISetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("setores")
public class SetorController {

    @Autowired
    private ISetorService service;

    @GetMapping
    public List<Setor> listAll(@RequestParam(defaultValue = "") String q) {
        return service.listAll(q);
    }

    @GetMapping("{id}")
    public Setor findById(@PathVariable("id") Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
