
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
    String cepEstudante;
    
    public ReservarLote(
        boolean estudanteLogado,
        BdMock bd,
        SelecionarEmpresa selecionarEmpresa,
        String cpfEstudante,
        String cepEstudante
    ){
        this.estudanteLogado = estudanteLogado;
        this.bd = bd;
        this.selecionarEmpresaCasoDeUso = selecionarEmpresa;
        this.cpfEstudante=cpfEstudante;
        this.cepEstudante=cepEstudante;
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
            
            if(bd.pesquisaLoteId(idLoteSelecionado) != Constantes.ID_LOTE_INVALIDO){
                break;
            }
            
            System.out.println("ID invalido!");
        }while(true);
        
        System.out.println("Lote selecionado: ID " + idLoteSelecionado);
        
        bd.criarProjeto(idLoteSelecionado,cpfEstudante);
        
        System.out.println("O lote sera 1 - ENVIADO ou 2 - RETIRADO ? "
                + "(Digite o numero correspondente)");
        
        opcaoEnvio = sc.nextInt();

        switch(opcaoEnvio){
            case(Constantes.OPCAO_RETIRADA)->{
                System.out.println("Endereco para realizar a retirada: ");
                bd.getEnderecoCompleto(bd.getEmpresaComId(idEmpresaSelecionada).getCep());
                bd.getLoteComId(idLoteSelecionado).setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_RESERVADO);
                System.out.println("Lote reservado!");
            }
            case(Constantes.OPCAO_ENVIO)->{
                System.out.println("O lote sera enviado para o endereco: ");
                bd.getEnderecoCompleto(cepEstudante);
                bd.getLoteComId(idLoteSelecionado).setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_AGUARDANDO_ENVIO);
                System.out.println("Lote reservado e aguardando envio da loja!");
            }
        }
    }
}
