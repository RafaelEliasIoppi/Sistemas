/**
 *
 * @author silviacb
 */
public class TesteEnumBebidas {
    public static void main(String[] args) {
       
    	
    	Marcas marca = Marcas.HP; // em marcar colocamos o valor da constante HP
    	System.out.println("Nome da Marca = "+marca.name()); // Imprime o valor que está na constante
    	for (Marcas m : Marcas.values()) {
    		System.out.println("m="+m); // percorre todo o conjunto de constantes e imprime o valor de cada uma
    	
    	
    	}
    	
    	System.out.println("---------------------");
    	for (DiasSemana dias: DiasSemana.values()) {
            System.out.println(dias.name());
            System.out.println(dias.getDescricao());
            
            
        }

        
        System.out.println("---------------------");
        for (Menu menu : Menu.values()) {
            System.out.println (menu.getOpcao() + " - " + menu.getDescricao());
            
        }


    			
    			
    			
    	
    	// System.out.println(Bebida.CocaCola.getDescricao() + ": R$" + Bebida.CocaCola.getPreco());
       // Percorre a enumera��o (percorre as constantes) e para cada item da enum
       // vai permitir fazer uma a��o, neste caso linha 14 - estamos pegando a descri��o	
        //for (Bebida bebida : Bebida.values()) {
            //System.out.println(bebida.getDescricao());
            
          //  System.out.print(bebida.getDescricao() + " -> ");
          //  System.out.println(bebida.getPreco());
      //  }
    }
}
