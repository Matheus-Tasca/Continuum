package continuum.casosDeUsoEstudante;

import java.util.Scanner;

public class AssinarTermoResponsabilidade {
    private Scanner sc = new Scanner(System.in);
    private String cpfEstudante;
    
    public AssinarTermoResponsabilidade(String cpfEstudante){
        this.cpfEstudante = cpfEstudante;
    }
    
    public boolean executar() {
        System.out.println("\n--- TERMO DE RESPONSABILIDADE E COMPROMISSO DE UPCYCLING ---");
        System.out.println("Eu, portador do CPF: " + cpfEstudante + ", declaro que:");
        System.out.println("1. Comprometo-me a utilizar o lote de materiais exclusivamente para fins de upcycling.");
        System.out.println("2. Assumo a responsabilidade pela integridade dos materiais durante o processo de transformação.");
        System.out.println("3. Estou ciente de que devo registrar o progresso da nova peça no sistema Continuum.");
        System.out.println("4. Caso o projeto não seja concluído, comprometo-me a devolver o saldo de materiais à empresa de origem.");
        System.out.println("----------------------------------------------------------");
        
        System.out.println("\nPara aceitar e assinar digitalmente, digite seu CPF novamente:");
        String assinatura = sc.nextLine();

        if (assinatura.equals(cpfEstudante)) {
            System.out.println("Termo assinado com sucesso!\n");
            return true;
        } else {
            System.out.println("Assinatura inválida! O CPF digitado não confere.");
            return false;
        }
    }
}