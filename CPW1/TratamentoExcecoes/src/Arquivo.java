import java.io.*;

public class Arquivo {
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;
	private String nomeArq;

	public Arquivo(String nome) {
		nomeArq = nome;
	}

	public void abrir(String tipo) {
		if (tipo.equals("w")) { // abre para gravação
			try {
				saida = new ObjectOutputStream(new FileOutputStream(nomeArq));
				System.out.println("Aberto para Gravação");
			}catch(FileNotFoundException e) {
				System.out.println("Arquivo de escrita não encontrado");
			}catch(SecurityException e) {
				System.out.println("Sem acesso ao arquivo de escrita");
			}catch(IOException e) {
				System.out.println("Exceção de I/O");
			}catch(NullPointerException e) {
				System.out.println("objeto saida está nulo");
			}
		} else { // abre para leitura
			try {
				entrada = new ObjectInputStream(new FileInputStream(nomeArq));
				System.out.println("Aberto para Leitura");
			}catch(FileNotFoundException e) {
				System.out.println("Arquivo de leitura não encontrado");
			}catch(SecurityException e) {
				System.out.println("Sem acesso ao arquivo de leitura");
			}catch(IOException e) {
				System.out.println("Exceção de I/O no arquivo de leitura");
			}
		}
	}

	public void gravarObjeto(Object obj) {
		try {
		  saida.writeObject(obj);
		}catch(IOException e){
				System.out.println("Exceção de I/O ao salvar objeto");
		}
	}

	public Object lerObjeto() {
		try {
			return entrada.readObject();
		}catch(ClassNotFoundException e) {
			System.out.println("classe não localizada");
		}catch(InvalidClassException e) {
			System.out.println("classe inválida");
	    }catch(StreamCorruptedException e) {
	    	System.out.println("Objeto no arquivo está corrompido");
	    }catch(OptionalDataException e) {
	    	System.out.println("Não é objeto é tipo primitivo");
	    }catch(IOException e){
			System.out.println("Exceção de I/O ao ler objeto");
	    }
		return null;
	}
	
    public void fechar() {
		if(saida != null)
			try {
			   saida.close();
			}catch(IOException e) {
				System.out.println("Exceção ao fechar arq de escrita");
			}
		if(entrada != null) 
			try {
			   entrada.close();
			}catch(IOException e) {
				System.out.println("Exceção ao fechar arq de leitura");
			}
	}
}




