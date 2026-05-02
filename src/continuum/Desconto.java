package continuum;

public class Desconto {
    private int idDesconto;
    private String cdDesconto;
    private String cpfDoador;
    private boolean utilizado;
    private double porcentagem;

    public Desconto(int idDesconto, String cdDesconto, String cpfDoador) {
        this.idDesconto = idDesconto;
        this.cdDesconto = cdDesconto;
        this.cpfDoador = cpfDoador;
        this.utilizado = false;
    }

    public int getIdDesconto() { return idDesconto; }
    public void setIdDesconto(int idDesconto) { this.idDesconto = idDesconto; }

    public String getCdDesconto() { return cdDesconto; }
    public void setCdDesconto(String cdDesconto) { this.cdDesconto = cdDesconto; }

    public String getCpfDoador() { return cpfDoador; }
    public void setCpfDoador(String cpfDoador) { this.cpfDoador = cpfDoador; }

    public boolean getUtilizado() { return utilizado; }
    public void setUtilizado(boolean utilizado) { this.utilizado = utilizado; }

    public double getPorcentagem() {return porcentagem;}

    public void setPorcentagem(double porcentagem) {this.porcentagem = porcentagem;}
    
    public void validarCodigoDesconto(String cdDesconto) {
        if(utilizado){
            System.out.println("Desconto ja utilizado pelo cpf " + getCpfDoador());
        }else{
            System.out.println("Desconto nao utilizado pelo cpf "+ getCpfDoador());
        }
    }
    
    public void utilizarCupom(){
        setUtilizado(true);
    }
}