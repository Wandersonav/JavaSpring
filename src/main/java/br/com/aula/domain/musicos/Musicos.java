package br.com.aula.domain.musicos;
import br.com.aula.domain.instrumentos.Instrumentos;
import jakarta.persistence.*;
@Entity
@Table(name = "musicos")
public class Musicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fase;


    @ManyToOne
    @JoinColumn(name = "instrumentosID") // nome da coluna na tabela musicos
    private Instrumentos instrumento;

    public Musicos(DadosCadastroMusicos dados) {
        this.nome = dados.nome();
        this.fase = dados.fase();
    }

    public Musicos() {

    }

    @Override
    public String toString() {
        return "Musicos{" +
                "nome='" + nome + '\'' +
                ", fase='" + fase + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public void atualizaDados(DadosAlteracaoMusicos dados){
        this.nome = dados.nome();
        this.fase = dados.fase();
    }

}
