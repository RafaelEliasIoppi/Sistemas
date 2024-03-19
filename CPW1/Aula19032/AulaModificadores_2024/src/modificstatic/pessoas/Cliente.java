package modificstatic.pessoas;

public final class Cliente {
	private String nome;
    public static int contador=0;
    
    public Cliente(){ this(null);}
    public Cliente(String nome) {
          contador++;
          this.nome = nome;
     }
    
    public static int getContador(){
        return contador;
    }


}
