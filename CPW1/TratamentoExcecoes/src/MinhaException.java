
//criando uma classe que é uma exceção -> extends Exception
public class MinhaException extends Exception {
	private int erro;

	MinhaException(int erro) {
		this.erro = erro;
	}

	public String toString() {
		return ("ProprioErro[" + erro + "]");
	}
}

 
