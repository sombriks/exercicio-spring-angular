package exercicio.java.angular.backend.pastas.controller;

import exercicio.java.angular.backend.pastas.model.Pasta;
import exercicio.java.angular.backend.pastas.service.IPastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("setores/{setorId}/pastas")
public class PastaController {

    @Autowired
    private IPastaService service;

    @GetMapping
    public List<Pasta> listAll(
            @PathVariable(name = "setorId") Long setorId,
            @RequestParam(defaultValue = "") String q) {
        return service.listAll(setorId, q);
    }

    @GetMapping("{id}")
    public Pasta findById(
            @PathVariable(name = "setorId") Long setorId,
            @PathVariable(name = "id") Long id) {
        return service.findById(setorId, id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
