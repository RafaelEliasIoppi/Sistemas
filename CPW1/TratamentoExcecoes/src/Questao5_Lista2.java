import java.io.*;
public class Questao5_Lista2 {
	public static void main(String[] args) {
		// gravando caracteres e Strings
		try (FileWriter fw = new FileWriter(new File("Ex5.txt"));){
			fw.write('2');
			fw.write("2");
		}catch(NullPointerException e){
			System.out.println("Objeto do arquivo nulo");
		}catch(IOException e) {
			System.out.println("exceção no arquivo de escrita");
		}
		// gravando caracteres e Strings
		try (FileReader fr = new FileReader(new File("Ex5.txt"))) {
			int c = fr.read();
			while (c != -1) {
				System.out.print((char) c);
				c = fr.read();
			}
		}catch(NullPointerException e){
			System.out.println("Objeto de leitura do arquivo nulo");
		}catch(FileNotFoundException e) {
			System.out.println("Arquivo leitura não encontrado");
		}catch (IOException e) {
			System.out.println("exceção no arquivo de leitura");
		}
	}
}
