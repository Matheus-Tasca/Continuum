package continuum.casosDeUsoEmpresa;

import continuum.BdMock;
import continuum.Lote;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class ConfirmarRetiradaEnvio {
    BdMock bd;
    Scanner sc = new Scanner(System.in);
    
    public ConfirmarRetiradaEnvio(BdMock bd){
        this.bd = bd;
    }
    
    public void executar(int idEmpresa){
        System.out.println("---- LOTES RESERVADOS ----");
        bd.getLotesBaseStatus(Constantes.CODIGO_STATUS_LOTE_RESERVADO, idEmpresa);
        
        System.out.println("---- LOTES AGUARDANDO ENVIO ----");
        bd.getLotesBaseStatus(Constantes.CODIGO_STATUS_LOTE_AGUARDANDO_ENVIO, idEmpresa);
    
        System.out.println("Qual lote deseja confirmar o envio/retirada? ");
        int idLote = sc.nextInt();
        Lote loteSelecionado = bd.getLoteComId(idLote);
        
        if(loteSelecionado.getCdStatusLote() == Constantes.CODIGO_STATUS_LOTE_AGUARDANDO_ENVIO){
            loteSelecionado.setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_TRANSPORTE_ESTILISTA);
            System.out.println("Lote enviado para o estilista!");
            return;
        }
        
        if(loteSelecionado.getCdStatusLote() == Constantes.CODIGO_STATUS_LOTE_RESERVADO){
            loteSelecionado.setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_EM_PREPARO);
            System.out.println("Retirada do lote confirmada!");
            return;
        }
    }
}
