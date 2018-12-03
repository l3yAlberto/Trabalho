package Trabalho;
import java.util.ArrayList;

public class CentralServiceImpl implements CentralService {
	private ArrayList<Usuario> repUsua;
	private ArrayList<Evento> repEven;
	private ArrayList<Produto> repProd;

	public CentralServiceImpl() {
		this.repUsua = new ArrayList<Usuario>();
		this.repEven = new ArrayList<Evento>();
		this.repProd = new ArrayList<Produto>();
	}

	/* (non-Javadoc)
	 * @see Trabalho.CentralService#getRepUsua()
	 */
	@Override
	public ArrayList<Usuario> getRepUsua() {
		return repUsua;
	}

	/* (non-Javadoc)
	 * @see Trabalho.CentralService#setRepUsua(java.util.ArrayList)
	 */
	@Override
	public void setRepUsua(ArrayList<Usuario> repUsua) {
		this.repUsua = repUsua;
	}

	/* (non-Javadoc)
	 * @see Trabalho.CentralService#getRepEven()
	 */
	@Override
	public ArrayList<Evento> getRepEven() {
		return repEven;
	}

	/* (non-Javadoc)
	 * @see Trabalho.CentralService#setRepEven(java.util.ArrayList)
	 */
	@Override
	public void setRepEven(ArrayList<Evento> repEven) {
		this.repEven = repEven;
	}

	/* (non-Javadoc)
	 * @see Trabalho.CentralService#getRepProd()
	 */
	@Override
	public ArrayList<Produto> getRepProd() {
		return repProd;
	}

	/* (non-Javadoc)
	 * @see Trabalho.CentralService#setRepProd(java.util.ArrayList)
	 */
	@Override
	public void setRepProd(ArrayList<Produto> repProd) {
		this.repProd = repProd;
	}
	
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#cadastrar(Trabalho.Usuario)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#cadastrar(Trabalho.Usuario)
	 */
	@Override
	public boolean cadastrar(Usuario usu) {
		for(Usuario x: repUsua) {
			if (x.compare(usu)) {
				System.out.println("Erro: Usuário já existe.");
				return true;
			}
		}
		this.repUsua.add(usu);
		System.out.println("done.");
		return false;
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#login(java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario login(String login, String senha) {
		for(Usuario x : repUsua) {
			if(x.getEmail().equals(login)&&x.getSenha().equals(senha)) {
					System.out.println("done.");
					return x;
			}
		}
		System.out.println("Usuário não encontrado.");
		return null;
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#buscar(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#buscar(java.lang.String)
	 */
	@Override
	public Cliente buscar(String email) {
		for(Usuario x: repUsua) {
			if(x.getEmail().equals(email)||x.getTipo().equals("Cliente")) {
				return (Cliente) x;
			}
		}
	return null;
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#recarregar(Trabalho.Cliente, double)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#recarregar(Trabalho.Cliente, double)
	 */
	@Override
	public void recarregar(Cliente x, double a) {
		x.setCredito(a);
		for(Usuario x1 : repUsua) {
			if(x1.compare(x)) {
				x1 = x;
			}
		}
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#buscarEvent(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#buscarEvent(java.lang.String)
	 */
	@Override
	public Evento buscarEvent(String atra) {
		for(Evento x1 : repEven) {
			if(x1.getAtracao().equals(atra)) {
				return x1;
			}
		}
		System.out.println("Evento não encontrado.");
		return null;
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#cadastrarProdut(Trabalho.Produto, Trabalho.Evento)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#cadastrarProdut(Trabalho.Produto, Trabalho.Evento)
	 */
	@Override
	public boolean cadastrarProdut(Produto x1, Evento y) {
		for(Produto x : repProd) {
			if(x.compare(x1)) {
				System.out.println("Erro: Erro o produto já existe.");
				return true;
			}
		}
		for(Evento x : repEven) {
			if(x.compare(y)) {
				x.getProdutos().add(x1);
			}
		}
		repProd.add(x1);
		System.out.println("done.");
		return false;
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#addEvento(Trabalho.Cliente, Trabalho.Evento)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#addEvento(Trabalho.Cliente, Trabalho.Evento)
	 */
	@Override
	public void addEvento(Cliente x, Evento y)throws NullException {
		for(Evento y1: repEven) {
			if(y1.compare(y)) {
				for(Usuario y2: y1.getClientes()) {
					if(y2.compare(x)) {
						throw new NullException();
					}
				}
				y.getClientes().add(x);
				y1 = y;
				break;
			}
		}
		for(Usuario x11: repUsua) {
			if(x11.compare(x)) {
				Cliente x2 = (Cliente) x11;
				x2.cliEvent.add(y);
				x11 = x2;
				break;
			}
		}
		System.out.println("done.");
	}
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#comprar(Trabalho.Evento, Trabalho.Cliente, Trabalho.Produto)
	 */
	/* (non-Javadoc)
	 * @see Trabalho.CentralService#comprar(Trabalho.Evento, Trabalho.Cliente, Trabalho.Produto)
	 */
	@Override
	public void comprar(Evento x,Cliente y,Produto z) {
		for(Evento x1: repEven) {
			if(x1.compare(x)) {
				for(Usuario y1: repUsua) {
					if(y1.compare(y)) {
						for(Produto z1: repProd) {
							Cliente y2 = (Cliente) y1;
							y2.setCredito(y2.getCredito()-z.getPreço());
							y1 = y2;
							z1.getCompradores().add(y1);
							
							
						}
					}
				}
			}
		}
	}
}

