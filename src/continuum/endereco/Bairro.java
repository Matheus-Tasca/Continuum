package continuum.endereco;
        
public class Bairro {
    private static int contadorId = 0;
    private int idBairro;
    private String nmBairro;
    private int idCidade;

    public Bairro(String nmBairro, int idCidade) {
        contadorId++;
        this.idBairro = contadorId;
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

