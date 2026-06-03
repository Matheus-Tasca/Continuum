package continuum.casosDeUsoEmpresa;

import continuum.BdMock;
import continuum.Lote;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class ConcluirProjeto {
    BdMock bd;
    
    public ConcluirProjeto(BdMock bd) {   
    this.bd = bd;
    }
    
    public void executar(int idEmpresa) {
    
        bd.getStatusLoteTransporteLoja(idEmpresa);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do lote desejado: ");
        int idDesejado = sc.nextInt();
        Lote loteSelecionado = bd.getLoteComId(idDesejado);
        
        if(loteSelecionado==null) {
            System.out.println("Lote invalido. Tente novamente.");
            return;
        }
       
        loteSelecionado.setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_ENTREGUE);
    } 
}
