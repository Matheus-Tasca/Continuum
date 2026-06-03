package continuum.casosDeUsoEmpresa;

import continuum.BdMock;
import continuum.Empresa;
import java.util.Scanner;

public class LogarEmpresa {
    Scanner sc = new Scanner(System.in);
    String cnpj, senha;
    BdMock bd;
    Empresa empresaBd;
    
    public LogarEmpresa(BdMock bd){
        this.bd = bd;
    }
    
     public Empresa executar(){
        do {
           System.out.println("Informe o cnpj: ");
           cnpj = sc.nextLine();
           System.out.println("Informe a senha: ");
           senha = sc.nextLine();
           
           empresaBd = bd.getLoginEmpresa(cnpj,senha);
           
           if(empresaBd != null)
               break;
           
            System.out.println("Login invalido!");
        } while(empresaBd == null);
        
        return empresaBd;

    }
}
