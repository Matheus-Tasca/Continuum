package continuum.casosDeUsoDoador;
import continuum.Doador; 
    
    
public class VisualizarDoacoes {
    Doador doador;
    boolean doadorLogado;
    
    public VisualizarDoacoes (Doador doador, boolean doadorLogado) {       
        this.doador = doador;
        this.doadorLogado = doadorLogado;
    }
    
    public void executar() {
         if(!doadorLogado){
            System.out.println("O doador deve estar logado.");
            return;
        }
        
        System.out.println("Total de doações realizadas: " + doador.getNumDoacoes());
        
        if (doador.getNumDoacoes() % 5 == 0 && doador.getNumDoacoes() > 0) {
            System.out.println("Parabens! Você tem direito aos descontos dos"
                    + "nossos parceiros! Acesse a aba de descontos");
            return;
        }
        
        int doacoesFaltantes = (5 - (doador.getNumDoacoes() % 5)) % 5;
        
        if(doador.getNumDoacoes() == 0)
            doacoesFaltantes = 5;
        
        System.out.println("Faltam " + doacoesFaltantes + " para voce ganhar descontos.");
        System.out.println("Continue doando e ajude a criar moda com propósito!");
}
    
}
