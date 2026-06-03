package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.Projeto;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class FinalizarProjeto {
    BdMock bd;
    Scanner sc = new Scanner(System.in);

    public FinalizarProjeto(BdMock bd){
        this.bd = bd;
    }
    
    public void executar(String cpfEstudante, boolean estudanteLogado){
        
        if(!estudanteLogado){
            System.out.println("O estudante deve estar logado!");
            return;
        }
        
        if(cpfEstudante.isBlank() || cpfEstudante.isEmpty()){
            System.out.println("Informe o cpf do estudante!");
            return;
        }
        
        Projeto projetoEstudante = bd.getProjetoComCpf(cpfEstudante);
        
        if(projetoEstudante == null){
            System.out.println("Estudante nao tem projeto ativo! ");
            return;
        }
        
        System.out.println(" FINALIZACAO PROJETO " + projetoEstudante.getIdProjeto());
        System.out.println("Descreva o processo criativo: ");
        String processoCriativo = sc.nextLine();
        
        if(processoCriativo.isBlank() || processoCriativo.isEmpty()){
            System.out.println("O processo criativo deve ser preenchido!");
            return;
        }
        
        bd.getLoteComId(projetoEstudante.getIdLote()).setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_TRANSPORTE);
        
        projetoEstudante.setProcessoCriativo(processoCriativo);
        projetoEstudante.finalizarProjeto();
        
        System.out.println("O lote "+ projetoEstudante.getIdLote() + " foi repostado para a loja e projeto finalizado");
    }
}
