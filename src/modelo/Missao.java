package modelo;

public class Missao {

    private int id;
    private String titulo;
    private int equipeId;
    private String local;
    private String grauRisco;
    private String status;
    private String inicio;
    private String fim;

    public Missao(int id, String titulo, int equipeId, String local,
            String grauRisco, String status, String inicio, String fim) {

        this.id = id;
        this.titulo = titulo;
        this.equipeId = equipeId;
        this.local = local;
        this.grauRisco = grauRisco;
        this.status = status;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGrauRisco() {
        return grauRisco;
    }

    public void setGrauRisco(String grauRisco) {
        this.grauRisco = grauRisco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
}
