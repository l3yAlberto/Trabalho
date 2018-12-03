package Trabalho;

import java.util.ArrayList;

public class Produto {
	private double pre�o;
	private double id;
	private String nome;
	private String tipo;
	private ArrayList<Usuario> compradores;
	
	public Produto(double pre�o, double id, String nome, String tipo) {
		super();
		this.pre�o = pre�o;
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.compradores = new  ArrayList<Usuario>();
	}
	public double getPre�o() {
		return pre�o;
	}
	public void setPre�o(double pre�o) {
		this.pre�o = pre�o;
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
		String res = "Nome: "+nome+" Tipo: "+tipo+" Pre�o: "+pre�o;
		return res;
	}
}
