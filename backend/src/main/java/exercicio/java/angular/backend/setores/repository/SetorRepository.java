package exercicio.java.angular.backend.setores.repository;

import exercicio.java.angular.backend.setores.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

    @Query("select s from Setor s where upper(s.nome) like '%'||upper(:q)||'%'")
    List<Setor> listAll(String q);
}
