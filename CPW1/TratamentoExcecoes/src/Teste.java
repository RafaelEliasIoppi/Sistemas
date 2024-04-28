public class Teste { 
	static void calcula(int a) throws MinhaException {
		if (a <= 12)
			throw new MinhaException(a);
	}

	public static void main(String args[]) {
		try {
			calcula(9);
			calcula(11);
		} catch (MinhaException e) {
			System.out.println("Erro encontrado: " + e);
		}
	}
}
