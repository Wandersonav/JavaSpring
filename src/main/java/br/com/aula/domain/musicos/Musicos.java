package br.com.aula.domain.musicos;
import jakarta.persistence.*;
@Entity
@Table(name = "musicos")
public class Musicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String instrumentos;
    private String familia_instrumento;
    private String fase;

    public Musicos(DadosCadastroMusicos dados) {
        this.nome = dados.nome();
        this.instrumentos = dados.instrumento();
        this.familia_instrumento = dados.familiaInstrumento();
        this.fase = dados.fase();
    }

    public Musicos() {

    }

    @Override
    public String toString() {
        return "Musicos{" +
                "nome='" + nome + '\'' +
                ", instrumentos=" + instrumentos +
                ", familia_instrumento=" + familia_instrumento +
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

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }

    public String getFamilia_instrumento() {
        return familia_instrumento;
    }

    public void setFamilia_instrumento(String familia_instrumento) {
        this.familia_instrumento = familia_instrumento;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public void atualizaDados(DadosAlteracaoMusicos dados){
        this.nome = dados.nome();
        this.instrumentos = dados.instrumento();
        this.familia_instrumento = dados.familiaInstrumento();
        this.fase = dados.fase();
    }

}
