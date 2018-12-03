package Trabalho;

public abstract class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String tipo;
	public Usuario(String nome, String cpf, String email, String senha, String tipo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
	public abstract boolean compare(Usuario x);

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", tipo=" + tipo
				+ "]";
	}
}
