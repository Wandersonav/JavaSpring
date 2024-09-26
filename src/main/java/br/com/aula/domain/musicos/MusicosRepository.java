package br.com.aula.domain.musicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MusicosRepository extends JpaRepository<Musicos, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Musicos m WHERE m.instrumento.id = ?1")
    void deleteByInstrumentosId(long instrumentosID);
}
