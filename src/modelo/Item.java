package modelo;

public class Item {

    private int id;
    private String nome;
    private String categoria;
    private String efeito;
    private int nivelPerigo;
    private String status;
    private int agenteId;

    public Item(int id, String nome, String categoria, String efeito,
            int nivelPerigo, String status, int agenteId) {

        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.efeito = efeito;
        this.nivelPerigo = nivelPerigo;
        this.status = status;
        this.agenteId = agenteId;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public int getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(int nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAgenteId() {
        return agenteId;
    }

    public void setAgenteId(int agenteId) {
        this.agenteId = agenteId;
    }
}
