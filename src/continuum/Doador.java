package continuum;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Doador {
    private static int contadorId = 0;
    private String cpf;
    private String cep;
    private String nome;
    private String telefone;
    private int numDoacoes;
    private String numeroEndereco;
    private List<Desconto> cupons;
    private String senha;

    public Doador(
            String cpf,
            String cep, 
            String nome, 
            String telefone, 
            String numeroEndereco,
            String senha) {
        this.cpf = cpf;
        this.cep = cep;
        this.nome = nome;
        this.telefone = telefone;
        this.numDoacoes = 0;
        this.numeroEndereco = numeroEndereco;
        this.senha = senha;
        this.cupons = new ArrayList<>();
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getNome() { return nome; }
    public void setNm(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public int getNumDoacoes() { return numDoacoes; }
    public void setNumDoacoes(int numDoacoes) { this.numDoacoes = numDoacoes; }

    public String getNumeroEndereco() { return numeroEndereco; }
    public void setNumeroEndereco(String nrEndereco) { this.numeroEndereco = nrEndereco; }
    
    public String getSenha() { return senha;}
    public void setSenha(String senha) { this.senha = senha;}
        
    public List<Desconto> getCupons() { return cupons; }
    
    public void realizarDoacao() {
        this.numDoacoes++; 
        
        if (this.numDoacoes % 5 == 0 && this.numDoacoes > 0) {
            Random random = new Random();
            int min = 10;
            int max = 100000000;
            int idAleatorio = random.nextInt((max - min) + 1) + min;
            
            String codigoGerado = this.cpf + idAleatorio;
            
            Desconto novoCupom = new Desconto(idAleatorio, codigoGerado, this.cpf);
            
            this.cupons.add(novoCupom);
            
            System.out.println("Cupom gerado: " + codigoGerado);
        }
    }
}


