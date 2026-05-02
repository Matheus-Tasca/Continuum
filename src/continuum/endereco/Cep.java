package continuum.endereco;

public class Cep {
    private String cep;
    private String logradouro;
    private int idBairro;

    public Cep(String cep, String logradouro, int idBairro) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.idBairro = idBairro;
    }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public int getIdBairro() { return idBairro; }
    public void setIdBairro(int idBairro) { this.idBairro = idBairro; }
}