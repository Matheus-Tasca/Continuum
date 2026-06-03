package continuum;

import continuum.endereco.Bairro;
import continuum.endereco.Cep;
import continuum.endereco.Cidade;
import continuum.endereco.Estado;
import java.util.Scanner;
import continuum.utilitarios.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private boolean DEBUG = true;
    private Random random = new Random();
    
    Scanner sc = new Scanner(System.in);
    
    public void criarDoador() {
        System.out.println("--- CADASTRO DE DOADOR ---");
        String nome, cpf, senha, telefone, cep, numeroEndereco;

        if (DEBUG) {
            System.out.println("[DEBUG] Gerando dados aleatórios para Doador...");
            nome = "Doador Falso " + random.nextInt(100);
            cpf = String.valueOf(10000000000L + random.nextLong(90000000000L));
            senha = "senha" + random.nextInt(1000);
            telefone = "119" + (10000000 + random.nextInt(90000000));
            cep = "13480000";
            numeroEndereco = String.valueOf(random.nextInt(1000));
            System.out.println("Login: " + cpf + " | " + senha);
        } else {
            System.out.println("Nome do doador: ");
            nome = sc.nextLine();
            System.out.println("CPF do doador: ");
            cpf = sc.nextLine();
            System.out.println("Senha: ");
            senha = sc.nextLine();
            System.out.println("Telefone: ");
            telefone = sc.nextLine();
            System.out.println("CEP: ");
            cep = sc.nextLine();
            System.out.println("numero de endereco: ");
            numeroEndereco = sc.nextLine();
        }

        if(!this.pesquisarCep(cep)){
            System.out.println("CEP nao cadastrado! Iniciando cadastro de endereco");
            this.criarCidade();
        }

        doadorBd = new Doador(cpf, cep, nome, telefone, numeroEndereco, senha);
        System.out.println("Doador cadastrado com sucesso!");
    }

    public void criarEmpresa() {
        int opcaoEmpresa;
        System.out.println("--- CADASTRO DE EMPRESA ---");
        do {
            String cnpj, nmFantasia, email, cep, nrEndereco, senha;

            if (DEBUG) {
                System.out.println("[DEBUG] Gerando dados aleatórios para Empresa...");
                cnpj = String.valueOf(10000000000000L + random.nextLong(90000000000000L));
                nmFantasia = "Empresa Fake " + random.nextInt(100);
                email = "contato@empresa" + random.nextInt(100) + ".com";
                cep = "13480000";
                nrEndereco = String.valueOf(random.nextInt(1000));
                senha = "senha" + random.nextInt(1000);
                System.out.println("Login: " + cnpj + " | " + senha);
            } else {
                System.out.println("CNPJ da empresa: ");
                cnpj = sc.nextLine();
                System.out.println("Nome Fantasia: ");
                nmFantasia = sc.nextLine();
                System.out.println("E-mail de contato: ");
                email = sc.nextLine();
                System.out.println("CEP: ");
                cep = sc.nextLine();
                System.out.println("Número do endereço: ");
                nrEndereco = sc.nextLine();
                System.out.println("Crie uma senha: ");
                senha = sc.nextLine();
            }
            
            if(!this.pesquisarCep(cep)){
                System.out.println("CEP nao cadastrado! Iniciando cadastro de endereco");
                this.criarCidade();
            }

            Empresa novaEmpresa = new Empresa(cnpj, nmFantasia, email, cep, nrEndereco, senha);
            empresaBd.add(novaEmpresa);
            
            System.out.println("Empresa cadastrada com sucesso!");
            
            if (DEBUG) {
                opcaoEmpresa = 2; 
            } else {
                System.out.println("Deseja cadastrar outra empresa? ");
                System.out.println("1 - SIM | 2 - NAO");
                opcaoEmpresa = sc.nextInt();
                sc.nextLine();
            }
        } while(opcaoEmpresa != 2);
    }

    public void criarEstudante() {
        System.out.println("--- CADASTRO DE ESTUDANTE ---");
        String nome, cpf, senha, ra, nmFaculdade, email, cep, nrEndereco;

        if (DEBUG) {
            System.out.println("[DEBUG] Gerando dados aleatórios para Estudante...");
            nome = "Estudante Fake " + random.nextInt(100);
            cpf = String.valueOf(10000000000L + random.nextLong(90000000000L));
            senha = "senha" + random.nextInt(1000);
            ra = String.valueOf(100000 + random.nextInt(900000));
            nmFaculdade = "Faculdade Federal " + random.nextInt(5);
            email = "estudante" + random.nextInt(1000) + "@faculdade.edu";
            cep = "13480001";
            nrEndereco = String.valueOf(random.nextInt(1000));
            System.out.println("Login: " + cpf + " | " + senha);
        } else {
            System.out.println("Nome do estudante: ");
            nome = sc.nextLine();
            System.out.println("CPF: ");
            cpf = sc.nextLine();
            System.out.println("Senha: ");
            senha = sc.nextLine();
            System.out.println("RA (Registro Acadêmico): ");
            ra = sc.nextLine();
            System.out.println("Nome da Faculdade: ");
            nmFaculdade = sc.nextLine();
            System.out.println("E-mail: ");
            email = sc.nextLine();
            System.out.println("CEP: ");
            cep = sc.nextLine();
            System.out.println("Número do endereço: ");
            nrEndereco = sc.nextLine();
        }
        
        if(!this.pesquisarCep(cep)){
            System.out.println("CEP nao cadastrado! Iniciando cadastro de endereco");
            this.criarCidade();
        }
        
        estudanteBd = new Estudante(cpf, nome, ra, cep, nmFaculdade, email, nrEndereco, senha);
        System.out.println("Estudante cadastrado com sucesso!");
    }

    public void criarLote(int idEmpresa){
        int opcaoCriacaoLote;

        do{
              System.out.println("--- CADASTRO DE NOVO LOTE ---");
              
              System.out.println("Insira o numero do lote: ");
              int numLote = sc.nextInt();
              
              System.out.println("Insira o peso do lote (em kg) : ");
              double pesoLote = sc.nextDouble();
              
              sc.nextLine();
              
              System.out.println("Insira a descricao dos itens: ");
              String descItens = sc.nextLine();
              
              System.out.println("Informe o cpf da doador: (se nao houver digite 0)");
              String cpfDoador = sc.nextLine();
              
              if(!cpfDoador.equalsIgnoreCase("0")){
                this.getDoadorBd().realizarDoacao();
              }
              
              Lote novoLote = new Lote(numLote, Constantes.CODIGO_STATUS_LOTE_DISPONIVEL, idEmpresa, descItens, pesoLote);
              
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
        bairrosBd.add(novoBairro);
        this.criarCep(novoBairro.getIdBairro());
    }
    
    public void criarCidade(){
        int idEstado;
        do{
            System.out.println("Informe a sigla do estado da cidade: ");
            String siglaEstado = sc.nextLine();
            idEstado = getEstadoComSigla(siglaEstado);
        
            if(idEstado != Constantes.ID_ESTADO_INVALIDO){
                break;
            }
            
            System.out.println("Estado invalido!");
        }while(idEstado == Constantes.ID_ESTADO_INVALIDO);
        
        
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
                System.out.println("CNPJ: " + empresaAtual.getCnpj());
            }
        }
    }
    
    public int pesquisaIdEmpresa(int idEmpresaSelecionada){
        
        for (Empresa empresaAtual : empresaBd){
            if(empresaAtual.getIdEmpresa() == idEmpresaSelecionada)
               return empresaAtual.getIdEmpresa();
        }
        
        return Constantes.ID_EMPRESA_INVALIDA;
    }

    public Empresa getEmpresaComId(int idEmpresaSelecionada){
        Empresa empresaSelecionada = null;
        
        for (Empresa empresaAtual : empresaBd){
            if(empresaAtual.getIdEmpresa() == idEmpresaSelecionada)
               empresaSelecionada = empresaAtual;
        }
        
        return empresaSelecionada;
    }
    
    public Lote getLoteComId(int idLoteSelecionado){
        Lote loteSelecionado = null;
        
        for (Lote loteAtual : lotesBd){
            if(loteAtual.getIdLote() == idLoteSelecionado)
               loteSelecionado = loteAtual;
        }
        
        return loteSelecionado;
    }
    
    public Projeto getProjetoComId(int idProjeto){
        Projeto projeto = null;
        
        for (Projeto projetoAtual : projetosBd){
            if(projetoAtual.getIdProjeto() == idProjeto)
               projeto = projetoAtual;
        }
        
        return projeto;
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
                loteAtual.getCdStatusLote() == Constantes.CODIGO_STATUS_LOTE_DISPONIVEL &&
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
    
    public int pesquisaLoteId(int idLoteSelecionado){
        for (Lote loteAtual : lotesBd){
            if(loteAtual.getIdLote() == idLoteSelecionado) return loteAtual.getIdLote();
        }
        
        return Constantes.ID_LOTE_INVALIDO;
    }
    
    public boolean pesquisarCep(String cepPesquisado){
        for(Cep cepAtual : cepsBd){
           if(cepAtual.getCep().trim().equalsIgnoreCase(cepPesquisado.trim())) return true;
        }
        
        return false;
    }
    
    public int getEstadoComSigla(String siglaEstado){
        for(Estado estadoAtual : estadosBd){
            if(estadoAtual.getSgEstado().trim().equalsIgnoreCase(siglaEstado.trim()))
                return estadoAtual.getIdEstado();
        }
        return Constantes.ID_ESTADO_INVALIDO;
    }
    
    public void getEnderecoCompleto(String cep) {
    
        Cep cepEndereco = null;
        Bairro bairroEndereco = null;
        Cidade cidadeEndereco = null;
        Estado estadoEndereco = null;

        for (Cep cepAtual : cepsBd) {
            if (cepAtual.getCep().trim().equalsIgnoreCase(cep.trim())) {
                cepEndereco = cepAtual;
                break;
            }
        }

        if (cepEndereco != null) {

            for (Bairro bairroAtual : bairrosBd) {
                if (cepEndereco.getIdBairro() == bairroAtual.getIdBairro()) {
                    bairroEndereco = bairroAtual;
                    break;
                }
            }

            if (bairroEndereco != null) {
                for (Cidade cidadeAtual : cidadesBd) {
                    if (bairroEndereco.getIdCidade() == cidadeAtual.getIdCidade()) {
                        cidadeEndereco = cidadeAtual;
                        break;
                    }
                }
            }

            if (cidadeEndereco != null) {
                for (Estado estadoAtual : estadosBd) {
                    if (cidadeEndereco.getIdEstado() == estadoAtual.getIdEstado()) {
                        estadoEndereco = estadoAtual;
                        break;
                    }
                }
            }
        }

        if (estadoEndereco != null) {
            System.out.println("Endereco: " + bairroEndereco.getNmBairro() + 
                               ", " + cidadeEndereco.getNmCidade() + 
                               " - " + estadoEndereco.getSgEstado());
        } else {
            System.out.println("CEP nao encontrado ou cadastro incompleto.");
        }
    }
    
    public Projeto getProjetoComCpf(String cpfEstudante){
        for(Projeto projetoAtual : projetosBd){
            if(projetoAtual.getCpfEstudante().trim().equalsIgnoreCase(cpfEstudante) && projetoAtual.getCdStatusProjeto() != Constantes.CODIGO_STATUS_PROJETO_FINALIZADO){
                return projetoAtual;
            }
        }
        
        return null;
    }

    public void getDescontosNaoUtilizados() {
        System.out.println("--- Cupons Disponiveis ---");

        for (Desconto d : this.getDoadorBd().getCupons()) {
            if (!d.getUtilizado()) {
                System.out.println("ID: " + d.getIdDesconto());
                System.out.println("Codigo: " + d.getCdDesconto());
                System.out.println("CPF Doador: " + d.getCpfDoador());
                System.out.println("Porcentagem: " + d.getPorcentagem() + "%");
                System.out.println("--------------------------");   
            }
        }
    }

    public Empresa verificarCadastro(String cnpj, String senha) {
        for (Empresa empresaAtual : empresaBd) {
            if(empresaAtual.getSituacaoCadastral() && 
                    empresaAtual.getCnpj().trim().equalsIgnoreCase(cnpj) && 
                    empresaAtual.getSenha().trim().equalsIgnoreCase(senha) )
            {
                return empresaAtual;
            }
        } 
        return null;
    }
    
   public void getStatusLoteTransporteLoja(int idEmpresa){
       for(Lote loteAtual : lotesBd ) {
          if (loteAtual.getIdEmpresa()==idEmpresa) {
              System.out.println("Id do Lote:" + loteAtual.getIdLote());
              System.out.println("Descricao: " + loteAtual.getDescItens());
          }
       }
    }
   
   public void getLotesBaseStatus(int status, int idEmpresa){
        for(Lote loteAtual : lotesBd ) {
          if (loteAtual.getIdEmpresa()==idEmpresa && loteAtual.getCdStatusLote()==status) {
              System.out.println("Id do Lote:" + loteAtual.getIdLote());
              System.out.println("Descricao: " + loteAtual.getDescItens());
          }
       }
   }
   
   public void contabilizarLoteComStatus(int status, int idEmpresa){
       int lotesComStatus = 0; 
       for(Lote loteAtual : lotesBd ) {
            if (loteAtual.getIdEmpresa()==idEmpresa && loteAtual.getCdStatusLote()==status) {
                lotesComStatus++;
            }
         }
       
       System.out.println("A empresa possui: " + lotesComStatus);
   }
   
   public Empresa getLoginEmpresa(String cnpj, String senha){
        for (Empresa empresaAtual : empresaBd){
            if(empresaAtual.getCnpj().trim().equalsIgnoreCase(cnpj.trim()) &&
               empresaAtual.getSenha().trim().equalsIgnoreCase(senha.trim()))
               return empresaAtual;
        }
    return null;
   }
}
