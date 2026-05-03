package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class SelecionarEmpresa {
    boolean estudanteLogado;
    BdMock bd;
            
    public SelecionarEmpresa(boolean estudanteLogado, BdMock bd){
        this.bd = bd;
        this.estudanteLogado = estudanteLogado;
    }
    
    public int executar(){
        Scanner sc = new Scanner(System.in);
        int idEmpresaSelecionada = Constantes.ID_EMPRESA_INVALIDA;
        int idEmpresaEntrada;

        do{
            bd.getEmpresasCadastradas();
            System.out.println("Digite o id da empresa que deseja selecionar: ");
            idEmpresaEntrada = sc.nextInt();
            idEmpresaSelecionada = bd.pesquisaIdEmpresa(idEmpresaEntrada);

            if(idEmpresaSelecionada != Constantes.ID_EMPRESA_INVALIDA && bd.getEmpresaComId(idEmpresaSelecionada) != null){
                break;
            }

            System.out.println("Id invalido! Tente novamente com um id valido");
            System.out.println("(Digite 0 para sair da selecao de empresas)");

        }while(idEmpresaEntrada != Constantes.OPCAO_SAIR);

        return idEmpresaSelecionada;
    } 
}
