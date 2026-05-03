
package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class ReservarLote {
    boolean estudanteLogado;
    BdMock bd;
    SelecionarEmpresa selecionarEmpresaCasoDeUso;
    Scanner sc = new Scanner(System.in);
    String cpfEstudante;
    
    public ReservarLote(
        boolean estudanteLogado,
        BdMock bd,
        SelecionarEmpresa selecionarEmpresa,
        String cpfEstudante
    ){
        this.estudanteLogado = estudanteLogado;
        this.bd = bd;
        this.selecionarEmpresaCasoDeUso = selecionarEmpresa;
        this.cpfEstudante=cpfEstudante;
    }
    
    public void executar(){
        int idLoteSelecionado, opcaoEnvio;
        
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
        
        System.out.println("Lote selecionado: ID " + idLoteSelecionado);
        
        bd.criarProjeto(idLoteSelecionado,cpfEstudante);
        
        System.out.println("O lote sera 1 - ENVIADO ou 2 - RETIRADO ? "
                + "(Digite o numero correspondente)");
        
        opcaoEnvio = sc.nextInt();

        switch(opcaoEnvio){
            case(Constantes.OPCAO_RETIRADA)->{
                System.out.println("");
            }
            case(Constantes.OPCAO_ENVIO)->{
                
            }
        }
    }
}
