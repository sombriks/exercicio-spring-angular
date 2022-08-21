package exercicio.java.angular.backend.documentos.repository;

import exercicio.java.angular.backend.documentos.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("select d from Documento d where d.pasta.setor.id = :setorId and d.pasta.id = :pastaId and upper(d.titulo) like '%'||upper(:q)||'%'")
    List<Documento> listAll(Long setorId, Long pastaId, String q);

    @Query("select d from Documento d where d.pasta.setor.id = :setorId and d.pasta.id = :pastaId and d.id = :id")
    Optional<Documento> findById(Long setorId, Long pastaId, Long id);
}
