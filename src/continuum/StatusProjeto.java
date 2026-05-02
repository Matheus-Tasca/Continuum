package continuum;

public class StatusProjeto {
    private int cdStatus;
    private String descStatusProjeto;

    public StatusProjeto(int cdStatus, String descStatusProjeto) {
        this.cdStatus = cdStatus;
        this.descStatusProjeto = descStatusProjeto;
    }

    public int getCdStatus() { return cdStatus; }
    public void setCdStatus(int cdStatus) { this.cdStatus = cdStatus; }

    public String getDescStatusProjeto() { return descStatusProjeto; }
    public void setDescStatusProjeto(String descStatusProjeto) { this.descStatusProjeto = descStatusProjeto; }
    
    public void imprimeDescricaoStatus(int status){
        switch (status) {
            case 0: System.out.println("Projeto iniciado"); 
            case 1: System.out.println("Projeto em processo");
            case 2: System.out.println("Projeto com reclamacao aberta");
            case 3: System.out.println("Projeto finalizado");
            default: System.out.println("Status nao encontrado");
        }  
    }
}