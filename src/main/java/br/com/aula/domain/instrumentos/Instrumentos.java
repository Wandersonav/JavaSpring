
package br.com.aula.domain.instrumentos;
import jakarta.persistence.*;

@Entity
@Table(name = "instrumentos")
public class Instrumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String voz;
    private String familia_instrumento;


public Instrumentos(DadosCadastroInstrumentos dados){
            this.nome = dados.nome();
            this.voz = dados.voz();
            this.familia_instrumento = dados.familia_instrumento();
}

    public Instrumentos() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVoz() {
        return voz;
    }

    public void setVoz(String voz) {
        this.voz = voz;
    }

    public String getFamilia_instrumento() {
        return familia_instrumento;
    }

    public void setFamilia_instrumento(String familia_instrumento) {
        this.familia_instrumento = familia_instrumento;
    }

    @Override
    public String toString() {
        return "instrumentos{" +
                "nome='" + nome + '\'' +
                ", instrumentos=" + voz +
                ", familia_instrumento=" + familia_instrumento +
                '}';
    }
    public void atualizaDados(DadosAlteracaoInstrumentos dados){
    this.nome = dados.nome();
    this.voz = dados.voz();
    this.familia_instrumento = dados.familia_instrumento();

    }
}