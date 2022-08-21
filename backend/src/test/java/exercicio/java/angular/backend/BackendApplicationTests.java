package exercicio.java.angular.backend;

import exercicio.java.angular.backend.documentos.model.Documento;
import exercicio.java.angular.backend.documentos.model.Situacao;
import exercicio.java.angular.backend.documentos.repository.DocumentoRepository;
import exercicio.java.angular.backend.documentos.repository.SituacaoRepository;
import exercicio.java.angular.backend.documentos.service.IDocumentoService;
import exercicio.java.angular.backend.pastas.model.Pasta;
import exercicio.java.angular.backend.pastas.service.IPastaService;
import exercicio.java.angular.backend.setores.model.Setor;
import exercicio.java.angular.backend.setores.service.ISetorService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private ISetorService setorService;

    @Autowired
    private IPastaService pastaService;

    @Autowired
    private IDocumentoService documentoService;

    @Autowired
    private SituacaoRepository situacaoRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void deveriaListarSetores() {
        List<Setor> result = setorService.listAll("");

        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void deveriaRecuperarSetorVendas() {
        Setor result = setorService.findById(2L).get();

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Vendas", result.getNome());
    }

    @Test
    public void deveriaListarPastas() {
        List<Pasta> result = pastaService.listAll(1L, "");

        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void deveriaRecuperarPastaPrioritaria() {
        Pasta result = pastaService.findById(2L, 3L).get();

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Prioritário", result.getNome());
    }

    @Test
    public void deveriaCriarDocumento() {
        Documento doc = new Documento();
        doc.setTitulo("documento de teste");
        Documento result = documentoService.insert(1L, 1L, doc);

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertNotNull(result.getSituacao());
        Assertions.assertNotNull(result.getPasta());
    }

    @Test
    public void deveriaListarDocumentos() {
        Documento doc = new Documento();
        doc.setTitulo("documento de teste");
        documentoService.insert(1L, 1L, doc);

        List<Documento> result = documentoService.listAll(1L, 1L, "");

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void deveriaRecuperarUmDocumento() {
        Documento doc = new Documento();
        doc.setTitulo("documento de teste");
        doc = documentoService.insert(1L, 1L, doc);

        Documento result = documentoService.findById(1L, 1L, doc.getId()).get();

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    @Transactional
    public void deveriaAtualizarUmDocumento() {
        Documento doc = new Documento();
        doc.setTitulo("documento de teste");
        documentoService.insert(1L, 1L, doc);

        documentoService.update(1L, 2L, doc);

        Situacao transferido = situacaoRepository.findById(Situacao.TRANSFERIDO).get();

        Documento result = documentoRepository.getReferenceById(doc.getId());

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(transferido, result.getSituacao());

    }

}
