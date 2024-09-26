package br.com.aula.controller;

import br.com.aula.domain.instrumentos.DadosAlteracaoInstrumentos;
import br.com.aula.domain.instrumentos.DadosCadastroInstrumentos;
import br.com.aula.domain.instrumentos.Instrumentos;
import br.com.aula.domain.instrumentos.InstrumentosRepository;
import br.com.aula.domain.musicos.MusicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instrumentos")
public class InstrumentosController {
    @Autowired
    private InstrumentosRepository repository;
    @Autowired
    private MusicosRepository musicosRepository;

    @GetMapping("/paginaInicial")
    public String listarInstrumentos(Model model) {
        List<Instrumentos> instrumentos = repository.findAll(); // Busca todos os instrumentos
        model.addAttribute("instrumentos", instrumentos); // Adiciona a lista de instrumentos ao modelo
        return "paginaInicial"; // Nome da sua view
    }

    @GetMapping("/formularioInstrumentos")
    public String carregaPaginaFormulario(Long id, Model model ) {
        if (id != null) {
            var instrumentos = repository.getReferenceById(id);
            model.addAttribute("instrumentos",instrumentos);
        }
        return "instrumentos/formularioInstrumentos";
    }
    @GetMapping("/listagemInstrumentos")
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "instrumentos/listagemInstrumentos";
    }
    @PostMapping
    @Transactional
public String cadastroInstrumento (DadosCadastroInstrumentos dados){
        var instrumentos = new Instrumentos(dados);
        repository.save(instrumentos);
        
        return "redirect:instrumentos/listagemInstrumentos";

}
@PutMapping
@Transactional
public String alteraInstrumento(DadosAlteracaoInstrumentos dados){
        var instrumentos = repository.getReferenceById(dados.id());
        instrumentos.atualizaDados(dados);
    return "redirect:instrumentos/listagemInstrumentos";
}
    @DeleteMapping
    @Transactional
    public String removeMusicos(long id) {
        musicosRepository.deleteByInstrumentosId(id);
        repository.deleteById(id);
        return "redirect:instrumentos/listagemInstrumentos";
    }

}
