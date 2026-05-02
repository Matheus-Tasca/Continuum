package continuum.casosDeUsoEstudante;

import continuum.BdMock;
import continuum.utilitarios.Constantes;
import java.util.Scanner;


public class LogarEstudante {
    String cpfBd, senhaBd, cpf, senha;    
    BdMock bd;

    public LogarEstudante(BdMock bd){
        this.bd = bd;
    }
    
    public boolean executar() {
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o cpf do estudante: ");
            cpf = sc.nextLine();
            System.out.println("Informe a senha do estudante: ");
            senha = sc.nextLine();

            cpfBd= bd.getEstudanteBd().getCpf();
            senhaBd= bd.getEstudanteBd().getSenha();
            
            if(cpfBd.equals(cpf) && senhaBd.equals(senha)) 
                System.out.println("Login efetuado com sucesso!"); 
            else
                System.out.println("Usuario invalido");
        }while(!cpfBd.equals(cpf) || !senhaBd.equals(senha));
        return Constantes.USUARIO_LOGADO;
    }
}
