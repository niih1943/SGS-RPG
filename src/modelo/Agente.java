package modelo;

public class Agente {
    private int id;
    private String nome;
    private String codinome;
    private String classe;
    private int nivel;
    private int vida;
    private int sanidade;
    private String origem;
    private String status; 
    
    public Agente(int id, String nome, String codinome, String classe, int nivel, int vida, int sanidade, String origem, String status) {
        this.id = id;
        this.nome = nome;
        this.codinome = codinome;
        this.classe = classe;
        this.nivel = nivel;
        this.vida = vida;
        this.sanidade = sanidade;
        this.origem = origem;
        this.status = status;
    }
    
    // método para aplicar penalidade de sanidade
    public void reduzirSanidade(int pontos) {
        this.sanidade -= pontos;
        if (this.sanidade <=0) {
            this.sanidade = 0;
            this.status = "Inconsciente";
            System.out.println("ALERTA: O Agente " + codinome + "enlouqueceu ou ficou inconsciente!");
        }
    }
    
    public int getId() {return id;}
    public void setId(int id) { this.id = id;}
    public String getNome(){return nome;}
    public void setNome(String nome) { this.nome = nome;}
    public String getCodinome() {return codinome;}
    public void setCodinome(String codinome) { this.codinome = codinome;}
    public String getClasse() {return classe;}
    public int getNivel() {return nivel;}
    public void setNivel(int nivel) { this.nivel = nivel;}
    public void setClasse(String classe) { this.classe = classe;}
    public int getVida() {return vida;}
    public void setVida(int vida) { this.vida = vida;}
    public int getSanidade() {return sanidade;}
    public void setSanidade(int sanidade) { this.sanidade = sanidade;}
    public String getOrigem(){return origem;}
    public void setOrigem(String origem) { this.origem = origem;}
    public String getStatus() {return status;}
    public void setStatus(String status) { this.status = status;}
    
}