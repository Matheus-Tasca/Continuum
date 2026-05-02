package continuum;
public class Rastreamento {
    private int numLote;
    private int idEmpresa;
    private int cdStatusLote;
    private String cdCorreios;

    public Rastreamento(int numLote, int idEmpresa, int cdStatusLote, String cdCorreios) {
        this.numLote = numLote;
        this.idEmpresa = idEmpresa;
        this.cdStatusLote = cdStatusLote;
        this.cdCorreios = cdCorreios;
    }

    public int getNumLote() { return numLote; }
    public void setNumLote(int numLote) { this.numLote = numLote; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }

    public int getCdStatusLote() { return cdStatusLote; }
    public void setCdStatusLote(int cdStatusLote) { this.cdStatusLote = cdStatusLote; }

    public String getCdCorreios() { return cdCorreios; }
    public void setCdCorreios(String cdCorreios) { this.cdCorreios = cdCorreios; }

    public String gerarLinkCorreios() {
        return "https://rastreamento.correios.com.br/app/index.php?objeto=" + cdCorreios;
    }

}