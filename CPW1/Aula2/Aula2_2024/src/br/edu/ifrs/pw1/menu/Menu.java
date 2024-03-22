package br.edu.ifrs.pw1.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

import br.edu.ifrs.pw1.clientes.ClientePessoaFisica;
import br.edu.ifrs.pw1.contatos.Endereco;
import br.edu.ifrs.pw1.documentos.Cpf;

public class Menu {
	public static void main(String[] args) {
		ArrayList<ClientePessoaFisica> clientes = new ArrayList<>();
		
		//laço infinito que vai controlar o cadastro dos clientes
		while(true) {
			switch(montaMenu()) {
			     case 1://Cadastrar Cliente Pessoa Física
			    	    
			    	    //String logradouro, String complemento, long cep
			    	    //cpf = long numero e int digito
			    	    String nome = JOptionPane.showInputDialog("Informe o nome:");
						
				  	    String telefone = JOptionPane.showInputDialog("Informe o telefone:");
							
			    	    long numCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o número do CPF:"));
			    	    
								
						int digCpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o digito do CPF:"));
			    	    Cpf cpf = new Cpf(numCpf, digCpf);
			    	    
						//cada endereco tem: String logradouro, String complemento, long cep
			    	    int numEnderecos = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de endereços:"));
			    	    //declara o arraylist para adicionar os enderecos de cada cliente pessoa física
			    	    ArrayList<Endereco> enderecos = new ArrayList<>();
			    	    //lê cada um dos endereços do objeto clientes
			    	    for(int i=0; i< numEnderecos; i++) {
			    	    	String logradouro = JOptionPane.showInputDialog("Informe o logradouro:");
				    	    String complemento = JOptionPane.showInputDialog("Informe o complemento:");
				    	    long cep = Long.parseLong(JOptionPane.showInputDialog("Informe o CEP:"));
				    	    Endereco endereco = new Endereco(logradouro, complemento, cep);
				    	    enderecos.add(endereco);
			    	    }
			    	    ClientePessoaFisica clienteCad = new ClientePessoaFisica(telefone, enderecos, nome, cpf);
			    	    clientes.add(clienteCad);
			    	    //linhas 39 e 40 OU a linha 42
			    	    //clientes.add(new ClientePessoaFisica(telefone, enderecos, nome,cpf));
				        break;
			     case 2: //Pesquisar Cliente Pessoa Física pelo nome
			    	 	 //ler o nome que desejo pesquisar
			    	     String nomePesq = JOptionPane.showInputDialog("Informe o nome a ser pesquisado:");
			    	     boolean flag = false;
			    	     for (ClientePessoaFisica cli : clientes) {
			    	    	//objetos sempre são comparados usando o método equals() 
				    	 	if(cli.getNome().equalsIgnoreCase(nomePesq)) {
				    	    	JOptionPane.showMessageDialog(null, nomePesq + " localizado!");
				    	 		flag = true;
				    	 		break;
				    	 	}
						 }
			    	     if(flag == false)
			    	    	 JOptionPane.showMessageDialog(null, nomePesq + " não localizado!");
				         break;
			     case 3: //Pesquisar Cliente Pessoa Física pelo cpf
			    	     //ler o num e digito do CPF que desejo pesquisar
			    	     long numCpfPesq = Long.parseLong(JOptionPane.showInputDialog("Informe o número do CPF:"));
			    	     int digCpfPesq = Integer.parseInt(JOptionPane.showInputDialog("Informe o digito do CPF:"));
			    	     //renicializar a variável com o valor false
		    	         flag = false;
		    	         for (ClientePessoaFisica cli : clientes) {
		    	        	if(cli.getCpf()!=null) { 
			    	    	    //números sempre são comparados usando ==
				    	 	    if(cli.getCpf().getNumero() == numCpfPesq && cli.getCpf().getDigito() == digCpfPesq) {
				    	    	    JOptionPane.showMessageDialog(null, "CPF localizado! Ele pertence a:"+cli.getNome());
				    	 		    flag = true;
				    	 		    break;
				    	 	    }
		    	        	}
					     }
		    	         if(flag == false)
   		    	    	     JOptionPane.showMessageDialog(null, "CPF não localizado!");
			         break;
			     case 4: //Pesquisar Cliente Pessoa Física pelo endereco
			    	     //ler o logradouro que desejo pesquisar
			    	     String logradouroPesq = JOptionPane.showInputDialog("Informe o logradouro:");
			    	     //renicializar a variável com o valor false
			    	     String nomesEndPesq = "";
	    	             flag = false;
	    	             for (ClientePessoaFisica cli : clientes) {
	    	            	 if(cli !=null) {
	    	            		 List<Endereco> enderecosObjPesq = cli.getEnderecos();
	    	            	     for (Endereco endPesq : enderecosObjPesq) {
	    	            	    	 if(endPesq!=null) {
	    	            	    		 if(logradouroPesq.equals(endPesq.getLogradouro())) {
	    	            	    			 nomesEndPesq += cli.getNome() + "\n";
	    	            	    			 flag = true;
	    	            	    		 }
	    	            	    	 }
	    	            	     }
	    	            	 }	    	            	 
				         }
		    	         if(flag == true)
		    	        	 JOptionPane.showMessageDialog(null, nomesEndPesq + " moram nesse endereço!");
		    	         else
			    	    	 JOptionPane.showMessageDialog(null, "Ninguém foi localizado nesse end!");
				        break;
			     case 5: //listar todos clientes
			    	    if(clientes!=null) {
			    	    	//para cada ClientePessoaFisica que estiver na coleção clientes coloca no objeto
			    	    	//cliente e usa o objeto cliente dentro do laço
				    	 	for (ClientePessoaFisica cliente : clientes) {
				    	 		if(cliente != null)
				    	 			JOptionPane.showMessageDialog(null, cliente.toString());
							}
			    	    }
				        break;
			     case 6: //sair
			    	    System.exit(0);
				        break;
				 default: JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
	}
	private static int montaMenu() {
		String menu = "1-Cadastrar Cliente Pessoa Física\n"+
					  "2-Pesquisar Cliente Pessoa Física pelo nome\n"+
					  "3-Pesquisar Cliente Pessoa Física pelo CPF\n"+
					  "4-Pesquisar Cliente Pessoa Física pelo endereco\n"+
					  "5-Listar todos\n"+
					  "6-Sair\n";
		//converte de string para int
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
}

