package br.edu.ifrs.pw1.documentos;

public class Cpf {
	//atributos
	private long numero;
	private int digito;
	
	//construtores
	public Cpf() {}
	public Cpf(long numero, int digito) {
		this.numero = numero;
		this.digito = digito;
	}
	//métodos
	public long getNumero() {		return numero;	}
	public void setNumero(long numero) {		this.numero = numero;	}
	public int getDigito() {		return digito;	}
	public void setDigito(int digito) {		this.digito = digito;	}
	
	@Override
	public String toString() {
		return "Cpf:" + numero + "-" + digito;
	}
}
