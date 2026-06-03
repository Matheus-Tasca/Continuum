package continuum.casosDeUsoDoador;
import continuum.BdMock;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class LogarDoador {
   String cpfBd, senhaBd, cpf, senha;
   BdMock bd;
   
   public LogarDoador(BdMock bd) {
       this.bd = bd;
   }
   
   public boolean executar() {
       do {
           Scanner sc = new Scanner(System.in);
           System.out.println("----Doador----");
           System.out.println("Informe o cpf: ");
           cpf = sc.nextLine();
           System.out.println("Informe a senha: ");
           senha = sc.nextLine();
           
           cpfBd = bd.getDoadorBd().getCpf();
           senhaBd = bd. getDoadorBd().getSenha();
           
           if(cpfBd.equals(cpf) && senhaBd.equals(senha)) 
               System.out.println("Login efetuado com sucesso");
           else 
               System.out.println("Usuario invalido! Tente novamente");           
       } while(!cpfBd.equals(cpf) || !senhaBd.equals(senha));
       return Constantes.USUARIO_LOGADO;
   }
   
    
}
