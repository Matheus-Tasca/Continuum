package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.Lote;
import continuum.Projeto;
import continuum.utilitarios.Constantes;

public class SinalizarLoteRecebido {
    BdMock bd;
    
    public SinalizarLoteRecebido(BdMock bd){
        this.bd = bd;
    }
    
    public void executar(String cpfEstudante){
        if(cpfEstudante.isBlank() || cpfEstudante.isEmpty()){
            System.out.println("Informe o cpf do estudante!");
            return;
        }
        
        Projeto projetoEstudante = bd.getProjetoComCpf(cpfEstudante);
        Lote loteProjeto = bd.getLoteComId(projetoEstudante.getIdLote());

        if(projetoEstudante == null){
            System.out.println("Estudante nao tem projeto ativo! ");
            return;
        }
        
        projetoEstudante.setCdStatusProjeto(Constantes.CODIGO_STATUS_PROJETO_EM_PROCESSO);
        loteProjeto.setCdStatusLote(Constantes.CODIGO_STATUS_LOTE_EM_PREPARO);
        
        System.out.println("Lote recebido pelo estilista. Projeto iniciado...");
    }
}
