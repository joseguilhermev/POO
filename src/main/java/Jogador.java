import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Jogador {
    @Id
    private Long id;
    private String nome;
    private String funcao;
    private String time;
    private String patente;

    // Construtores, getters e setters
    public Jogador() {
    }

    public Jogador(String nome, String funcao, String time, String patente) {
        this.nome = nome;
        this.funcao = funcao;
        this.time = time;
        this.patente = patente;
    }

    // Getters e setters para cada campo
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

     public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

     public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

     public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    // Método personalizado para imprimir dados do jogador
    public void imprimirDados() {
        System.out.println("Nome: " + nome + ", Função: " + funcao + ", Time: " + time + ", Patente: " + patente);
    }
}
