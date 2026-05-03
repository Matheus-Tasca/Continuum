package continuum;

import continuum.utilitarios.Constantes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Projeto {
    private static int contadorId = 0;
    private int idProjeto;
    private int idLote;
    private String cpfEstudante;
    private int cdStatusProjeto;
    private Date dataEncerramento;

    public Projeto(int idLote, String cpfEstudante) {
        contadorId++;
        this.idProjeto = contadorId;
        this.idLote = idLote;
        this.cpfEstudante = cpfEstudante;
        this.cdStatusProjeto = Constantes.CODIGO_PROJETO_INICIADO;
    }

    public int getIdProjeto() { return idProjeto; }
    public void setIdProjeto(int idProjeto) { this.idProjeto = idProjeto; }

    public int getIdLote() { return idLote; }
    public void setIdLote(int idLote) { this.idLote = idLote; }

    public String getCpfEstudante() { return cpfEstudante; }
    public void setCpfEstudante(String cpfEstudante) { this.cpfEstudante = cpfEstudante; }

    public int getCdStatusProjeto() { return cdStatusProjeto; }
    public void setCdStatusProjeto(int cdStatusProjeto) { this.cdStatusProjeto = cdStatusProjeto; }

    public String getDataEncerramento() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        return formatador.format(this.dataEncerramento);
    }

    public void setDataEncerramento(Date dataEncerramento) {this.dataEncerramento = dataEncerramento;}
    
    public void finalizarProjeto() {
        this.cdStatusProjeto = 3;
        this.dataEncerramento = new Date();
    }
}