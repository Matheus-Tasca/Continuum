package continuum;


import continuum.casosDeUsoEstudante.LogarEstudante;
import continuum.casosDeUsoEstudante.ReservarLote;
import continuum.casosDeUsoEstudante.SelecionarEmpresa;
import continuum.utilitarios.Constantes;
import java.util.Scanner;

public class Continuum {
     public static void main(String[] args) {   
       
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("----------- Banco de dados -----------");
        
        BdMock bd = new BdMock();
        
        bd.criarEstados();
//        bd.criarDoador();
        bd.criarEmpresa();
        bd.criarEstudante();

        do{
            System.out.println("------MENU PARA ESCOLHA------");
            System.out.println("1 - Doador");
            System.out.println("2 - Empresa");
            System.out.println("3 - Estudante de moda");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case Constantes.OPCAO_DOADOR -> {

                 }
                case Constantes.OPCAO_EMPRESA -> {

                 }
                case Constantes.OPCAO_ESTUDANTE -> {
                    boolean estudanteLogado = false;
                    int opcaoEstudante;
                    do{
                        System.out.println("------MENU PARA ESCOLHA (ESTUDANTE)------");
                        System.out.println("1 - Logar");
                        System.out.println("2 - Reservar Lote");
                        System.out.println("0 - Sair");
                        opcaoEstudante = sc.nextInt();

                        switch(opcaoEstudante){
                            case Constantes.OPCAO_ESTUDANTE_LOGAR ->{
                                LogarEstudante logarEstudante = new LogarEstudante(bd);
                                estudanteLogado = logarEstudante.executar();
                            }
                            case Constantes.OPCAO_ESTUDANTE_RESERVAR_LOTE ->{
                                SelecionarEmpresa selecionarEmpresaCasoDeUso = new SelecionarEmpresa(estudanteLogado, bd);
                                bd.criarLote(1);
                                ReservarLote reservarLoteCasoDeUso = new ReservarLote(
                                        estudanteLogado,
                                        bd,
                                        selecionarEmpresaCasoDeUso,
                                        bd.getEstudanteBd().getCpf(),
                                        bd.getEstudanteBd().getCep()
                                );
                                
                                reservarLoteCasoDeUso.executar();
                            }
                            default -> {
                                if(opcao>0)
                                    System.out.println("Opcao invalida!");
                            }
                        }
                    }while(opcaoEstudante != 0);
                 }
                case Constantes.OPCAO_SAIR -> {
                    System.out.println("Saindo...");
                }
                default -> {
                    System.out.println("Opcao invalida!");   
                }
            }
        }while(opcao!=0);
    }
}
