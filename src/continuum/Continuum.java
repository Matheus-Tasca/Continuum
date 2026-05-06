package continuum;


import continuum.casosDeUsoDoador.LogarDoador;
import continuum.casosDeUsoDoador.VisualizarDoacoes;
import continuum.casosDeUsoEstudante.AssinarTermoResponsabilidade;
import continuum.casosDeUsoEstudante.FinalizarProjeto;
import continuum.casosDeUsoEstudante.LogarEstudante;
import continuum.casosDeUsoEstudante.ReservarLote;
import continuum.casosDeUsoEstudante.SelecionarEmpresa;
import continuum.casosDeUsoEstudante.SinalizarLoteRecebido;
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
                    boolean doadorLogado=false;
                    int opcaoDoador;
                    do{
                        System.out.println("----MENU PARA ESCOLHA (DOADOR) ----");
                        System.out.println("1 - Logar");
                        System.out.println("2 - Visualizar doacoes");
                        System.out.println("3 - Visualizar descontos");
                        opcaoDoador = sc.nextInt();
                        
                        switch(opcaoDoador) {
                            case Constantes.OPCAO_DOADOR_LOGAR ->{
                                LogarDoador logarDoador = new LogarDoador(bd);
                                doadorLogado = logarDoador.executar();
                            }
                            case Constantes.OPCAO_DOADOR_VISUALIZAR_DOACAO -> {
                                VisualizarDoacoes visualizarDoacao =  new VisualizarDoacoes(bd.getDoadorBd());
                                visualizarDoacao.visualizarDoacao();
                            }
                            case Constantes.OPCAO_DOADOR_VISUALIZAR_DESCONTOS -> {
                                
                            }
                            case Constantes.OPCAO_SAIR -> {
                                System.out.println("Saindo...");
                            }
                            default -> {
                                System.out.println("Opcao invalida");
                            }    
                    }
                 } while (opcaoDoador != Constantes.OPCAO_SAIR);
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
                        System.out.println("3 - Sinalizar lote recebido");
                        System.out.println("4 - Descrever processo criativo e finalizar projeto");
                        System.out.println("0 - Sair");
                        opcaoEstudante = sc.nextInt();

                        switch(opcaoEstudante){
                            case Constantes.OPCAO_ESTUDANTE_LOGAR ->{
                                LogarEstudante logarEstudante = new LogarEstudante(bd);
                                estudanteLogado = logarEstudante.executar();
                            }
                            case Constantes.OPCAO_ESTUDANTE_RESERVAR_LOTE ->{
                                SelecionarEmpresa selecionarEmpresaCasoDeUso = new SelecionarEmpresa(estudanteLogado, bd);
                                AssinarTermoResponsabilidade assinarTermoResponsabilidade = new AssinarTermoResponsabilidade(bd.getEstudanteBd().getCpf());
                                
                                bd.criarLote(1);
                                
                                ReservarLote reservarLoteCasoDeUso = new ReservarLote(
                                        estudanteLogado,
                                        bd,
                                        selecionarEmpresaCasoDeUso,
                                        bd.getEstudanteBd().getCpf(),
                                        bd.getEstudanteBd().getCep(),
                                        assinarTermoResponsabilidade
                                );
                                
                                reservarLoteCasoDeUso.executar();
                            }
                            case Constantes.OPCAO_ESTUDANTE_SINALIZAR_LOTE_RECEBIDO ->{
                                SinalizarLoteRecebido sinalizarLoterecebidoCasoDeUso = new SinalizarLoteRecebido(bd);
                                sinalizarLoterecebidoCasoDeUso.executar(bd.getEstudanteBd().getCpf());
                            }
                            case Constantes.OPCAO_ESTUDANTE_FINALIZAR_PROJETO->{
                                FinalizarProjeto finalizarProjetoCasoDeUso = new FinalizarProjeto(bd);
                                finalizarProjetoCasoDeUso.executar(bd.getEstudanteBd().getCpf());
                            }
                            case Constantes.OPCAO_SAIR -> {
                                System.out.println("Saindo...");
                            }
                            default -> {
                                System.out.println("Opcao invalida!");
                            }
                        }
                    }while(opcaoEstudante != Constantes.OPCAO_SAIR);
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
