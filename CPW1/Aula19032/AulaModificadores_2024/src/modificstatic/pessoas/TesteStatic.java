package modificstatic.pessoas;

public class TesteStatic {
		 public static void main(String args[]) { 
			 Cliente c1 = new Cliente();
			 System.out.println(c1.contador);
	         Cliente c2 = new Cliente();
			 System.out.println(Cliente.contador);
	    }
	}
