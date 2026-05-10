package continuum.casosDeUsoDoador;

import continuum.BdMock;


public class VisualizarDescontos {
    BdMock bd;
    
    public VisualizarDescontos(BdMock bd){
        this.bd = bd;
    }
    
    public void executar(){
        bd.getDescontosNaoUtilizados();
    }
}
