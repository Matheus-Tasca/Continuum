
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
    
        System.out.println("--- LOTES EM PREPARO ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_EM_PREPARO, idEmpresa);
    
        System.out.println("--- LOTES AGUARDANDO ENVIO ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_AGUARDANDO_ENVIO, idEmpresa);
    
        System.out.println("--- LOTES RESERVADOS ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_RESERVADO, idEmpresa);
    
        System.out.println("--- LOTES EM TRANSPORTE PARA O ESTILISTA ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_TRANSPORTE_ESTILISTA, idEmpresa);
    
        System.out.println("--- LOTES EM TRANSPORTE PARA A LOJA ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_TRANSPORTE_LOJA, idEmpresa);

        System.out.println("--- LOTES CONCLUIDOS ---");
        bd.contabilizarLoteComStatus(Constantes.CODIGO_STATUS_LOTE_ENTREGUE_LOJA, idEmpresa);
    
    }
}
