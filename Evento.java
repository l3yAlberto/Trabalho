package Trabalho;

import java.util.ArrayList;

public class Evento {
	private ArrayList<Usuario> clientes;
	private ArrayList<Produto> produtos;
	private String atracao;

	
	public Evento(String atracao) {
		super();
		this.clientes = new ArrayList<Usuario>();
		this.produtos = new ArrayList<Produto>();
		this.atracao = atracao;
	}
	
	public ArrayList<Usuario> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Usuario> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getAtracao() {
		return atracao;
	}

	public void setAtracao(String atracao) {
		this.atracao = atracao;
	}

	public boolean compare(Evento x) {
		if(x.getAtracao().equals(atracao))
			return true;
		return false;
	}
	public String toString() {
		String res = "Atração: "+atracao;
		return res;
	}
}
