package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.Lote;
import continuum.Projeto;
import continuum.utilitarios.Constantes;

public class SinalizarLoteRecebido {
    BdMock bd;
    
    public SinalizarLoteRecebido(BdMock bd){
        this.bd = bd;;
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
        
        Lote loteProjeto = bd.getLoteComId(projetoEstudante.getIdLote());
        
        projetoEstudante.setCdStatusProjeto(Constantes.CODIGO_STATUS_PROJETO_EM_PROCESSO);
        loteProjeto.setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_ENTREGUE);
        
        System.out.println("Lote recebido pelo estilista. Projeto iniciado...");
    }
}
