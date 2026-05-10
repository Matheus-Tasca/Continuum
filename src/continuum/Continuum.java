package continuum;


import continuum.casosDeUsoDoador.LogarDoador;
import continuum.casosDeUsoDoador.VisualizarDescontos;
import continuum.casosDeUsoDoador.VisualizarDoacoes;
import continuum.casosDeUsoEmpresa.ConcluirProjeto;
import continuum.casosDeUsoEmpresa.ConfirmarRetiradaEnvio;
import continuum.casosDeUsoEmpresa.LogarEmpresa;
import continuum.casosDeUsoEmpresa.VisualizarDashboard;
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
        bd.criarDoador();
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
                                visualizarDoacao.executar();
                            }
                            case Constantes.OPCAO_DOADOR_VISUALIZAR_DESCONTOS -> {
                                VisualizarDescontos visualizarDescontoCasoDeUso = new VisualizarDescontos(bd);
                                visualizarDescontoCasoDeUso.executar();
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
                   Empresa empresaLogada = null;
                    
                    int opcaoEmpresa;
                    do{
                        System.out.println("----MENU PARA ESCOLHA (EMPRESA) ----");
                        System.out.println("1 - Logar");
                        System.out.println("2 - Cadastrar lote");
                        System.out.println("3 - Concluir projeto");
                        System.out.println("4 - Visualizar dashboard");
                        System.out.println("5 - Confirmar retirada");
                        opcaoEmpresa = sc.nextInt();
                        
                        switch(opcaoEmpresa) {
                            case Constantes.OPCAO_EMPRESA_LOGAR ->{
                                LogarEmpresa logarEmpresa = new  LogarEmpresa(bd);
                                empresaLogada = logarEmpresa.executar();
                                
                                if(empresaLogada==null) {
                                    System.out.println("Login invalido! Tente novamente.");
                                    return ;
                                } 
                              
                            }
                            case Constantes.OPCAO_EMPRESA_CADASTRAR_LOTE -> {
                                if(empresaLogada==null) {
                                    System.out.println("Empresa deve estar logada!");
                                    return ;
                                } 
                                bd.criarLote(empresaLogada.getIdEmpresa());
                            }
                            case Constantes.OPCAO_EMPRESA_CONCLUIR_PROJETO -> {
                                if(empresaLogada==null) {
                                    System.out.println("Empresa deve estar logada!");
                                    return;
                                }
                                
                                ConcluirProjeto concluirProjetoCasoDeUso = new ConcluirProjeto(bd);
                                concluirProjetoCasoDeUso.executar(empresaLogada.getIdEmpresa());
                              
                            }
                            case Constantes.OPCAO_EMPRESA_VISUALIZAR_DASHBOARD -> {
                                if(empresaLogada==null) {
                                    System.out.println("Empresa deve estar logada!");
                                    return;
                                }
                                
                                VisualizarDashboard visualizarDashboardCasoDeUso = new VisualizarDashboard(bd);
                                visualizarDashboardCasoDeUso.executar(empresaLogada.getIdEmpresa());
                            } 
                            case Constantes.OPCAO_EMPRESA_CONFIRMAR_RETIRADA_ENVIO_LOTE -> {
                                if(empresaLogada==null) {
                                    System.out.println("Empresa deve estar logada!");
                                    return;
                                }
                                
                                ConfirmarRetiradaEnvio confirmarRetiradaEnvioCasoDeUso = new ConfirmarRetiradaEnvio(bd);
                                confirmarRetiradaEnvioCasoDeUso.executar(empresaLogada.getIdEmpresa());
                            }
                            case Constantes.OPCAO_SAIR -> {
                                System.out.println("Saindo...");
                            }
                            default -> {
                                System.out.println("Opcao invalida");
                            }    
                    }
                 } while (opcaoEmpresa != Constantes.OPCAO_SAIR);
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
