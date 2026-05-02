package continuum;

import java.util.Scanner;
import continuum.utilitarios.Constantes;
import java.util.ArrayList;
import java.util.List;

public class BdMock {

    private Doador doadorBd;
    private Estudante estudanteBd;
    private List<Empresa> empresaBd = new ArrayList();
    private List<Lote> lotesBd = new  ArrayList();
    //TO-DO: Decidir se os status serao um array ou n
    private StatusLote statusLoteBd;
    
    Scanner sc = new Scanner(System.in);

    public void criarDoador() {
        System.out.println("--- CADASTRO DE DOADOR ---");
        System.out.println("Nome do doador: ");
        String nome = sc.nextLine();
        System.out.println("CPF do doador: ");
        String cpf = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();

        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        System.out.println("CEP: ");
        String cep = sc.nextLine();
        System.out.println("numero de endereco: ");
        String numeroEndereco = sc.nextLine();
        doadorBd = new Doador(cpf, cep, nome, telefone, numeroEndereco, senha);

    }

    public void criarEmpresa() {
        int opcaoEmpresa;
        System.out.println("--- CADASTRO DE EMPRESA ---");
        do{
            
            System.out.println("CNPJ da empresa: ");
            String cnpj = sc.nextLine();

            System.out.println("Nome Fantasia: ");
            String nmFantasia = sc.nextLine();

            System.out.println("E-mail de contato: ");
            String email = sc.nextLine();

            System.out.println("CEP: ");
            String cep = sc.nextLine();

            System.out.println("Número do endereço: ");
            String nrEndereco = sc.nextLine();

            Empresa novaEmpresa = new Empresa(cnpj, nmFantasia, email, cep, nrEndereco);
            
            empresaBd.add(novaEmpresa);
            
            System.out.println("Empresa cadastrada com sucesso!");
            
            System.out.println("Deseja cadastrar outra empresa? ");
            System.out.println("1 - SIM | 2 - NAO");
            opcaoEmpresa = sc.nextInt();
            sc.nextLine();
        }while(opcaoEmpresa != 2);
    }

    public void criarEstudante() {
        System.out.println("--- CADASTRO DE ESTUDANTE ---");

        System.out.println("Nome do estudante: ");
        String nome = sc.nextLine();

        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        
        System.out.println("Senha: ");
        String senha = sc.nextLine();

        System.out.println("RA (Registro Acadêmico): ");
        String ra = sc.nextLine();

        System.out.println("Nome da Faculdade: ");
        String nmFaculdade = sc.nextLine();

        System.out.println("E-mail: ");
        String email = sc.nextLine();

        System.out.println("CEP: ");
        String cep = sc.nextLine();

        System.out.println("Número do endereço: ");
        String nrEndereco = sc.nextLine();
        
        estudanteBd = new Estudante(cpf, nome, ra, cep, nmFaculdade, email, nrEndereco, senha);

        System.out.println("Estudante cadastrado com sucesso!");

    }

    public void criarLote(int idEmpresa){
        int opcaoCriacaoLote;
        int statusLoteDisponivel = 0;
        do{
              System.out.println("--- CADASTRO DE NOVO LOTE ---");
              
              System.out.println("Insira o numero do lote: ");
              int numLote = sc.nextInt();
              
              System.out.println("Insira o peso do lote: ");
              double pesoLote = sc.nextDouble();
              
              sc.nextLine();
              
              System.out.println("Insira a descricao dos itens: ");
              String descItens = sc.nextLine();
              
              Lote novoLote = new Lote(numLote, statusLoteDisponivel, idEmpresa, descItens, pesoLote);
              
              lotesBd.add(novoLote);
              
              System.out.println("LOTE ADICIONADO!");
              System.out.println("-------------------");
              System.out.println("Deseja cadastrar novo lote?");
              System.out.println("1 - SIM | 2 - NAO");
              opcaoCriacaoLote= sc.nextInt();
        }while(opcaoCriacaoLote != 2);    
    }
    
    public void getEmpresasCadastradas() {
        System.out.println("Empresas cadastradas: ");
        for (Empresa empresaAtual : empresaBd){
            if(empresaAtual.getSituacaoCadastral()){
                System.out.println("--------------------");
                System.out.println("ID da empresa: " + empresaAtual.getIdEmpresa());
                System.out.println("Nome: " + empresaAtual.getNmFantasia());
                System.out.println("CEP: " + empresaAtual.getCep());
            }
        }
    }
    
    public int getEmpresaComId(int idEmpresaSelecionada){
        
        for (Empresa empresaAtual : empresaBd){
            if(empresaAtual.getIdEmpresa() == idEmpresaSelecionada)
               return empresaAtual.getIdEmpresa();
        }
        
        return Constantes.ID_EMPRESA_INVALIDA;
    }

    public Doador getDoadorBd() {
        return doadorBd;
    }

    public Estudante getEstudanteBd() {
        return estudanteBd;
    }
    
    public void getLotesCadastrados(){
        System.out.println("Lotes cadastrados: ");
        for (Lote loteAtual : lotesBd){
            if(loteAtual.getCdStatusLote() == 0){
                System.out.println("--------------------");
                System.out.println("Numero do lote: " + loteAtual.getNumLote());
                System.out.println("Empresa responsavel " + loteAtual.getIdEmpresa());
                System.out.println("Peso do lote: " + loteAtual.getPesoLote());
                System.out.println("Itens do lote: " + loteAtual.getDescItens());
            }
        }
    }
}
