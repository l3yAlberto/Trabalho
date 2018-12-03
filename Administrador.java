package Trabalho;

public class Administrador extends Usuario{
	
	public Administrador(String nome, String cpf, String email, String senha, String tipo) {
		super(nome, cpf, email, senha, tipo);
	}
	public void cadastrar(CentralService central,Evento event) {
		for(Evento x : central.getRepEven()) {
			if (x.compare(event)) {
				System.out.println("Erro: Evento já existe");
				return;
			}
		}
		central.getRepEven().add(event);
		System.out.println("done");
	}
	public void cadastrar(CentralService central, Produto prod) {
		for(Produto x : central.getRepProd()) {
			if(x.compare(prod)) {
				System.out.println("Erro: Produto já existe");
				return;
			}
		}
		central.getRepProd().add(prod);
		System.out.println("done");
	}
	@Override
	public boolean compare(Usuario x) {
		if(x.getNome().equals(getNome()) || x.getCpf().equals(getCpf()) || x.getEmail().equals(getEmail()))
			return true;
		return false;
	}

}
