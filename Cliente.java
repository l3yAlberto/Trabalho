package Trabalho;

import java.util.ArrayList;

public class Cliente extends Usuario {
	public ArrayList<Evento> cliEvent;
	private ArrayList<Produto> produtos;
	private double codigo;
	private double credito;
	public Cliente(String nome, String cpf, String email, String senha, String tipo) {
		super(nome, cpf, email, senha, tipo);
		this.cliEvent = new ArrayList<Evento>();
		this.produtos = new ArrayList<Produto>();
	}
	public boolean compare(Usuario x) {
		if(getNome().equals(x.getNome())||this.getCpf().equals(x.getCpf())||this.getEmail().equals(x.getEmail())) {
			return true;
		}
		return false;
	}
	public void eventos() {
		for(Evento x: cliEvent) {
			System.out.println(x.toString());
		}
	}

	public ArrayList<Evento> getCliEvent() {
		return cliEvent;
	}

	public void setCliEvent(ArrayList<Evento> cliEvent) {
		this.cliEvent = cliEvent;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
}
