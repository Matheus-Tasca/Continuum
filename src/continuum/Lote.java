package continuum;
public class Lote {
    private static int contadorIdLote = 0;
    private int idLote;
    private int numLote;
    private int cdStatusLote;
    private int idEmpresa;
    private String descItens;
    private double pesoLote;

    public Lote(int numLote, int cdStatusLote, int idEmpresa, String descItens, double pesoLote) {
        contadorIdLote++;
        this.idLote = contadorIdLote;
        this.numLote = numLote;
        this.cdStatusLote = cdStatusLote;
        this.idEmpresa = idEmpresa;
        this.descItens = descItens;
        this.pesoLote = pesoLote;
    }

    public int getIdLote() { return idLote; }
    public void setIdLote(int idLote) { this.idLote = idLote; }

    public int getNumLote() { return numLote; }
    public void setNumLote(int numLote) { this.numLote = numLote; }

    public int getCdStatusLote() { return cdStatusLote; }
    public void setCdStatusLote(int cdStatusLote) { this.cdStatusLote = cdStatusLote; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getDescItens() { return descItens; }
    public void setDescItens(String descItens) { this.descItens = descItens; }

    public double getPesoLote() { return pesoLote; }
    public void setPesoLote(double pesoLote) { this.pesoLote = pesoLote; }

    public void atualizarPeso(double[] pesosItens) {
        double total = 0.0;
        if (pesosItens != null) {
            for (double p : pesosItens) total += p;
        }
        this.pesoLote = total;
    }

    public void alterarStatusLote(int novoStatus) {
        this.cdStatusLote = novoStatus;
        System.out.println("Lote " + idLote + " status atualizado para " + cdStatusLote);
    }
}