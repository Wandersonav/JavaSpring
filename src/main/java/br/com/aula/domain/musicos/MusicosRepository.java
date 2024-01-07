package br.com.aula.domain.musicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicosRepository extends JpaRepository<Musicos,Long> {
    // JpaRepository: essa interface está vazia. Mas elas já têm métodos que estão sendo herdados.
    // CRUD
}
