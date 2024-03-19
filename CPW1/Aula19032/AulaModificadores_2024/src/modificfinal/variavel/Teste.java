package modificfinal.variavel;

public class Teste {
	public static void main(String[] args) {
		metodo1("valor");
		metodo2();
	}

	public static void metodo1(final String valor) {
		valor = "outro objeto String";
	}

	public static void metodo2() {
		final String novoValor;
		novoValor = "outro objeto String";
		System.out.println(novoValor);
	}
}
