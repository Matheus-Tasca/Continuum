package continuum.endereco;

public class Cidade {
    private static int contadorId = 0;
    private int idCidade;
    private String nmCidade;
    private int idEstado;

    public Cidade(String nmCidade, int idEstado) {
        contadorId++;
        this.idCidade = contadorId;
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