package Trabalho;

import java.util.ArrayList;

public interface CentralService {

	public ArrayList<Usuario> getRepUsua();

	public void setRepUsua(ArrayList<Usuario> repUsua);

	public ArrayList<Evento> getRepEven();

	public void setRepEven(ArrayList<Evento> repEven);

	public ArrayList<Produto> getRepProd();

	public void setRepProd(ArrayList<Produto> repProd);

	public boolean cadastrar(Usuario usu);


	public Usuario login(String login, String senha);


	public Cliente buscar(String email);


	public void recarregar(Cliente x, double a);


	public Evento buscarEvent(String atra);


	public boolean cadastrarProdut(Produto x1, Evento y);


	public void addEvento(Cliente x, Evento y) throws NullException;


	public void comprar(Evento x, Cliente y, Produto z);

}