package continuum.endereco;

public class Cidade {
    private int idCidade;
    private String nmCidade;
    private int idEstado;

    public Cidade(int idCidade, String nmCidade, int idEstado) {
        this.idCidade = idCidade;
        this.nmCidade = nmCidade;
        this.idEstado = idEstado;
    }

    public int getIdCidade() { return idCidade; }
    public void setIdCidade(int idCidade) { this.idCidade = idCidade; }

    public String getNmCidade() { return nmCidade; }
    public void setNmCidade(String nmCidade) { this.nmCidade = nmCidade; }

    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }
}