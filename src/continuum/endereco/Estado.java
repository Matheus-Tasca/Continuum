package continuum.endereco;

public class Estado {
    private int idEstado;
    private String nmEstado;
    private String sgEstado;

    public Estado(int idEstado, String nmEstado, String sgEstado) {
        this.idEstado = idEstado;
        this.nmEstado = nmEstado;
        this.sgEstado = sgEstado;
    }

    public int getIdEstado() { return idEstado; }
    public void setIdEstado(int idEstado) { this.idEstado = idEstado; }

    public String getNmEstado() { return nmEstado; }
    public void setNmEstado(String nmEstado) { this.nmEstado = nmEstado; }

    public String getSgEstado() { return sgEstado; }
    public void setSgEstado(String sgEstado) { this.sgEstado = sgEstado; }
    
    public void obterNomeCompleto(){
        System.out.println(getNmEstado() + " - " + getSgEstado());
    }
}


