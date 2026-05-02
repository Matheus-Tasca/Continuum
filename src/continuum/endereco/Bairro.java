package continuum.endereco;
        
public class Bairro {
    private int idBairro;
    private String nmBairro;
    private int idCidade;

    public Bairro(int idBairro, String nmBairro, int idCidade) {
        this.idBairro = idBairro;
        this.nmBairro = nmBairro;
        this.idCidade = idCidade;
    }

    public int getIdBairro() { return idBairro; }
    public void setIdBairro(int idBairro) { this.idBairro = idBairro; }

    public String getNmBairro() { return nmBairro; }
    public void setNmBairro(String nmBairro) { this.nmBairro = nmBairro; }

    public int getIdCidade() { return idCidade; }
    public void setIdCidade(int idCidade) { this.idCidade = idCidade; }
}

