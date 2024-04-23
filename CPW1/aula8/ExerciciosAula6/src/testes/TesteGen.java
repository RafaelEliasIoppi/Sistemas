package testes;

import java.util.LinkedList;

import contatos.Telefone;
import documentos.Cpf;
import pessoas.Pessoa;

public class TesteGen {
	public static void main(String[] args) {
		LinkedList telefones = new LinkedList();
		telefones.add(new Cpf());
		telefones.add(new Telefone());
		telefones.add(new Pessoa());
		
		
	}
}





