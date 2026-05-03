package continuum.utilitarios;

import continuum.BdMock;
import continuum.endereco.Cep;


public class CadastrarEndereco {
    BdMock bd;
    public CadastrarEndereco (
            BdMock bd
    ){
        this.bd = bd;
    }
    
    public void executar(){
        System.out.println("--- CADASTRO DE ENDERECO ---");
        bd.criarCidade();
    }
}
