package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.Projeto;
import java.util.Scanner;

public class FinalizarProjeto {
    BdMock bd;
    Scanner sc = new Scanner(System.in);

    public FinalizarProjeto(BdMock bd){
        this.bd = bd;
    }
    
    public void executar(String cpfEstudante){
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

        projetoEstudante.finalizarProjeto(processoCriativo);

        System.out.println("Projeto " + projetoEstudante.getIdProjeto());
    }
}
