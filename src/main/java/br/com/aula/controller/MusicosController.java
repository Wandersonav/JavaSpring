package br.com.aula.controller;
import br.com.aula.domain.musicos.DadosAlteracaoMusicos;
import br.com.aula.domain.musicos.DadosCadastroMusicos;
import br.com.aula.domain.musicos.Musicos;
import br.com.aula.domain.musicos.MusicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/musicos")
public class MusicosController {
    @Autowired
    private MusicosRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model ) {
        if (id != null) {
            var musicos = repository.getReferenceById(id);
            model.addAttribute("musicos",musicos);
        }
        return "musicos/formulario";
    }
    @GetMapping("/listagem")
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "musicos/listagem";
    }
    @PostMapping
    @Transactional
    public String cadastraMusicos(DadosCadastroMusicos dados) {
        var musicos = new Musicos(dados);

        repository.save(musicos);

        return "redirect:/musicos/listagem";
    }
    @PutMapping
    @Transactional
    public String alteraMusicos(DadosAlteracaoMusicos dados){
        var musico = repository.getReferenceById(dados.id());
        musico.atualizaDados(dados);


        return "redirect:/musicos/listagem";

    }
    @DeleteMapping
    @Transactional
    public String removeMusicos(long id){
        repository.deleteById(id);
        return "redirect:/musicos/listagem";


    }

}
