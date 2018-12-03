package Trabalho;

import java.util.ArrayList;

public class Produto {
	private double preço;
	private double id;
	private String nome;
	private String tipo;
	private ArrayList<Usuario> compradores;
	
	public Produto(double preço, double id, String nome, String tipo) {
		super();
		this.preço = preço;
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.compradores = new  ArrayList<Usuario>();
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Usuario> getCompradores() {
		return compradores;
	}
	public void setCompradores(ArrayList<Usuario> compradores) {

		this.compradores = compradores;
	}
	
	public boolean compare(Produto x) {
		if(x.getNome().equals(nome)||x.getId()==id) 
			return true;
		return false;
		
	}
	public String toString() {
		String res = "Nome: "+nome+" Tipo: "+tipo+" Preço: "+preço;
		return res;
	}
}
