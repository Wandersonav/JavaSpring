package br.com.aula.domain.instrumentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstrumentosRepository extends JpaRepository <Instrumentos, Long> {

}
