package continuum.utilitarios;

public final class Constantes {
    private Constantes() {
        throw new UnsupportedOperationException("Esta e uma classe de constantes e nao pode ser instanciada.");
    }
    
    public static final int OPCAO_DOADOR  = 1;
    
    public static final int OPCAO_EMPRESA = 2;
    
    public static final int OPCAO_ESTUDANTE = 3;
    public static final int OPCAO_ESTUDANTE_LOGAR = 1;
    public static final int OPCAO_ESTUDANTE_RESERVAR_LOTE = 2;
    
    public static final int OPCAO_SAIR = 0;
     
    public static final boolean USUARIO_LOGADO = true;
    
    public static final int ID_EMPRESA_INVALIDA = -1;
    
    public static final int ID_LOTE_INVALIDO = -1;
    
    public static final int ID_ESTADO_INVALIDO = -1;
    
    public static final int OPCAO_ENVIO = 1;
    public static final int OPCAO_RETIRADA = 2;
    
    public static final int CODIGO_STATUS_LOTE_DISPONIVEL = 0;
    public static final int CODIGO_STATUS_LOTE_EM_PREPARO = 1;
    public static final int CODIGO_STATUS_LOTE_TRANSPORTE_ESTILISTA = 2;
    public static final int CODIGO_STATUS_LOTE_RECEBIDO_ESTILISTA = 3;
    public static final int CODIGO_STATUS_LOTE_TRANSPORTE_LOJA = 4;
    public static final int CODIGO_STATUS_LOTE_RECEBIDO_LOJA = 5;
    public static final int CODIGO_STATUS_LOTE_RESERVADO = 6;
    public static final int CODIGO_STATUS_LOTE_AGUARDANDO_ENVIO = 7;
    
    public static final int CODIGO_STATUS_PROJETO_INICIADO = 0;
    public static final int CODIGO_STATUS_PROJETO_EM_PROCESSO = 1;
    public static final int CODIGO_STATUS_PROJETO_RECLAMACAO_ABERTA = 2;
    public static final int CODIGO_STATUS_PROJETO_FINALIZADO = 3;
}
