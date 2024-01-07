package br.com.aula.controller;

import br.com.aula.domain.instrumentos.InstrumentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instrumentos")
public class InstrumentosController {
    @Autowired
    private InstrumentosRepository repository;

    @GetMapping("/formularioInstrumentos")
    public String carregaPaginaFormulario(Long id, Model model ) {
        if (id != null) {
            var musicos = repository.getReferenceById(id);
            model.addAttribute("musicos",musicos);
        }
        return "musicos/formulario";
    }

}
