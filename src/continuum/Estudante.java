package continuum;
public class Estudante {
    private static int contadorId = 0;
    private String cpf;
    private int id;
    private String nome;
    private String ra;
    private String cep;
    private String nmFaculdade;
    private String email;
    private String nrEndereco;
    private boolean possuiProjetoAtivo;
    private String senha;

    public Estudante(
        String cpf, 
        String nome, 
        String ra,
        String cep,
        String nmFaculdade,
        String email,
        String nrEndereco,
        String senha) {
            contadorId++; 
            this.id = contadorId;

            this.cpf = cpf;
            this.nome = nome;
            this.ra = ra;
            this.cep = cep;
            this.nmFaculdade = nmFaculdade;
            this.email = email;
            this.nrEndereco = nrEndereco;
            this.senha = senha;
            this.possuiProjetoAtivo = false;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getNmFaculdade() { return nmFaculdade; }
    public void setNmFaculdade(String nmFaculdade) { this.nmFaculdade = nmFaculdade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNrEndereco() { return nrEndereco; }
    public void setNrEndereco(String nrEndereco) { this.nrEndereco = nrEndereco; }

    public boolean validarRa() {
        return ra != null && ra.matches("\\d{8}");
    }

        public boolean isPossuiProjetoAtivo() {
        return possuiProjetoAtivo;
    }

    public void setPossuiProjetoAtivo(boolean possuiProjetoAtivo) {
        this.possuiProjetoAtivo = possuiProjetoAtivo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean vincularProjeto() {
        if (possuiProjetoAtivo) return false;
        possuiProjetoAtivo = true;
        return true;
    }
}