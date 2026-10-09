package modelo;

public class Ameaca {

    private int id;
    private String nome;
    private String tipo;
    private String elemento;
    private int nivelAmeaca;
    private String statusAparicao;

    public Ameaca(int id, String nome, String tipo, String elemento,
            int nivelAmeaca, String statusAparicao) {

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.elemento = elemento;
        this.nivelAmeaca = nivelAmeaca;
        this.statusAparicao = statusAparicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getNivelAmeaca() {
        return nivelAmeaca;
    }

    public void setNivelAmeaca(int nivelAmeaca) {
        this.nivelAmeaca = nivelAmeaca;
    }

    public String getStatusAparicao() {
        return statusAparicao;
    }

    public void setStatusAparicao(String statusAparicao) {
        this.statusAparicao = statusAparicao;
    }
}
