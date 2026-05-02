package continuum.casosDeUsoDoador;
import continuum.BdMock;
import continuum.Doador; 

    
public class VisualizarDoacoes {
    Doador doador;
    
    
    public VisualizarDoacoes (Doador doador) {       
        this.doador = doador;
    }
    
    public void visualizarDoacao() {
        System.out.println("Total de doações realizadas: " + doador.getNumDoacoes());
        
        if (doador.getNumDoacoes() > 5) {
            System.out.println("Parabens! Você tem direito aos descontos dos"
                    + "nossos parceiro! Acesse a aba de descontos");
        } else {
            int doacoesFaltantes;
            doacoesFaltantes =   5 - doador.getNumDoacoes();
            System.out.println("Faltam " + doacoesFaltantes + "para voce ganhar "
                    + "descontos.");
            System.out.println("Continue doando e ajude a criar moda com propósito!");
        }
    }
    
}
