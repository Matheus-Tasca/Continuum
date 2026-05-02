
package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import java.util.Scanner;

public class ReservarLote {
    boolean estudanteLogado;
    BdMock bd;

    public ReservarLote(boolean estudanteLogado, BdMock bd, int idEmpresaSelecionada){
        this.estudanteLogado = estudanteLogado;
        this.bd = bd;
    }
    
    public void executar(){
        Scanner sc = new Scanner(System.in);

    }
}
