package exercicio.java.angular.backend.pastas.repository;

import exercicio.java.angular.backend.pastas.model.Pasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PastaRepository extends JpaRepository<Pasta,Long> {

    @Query("select p from Pasta p where p.setor.id = :setorId and upper(p.nome) like '%'||upper(:q)||'%'")
    List<Pasta> listAll(Long setorId, String q);

    @Query("select p from Pasta p where p.setor.id = :setorId and  p.id = :id")
    Optional<Pasta> findById(Long setorId, Long id);
}
