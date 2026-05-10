package continuum;

public class Empresa {
    private static int contadorIdEmpresa = 0;
    
    private String cnpj;
    private int idEmpresa;
    private String nmFantasia;
    private String email;
    private String cep;
    private boolean situacaoCadastral;
    private String nrEndereco;
    private String senha;

    private boolean logado;
    
    public Empresa(){
        this.idEmpresa = -1;
    }
     
    public Empresa(String cnpj, String nmFantasia, String email, String cep, String nrEndereco) {
        contadorIdEmpresa++;
        this.cnpj = cnpj;
        this.idEmpresa = contadorIdEmpresa;
        this.nmFantasia = nmFantasia;
        this.email = email;
        this.cep = cep;
        this.situacaoCadastral = true;
        this.nrEndereco = nrEndereco;
        this.logado = false;
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getNmFantasia() { return nmFantasia; }
    public void setNmFantasia(String nmFantasia) { this.nmFantasia = nmFantasia; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public boolean getSituacaoCadastral() { return situacaoCadastral; }
    public void setSituacaoCadastral(boolean situacaoCadastral) { this.situacaoCadastral = situacaoCadastral; }

    public String getNrEndereco() { return nrEndereco; }
    public void setNrEndereco(String nrEndereco) { this.nrEndereco = nrEndereco; }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public void verificarAtividade(){
        if(situacaoCadastral){
            System.out.println("Empresa apta para atuuar");
        }else{
            System.out.println("Empresa inapta para atuar");
        }
    }
    
}

