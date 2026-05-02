
package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class ReservarLote {
    boolean estudanteLogado;
    BdMock bd;
    SelecionarEmpresa selecionarEmpresaCasoDeUso;
    Scanner sc = new Scanner();
    
    public ReservarLote(
        boolean estudanteLogado,
        BdMock bd,
        SelecionarEmpresa selecionarEmpresa
    ){
        this.estudanteLogado = estudanteLogado;
        this.bd = bd;
        this.selecionarEmpresaCasoDeUso = selecionarEmpresa;
    }
    
    public void executar(){
        int idLoteSelecionado;
        
        if(!estudanteLogado){
            System.out.println("O estudante deve estar logado!");
            return;
        }
        
        int idEmpresaSelecionada = selecionarEmpresaCasoDeUso.executar();
        
        if(idEmpresaSelecionada == Constantes.ID_EMPRESA_INVALIDA) return;
        
        bd.getLotesCadastrados(idEmpresaSelecionada);
        
        do{
            System.out.println("Digite o ID do lote que deseja selecionar: ");
            idLoteSelecionado = sc.nextInt();
            
            if(bd.getLoteComId(idLoteSelecionado) != Constantes.ID_LOTE_INVALIDO){
                break;
            }
            
            System.out.println("ID invalido!");
        }while(bd.getLoteComId(idLoteSelecionado) != Constantes.ID_LOTE_INVALIDO);
        
        
    }
}
