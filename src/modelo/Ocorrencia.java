package modelo;

public class Ocorrencia {

    private int id;
    private String descricao;
    private String impactoNarrativo;
    private String impactoSanidade;
    private int missaoId;
    private int ameacaId;

    public Ocorrencia(int id, String descricao, String impactoNarrativo,
            String impactoSanidade, int missaoId, int ameacaId) {

        this.id = id;
        this.descricao = descricao;
        this.impactoNarrativo = impactoNarrativo;
        this.impactoSanidade = impactoSanidade;
        this.missaoId = missaoId;
        this.ameacaId = ameacaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImpactoNarrativo() {
        return impactoNarrativo;
    }

    public void setImpactoNarrativo(String impactoNarrativo) {
        this.impactoNarrativo = impactoNarrativo;
    }

    public String getImpactoSanidade() {
        return impactoSanidade;
    }

    public void setImpactoSanidade(String impactoSanidade) {
        this.impactoSanidade = impactoSanidade;
    }

    public int getMissaoId() {
        return missaoId;
    }

    public void setMissaoId(int missaoId) {
        this.missaoId = missaoId;
    }

    public int getAmeacaId() {
        return ameacaId;
    }

    public void setAmeacaId(int ameacaId) {
        this.ameacaId = ameacaId;
    }
}
