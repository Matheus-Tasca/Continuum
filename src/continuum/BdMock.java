package continuum;

import continuum.endereco.Bairro;
import continuum.endereco.Cep;
import continuum.endereco.Cidade;
import continuum.endereco.Estado;
import java.util.Scanner;
import continuum.utilitarios.Constantes;
import java.util.ArrayList;
import java.util.List;

public class BdMock {

    private Doador doadorBd;
    private Estudante estudanteBd;
    private List<Empresa> empresaBd = new ArrayList();
    private List<Lote> lotesBd = new  ArrayList();
    private List<Projeto> projetosBd = new ArrayList();
    private List<Cep> cepsBd = new ArrayList();
    private List<Bairro> bairrosBd = new ArrayList();
    private List<Cidade> cidadesBd = new ArrayList();
    private List<Estado> estadosBd = new ArrayList();

    Scanner sc = new Scanner(System.in);
    
    public void criarDoador() {
        System.out.println("--- CADASTRO DE DOADOR ---");
        System.out.println("Nome do doador: ");
        String nome = sc.nextLine();
        System.out.println("CPF do doador: ");
        String cpf = sc.nextLine();
        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        System.out.println("CEP: ");
        String cep = sc.nextLine();
        System.out.println("numero de endereco: ");
        String numeroEndereco = sc.nextLine();
        doadorBd = new Doador(cpf, cep, nome, telefone, numeroEndereco);

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

            if(!this.pesquisarCep(cep)){
                System.out.println("CEP nao cadastrado! Iniciando cadastro de endereco");
                this.criarCidade();
            }

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

        do{
              System.out.println("--- CADASTRO DE NOVO LOTE ---");
              
              System.out.println("Insira o numero do lote: ");
              int numLote = sc.nextInt();
              
              System.out.println("Insira o peso do lote: ");
              double pesoLote = sc.nextDouble();
              
              sc.nextLine();
              
              System.out.println("Insira a descricao dos itens: ");
              String descItens = sc.nextLine();
              
              Lote novoLote = new Lote(numLote, Constantes.CODIGO_LOTE_DISPONIVEL, idEmpresa, descItens, pesoLote);
              
              lotesBd.add(novoLote);
              
              System.out.println("LOTE ADICIONADO!");
              System.out.println("-------------------");
              System.out.println("Deseja cadastrar novo lote?");
              System.out.println("1 - SIM | 2 - NAO");
              opcaoCriacaoLote= sc.nextInt();
        }while(opcaoCriacaoLote != 2);    
    }
    
    public void criarProjeto(int idLote, String cpfEstudante){
        Projeto novoProjeto = new Projeto(idLote, cpfEstudante);
        projetosBd.add(novoProjeto);
        System.out.println("Projeto " + novoProjeto.getIdProjeto()
                + " vinculado ao estudante");
    }
    
    public void criarCep(int idBairro){
        System.out.println("Informe o cep: ");
        String cep = sc.nextLine();
        System.out.println("Informe o logradouro: ");
        String logradouro = sc.nextLine();
        Cep novoCep = new Cep(cep, logradouro, idBairro);
        
        this.cepsBd.add(novoCep);
        
        System.out.println("CEP: " + cep + " cadastrado");
    }
    
    public void criarBairro(int idCidade){
        System.out.println("Informe o nome do bairro: ");
        String nomeBairro = sc.nextLine();
        Bairro novoBairro = new Bairro(nomeBairro, idCidade);;
        this.criarCep(novoBairro.getIdBairro());
    }
    
    public void criarCidade(){
        System.out.println("Informe a sigla do estado da cidade: ");
        String siglaEstado = sc.nextLine();
        System.out.println("sigla: " + siglaEstado);
        int idEstado = getEstadoComSigla(siglaEstado);
        
        if(idEstado == Constantes.ID_ESTADO_INVALIDO){
            System.out.println("Estado invalido!");
            return;
        }
        
        System.out.println("Informe o nome da cidade: ");
        String nomeCidade = sc.nextLine();
        Cidade novaCidade = new Cidade(nomeCidade,idEstado);
        cidadesBd.add(novaCidade);
        System.out.println("Cidade cadastrada! ");
        this.criarBairro(novaCidade.getIdCidade());
        
    }
    
    public void criarEstados(){
        estadosBd.add(new Estado("Acre", "AC"));
        estadosBd.add(new Estado("Alagoas", "AL"));
        estadosBd.add(new Estado("Amapa", "AP"));
        estadosBd.add(new Estado("Amazonas", "AM"));
        estadosBd.add(new Estado("Bahia", "BA"));
        estadosBd.add(new Estado("Ceara", "CE"));
        estadosBd.add(new Estado("Distrito Federal", "DF"));
        estadosBd.add(new Estado("Espirito Santo", "ES"));
        estadosBd.add(new Estado("Goias", "GO"));
        estadosBd.add(new Estado("Maranhao", "MA"));
        estadosBd.add(new Estado("Mato Grosso", "MT"));
        estadosBd.add(new Estado("Mato Grosso do Sul", "MS"));
        estadosBd.add(new Estado("Minas Gerais", "MG"));
        estadosBd.add(new Estado("Para", "PA"));
        estadosBd.add(new Estado("Paraiba", "PB"));
        estadosBd.add(new Estado("Parana", "PR"));
        estadosBd.add(new Estado("Pernambuco", "PE"));
        estadosBd.add(new Estado("Piaui", "PI"));
        estadosBd.add(new Estado("Rio de Janeiro", "RJ"));
        estadosBd.add(new Estado("Rio Grande do Norte", "RN"));
        estadosBd.add(new Estado("Rio Grande do Sul", "RS"));
        estadosBd.add(new Estado("Rondonia", "RO"));
        estadosBd.add(new Estado("Roraima", "RR"));
        estadosBd.add(new Estado("Santa Catarina", "SC"));
        estadosBd.add(new Estado("Sao Paulo", "SP"));
        estadosBd.add(new Estado("Sergipe", "SE"));
        estadosBd.add(new Estado("Tocantins", "TO"));
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
    
    public void getLotesCadastrados(int idEmpresa){
        System.out.println("Lotes cadastrados para a empresa de ID: " + idEmpresa);
        for (Lote loteAtual : lotesBd){
            if(
                loteAtual.getCdStatusLote() == Constantes.CODIGO_LOTE_DISPONIVEL &&
                loteAtual.getIdEmpresa() == idEmpresa
            ){
                System.out.println("--------------------");
                System.out.println("ID do lote: " + loteAtual.getIdLote());
                System.out.println("Numero do lote: " + loteAtual.getNumLote());
                System.out.println("Peso do lote: " + loteAtual.getPesoLote());
                System.out.println("Itens do lote: " + loteAtual.getDescItens());
            }
        }
    }
    
    public int getLoteComId(int idLoteSelecionado){
        for (Lote loteAtual : lotesBd){
            if(loteAtual.getIdLote() == idLoteSelecionado) return loteAtual.getIdLote();
        }
        
        return Constantes.ID_LOTE_INVALIDO;
    }
    
    public boolean pesquisarCep(String cepPesquisado){
        for(Cep cepAtual : cepsBd){
           if(cepAtual.getCep().equals(cepPesquisado)) return true;
        }
        
        return false;
    }
    
    public int getEstadoComSigla(String siglaEstado){
        for(Estado estadoAtual : estadosBd){
            estadoAtual.obterNomeCompleto();
            if(estadoAtual.getSgEstado().trim().equalsIgnoreCase(siglaEstado.trim()))
                return estadoAtual.getIdEstado();
        }
        return Constantes.ID_ESTADO_INVALIDO;
    }
}
