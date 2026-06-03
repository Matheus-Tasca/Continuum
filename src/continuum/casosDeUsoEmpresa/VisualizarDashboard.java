
package continuum.casosDeUsoEmpresa;

import continuum.BdMock;
import continuum.utilitarios.Constantes;


public class VisualizarDashboard {
    BdMock bd;
    
    public VisualizarDashboard(BdMock bd){
        this.bd = bd;
    }
    
    public void executar(int idEmpresa){
        System.out.println("--- LOTES DISPONIVEIS ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_DISPONIVEL, idEmpresa);
    
        System.out.println("\n--- LOTES AGUARDANDO ENVIO ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_AGUARDANDO_ENVIO, idEmpresa);
    
        System.out.println("\n--- LOTES RESERVADOS ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_RESERVADO, idEmpresa);
    
    }
}
