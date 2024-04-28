
public class Exercicio7 {
	public static void main(String[] args) {
		System.out.println("Início do main");//ok
		metodo1();
		System.out.println("Fim do main");
	}

	static void metodo1() {
		System.out.println("Início do metodo1");//ok
		metodo2();
		System.out.println("Fim do metodo1");
	}

	static void metodo2() {
		System.out.println("Início do metodo2");//ok
		int[] array = new int[5];
		for (int i = 0; i <= 5; i++) {
			try {
				array[i] = i;
				System.out.println(i);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("ind. inválido");
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			}
		}
		System.out.println("Fim do metodo2");
	}
}
