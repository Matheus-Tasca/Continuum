package continuum.casosDeUsoDoador;

import continuum.BdMock;


public class VisualizarDescontos {
    BdMock bd;
    boolean doadorLogado;
    
    public VisualizarDescontos(BdMock bd, boolean doadorLogado){
        this.bd = bd;
        this.doadorLogado = doadorLogado;
    }
    
    public void executar(){
        if(!doadorLogado){
            System.out.println("O doador deve estar logado");
            return;
        }
        
        bd.getDescontosNaoUtilizados();
    }
}
