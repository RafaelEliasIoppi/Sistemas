package modificstatic.pessoas;

public class TesteStatic2 {
		 public static void main(String args[]) { 
			 Cliente c1 = new Cliente();
			 System.out.println(c1.getContador());
	         Cliente c2 = new Cliente();
			 System.out.println(Cliente.getContador());
	    }
	}
