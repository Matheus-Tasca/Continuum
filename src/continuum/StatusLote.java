package continuum;

public class StatusLote {
    private int cdStatusLote;
    private String descStatusLote;

    
    
    public StatusLote(int cdStatusLote, String descStatusLote) {
        this.cdStatusLote = cdStatusLote;
        this.descStatusLote = descStatusLote;
    }

    public int getCdStatusLote() { return cdStatusLote; }
    public void setCdStatusLote(int cdStatusLote) { this.cdStatusLote= cdStatusLote; }

    public String getDescStatusLote() { return descStatusLote; }
    public void setDescStatusLote(String descStatusLote) { this.descStatusLote = descStatusLote; }
    
    public void imprimeDescricaoStatus(int status){
        switch (status) {
            case 0: System.out.println("Lote disponivel"); 
            case 1: System.out.println("Lote em preparo");
            case 2: System.out.println("Lote em transporte para o estilista");
            case 3: System.out.println("Lote recebido pelo estilista");
            case 4: System.out.println("Lote em transporte para a loja");
            case 5: System.out.println("Lote recebido pela loja");
            default: System.out.println("Status nao encontrado");
        }  
    }
}
