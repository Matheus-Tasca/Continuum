package continuum.casosDeUsoEmpresa;

import continuum.BdMock;
import continuum.Empresa;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class LogarEmpresa {
    Scanner sc = new Scanner(System.in);
    String cnpjBd, senhaBd, cnpj, senha;
    BdMock bd;
    
    public LogarEmpresa(BdMock bd){
        this.bd = bd;
    }

    
     public Empresa executar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----Empresa----");
        System.out.println("Informe o cnpj: ");
        cnpj = sc.nextLine();
        System.out.println("Informe a senha: ");
        senha = sc.nextLine();


        Empresa empresa =  bd.verificarCadastro(cnpj, senha);
        return empresa;

    }
}
