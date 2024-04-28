import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Exercicio13 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Informe o número para a tabuada:\n");
		try {
			int n = entrada.nextInt();
			try(PrintWriter gravarArq = new PrintWriter(new FileWriter("tabuada.txt"));) {
				//escrever as linhas 13 e 14 em um única linha
				//FileWriter arq = new FileWriter("tabuada.txt");
				//PrintWriter gravarArq = new PrintWriter(arq);
				//OU:
				gravarArq.printf("+--Resultado--+%n");
				for (int i = 1; i <= 10; i++) {
					gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i * n));
				}
				gravarArq.printf("+-------------+%n");
				//gravarArq.close();
				//arq.close();
				System.out.println("\nTabuada do " + n + " foi gravada na em tabuada.txt\n");
			}catch(IOException e) {
				System.out.println("Exceção ao escrever no arquivo");
			}
		}catch(InputMismatchException e) {
			System.out.println("Não conseguiu converter para o típo certo");
		}catch(NoSuchElementException e) {
			System.out.println("if input is exhausted");
		}catch(IllegalStateException e) {
			System.out.println("Objeto entrada está fechado (scanner)");
		}
	}
}