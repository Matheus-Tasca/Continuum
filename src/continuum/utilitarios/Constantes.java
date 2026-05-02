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
    public static final int OPCAO_SAIR_SELECAO_EMPRESAS = 0;
    
    public static final int ID_LOTE_INVALIDO = -1;
}
