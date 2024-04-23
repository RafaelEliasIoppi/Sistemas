package pessoas;

import java.util.LinkedList;
import java.util.Objects;

import contatos.Telefone;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private LinkedList<Telefone> telefones;
	
	@Override
	public int compareTo(Pessoa objPessoa) {
		return getNome().compareTo(objPessoa.getNome());
	}
	
	public Pessoa() {}
	public Pessoa(String nome, LinkedList<Telefone> telefones) {
		this.nome = nome;
		this.telefones = telefones;
	}
	public String getNome() {		return nome;	}
	public void setNome(String nome) {		this.nome = nome;	}
	public LinkedList<Telefone> getTelefones() {		return telefones;	}
	public void setTelefones(LinkedList<Telefone> telefones) {		this.telefones = telefones;	}
	@Override
	public String toString() {
		String aux = "";
		for (Telefone telefone : telefones) {
			if(telefone != null) 
				aux += telefone.toString()+"\n";
		}
		if(aux.isEmpty()) aux = "Sem telefones cadastrados";
		return "Nome: " + nome + "\n" + aux;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}

	
}
