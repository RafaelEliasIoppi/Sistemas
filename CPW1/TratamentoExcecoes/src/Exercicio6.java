
import java.util.*;

public class Exercicio6 {
	public static void main(String args[]) {
		try {
			TreeSet<Number> numeros = new TreeSet<>();
			numeros.add(5);
			numeros.add(8);
			numeros.add(7);
			numeros.add(null);
			for (Number num : numeros)
				System.out.println("Num: " + num);
		}catch(ClassCastException e) {
			System.out.println("Exceção ClassCast");
			//e.printStackTrace();
		}catch(NullPointerException e) {
			System.out.println("Exceção NullPointer");
			//e.printStackTrace();
		}
	}
}

/*
Analisando a saída gerada, responda os itens abaixo para as questões 1 a 4:
4.1 Qual o nome da classe em que foi gerada a exceção?
4.2 Qual o nome do método em que a exceção foi gerada?
4.3 Qual a linha que gerou a exceção?
4.4 Qual exceção foi gerada?
4.5 Qual a causa da exceção gerada?
*/