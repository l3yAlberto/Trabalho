package Trabalho;

import java.util.Scanner;
public class Principal {
	public static  Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws NumberFormatException {
		CentralService cent = new CentralServiceImpl();
		String help = "";
		help += "cadastrar\n";
		help +="entrar\n";
		help +="dc\n";
		help +="participante\n";
		help +="recarregar\n";
		help +="informações\n";
		help +="cadastrar_evento\n";
		help +="addProduto\n";
		help +="addEvento\n";
		help +="comprar";
		Usuario logado = null;
		while(true) {
			System.out.print("Digite o comando: ");
			String comando = sc.nextLine();
			
			if(comando.equals("help")) {
				System.out.println(help);
				continue;
			} if(comando.equals("sair")||comando.equals("exit")) {
				break;
			}
			String v[] = comando.split(" ");
			switch(v[0]) {
			case "cadastrar":
				try {
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("CPF: ");
					String cpf = sc.nextLine();
					System.out.print("E-mail: ");
					String email = sc.nextLine();
					System.out.print("Senha: ");
					String senha = sc.nextLine();
					System.out.println("\tTipo de Conta");
					System.out.println("1-Cliente\n2-Administrador");
					int tipo = Integer.parseInt(sc.nextLine());
					String tipo1 = (tipo==1)?"Cliente":"";
					tipo1 = (tipo==2)?"Administrador":tipo1;
					
					if (nome.length()==0||cpf.length()==0||email.length()==0||senha.length()==0) 
						throw new NullException();
					
					if(tipo==1||tipo==2||tipo==3) {
						if(tipo==1) {
								Usuario a = new Cliente(nome,cpf,email,senha,tipo1);
								cent.cadastrar(a);
						}if(tipo==2) {
								Usuario a2 = new Administrador(nome,cpf,email,senha,tipo1);
								cent.cadastrar(a2);
						}
					}
					
					else 
						throw new NullException();
					
				}catch(NumberFormatException | NullException x ) {
					System.out.println("Erro comando invalido\n");
				}
				break;
				
			case "entrar":
				try {
					System.out.println("E-mail");
					String login = sc.nextLine();
					System.out.println("Senha");
					String senha = sc.nextLine();
					if (login.length()==0||senha.length()==0) 
						throw new NullException();
					logado = cent.login(login, senha);
				}catch(NullException x) {
					System.out.println("Erro comando invalido");
				}
				break;
			case "dc":
				logado = null;
				System.out.println("done");
				break;
				
			case "participante":
				try {
					System.out.println("Qual E-mail: ");
					String email = sc.nextLine();
					Cliente usuario = cent.buscar(email);
					usuario.eventos();
				}catch(NullPointerException x) {
					System.out.println("Usuário não existe ou não é cliente.");
				}
				break;
				
			case "recarregar":
				if(logado==null) {
					System.out.println("Erro: Você não está logado");
					break;
				}if(logado.getTipo().equals("Cliente")) {
					System.out.println("Qual valor: ");
					double a = Double.parseDouble(sc.nextLine());
					Cliente y = (Cliente) logado;
					cent.recarregar(y, a);
				}
				break;
			
			//informações do evento atração e produtos
			case "informações":
				System.out.println("Qual evento: ");
				String atr = sc.nextLine();
				Evento x3 = cent.buscarEvent(atr);
				System.out.println(x3.getAtracao());
				for(Produto x : x3.getProdutos()) {
					System.out.println(x.toString());
				}
				break;
				
			case "cadastrar_evento":
				if(logado==null) {
					System.out.println("Erro: Você não está logado");
					break;
				}
				if(logado.getTipo().equals("Administrador")) {
					System.out.println("Atração: ");
					String atracao = sc.nextLine();
					Evento event = new Evento(atracao);
					cent.getRepEven().add(event);
				}else {
					System.out.println("Erro: Você não é Administrador");
				}
				break;
			
			case "pagamento":
				break;
			
			//cadastrar produto_evento
			case "addProduto":
				try {
					if(logado.getTipo().equals("Administrador")) {
						System.out.println("Nome do Produto: ");
						String nomepro = sc.nextLine();
						System.out.println("Preço do Produto: ");
						double preço = Double.parseDouble(sc.nextLine());
						System.out.println("Id do Produto: ");
						double id = Double.parseDouble(sc.nextLine());
						System.out.println("Tipo do Produto: ");
						String tipo = sc.nextLine();
						Produto pro = new Produto(preço,id,nomepro,tipo);
						for(Evento x: cent.getRepEven()) {
							System.out.println(cent.getRepEven().indexOf(x)+"-"+x.getAtracao());
						}
						System.out.print("Qual evento você quer colocar o Produto: ");
						int q = Integer.parseInt(sc.nextLine());
						cent.cadastrarProdut(pro,cent.getRepEven().get(q));
					}else {
						System.out.println("Você não é Administrador ou não está logado.");
					}
				}catch(NumberFormatException x) {
					System.out.println("Comando invalido.");
				}
				break;
				
			case "addEvento":
				if(logado==null) {
					System.out.println("Erro: Você não está logado");
					break;
				}if(cent.getRepEven().size()==0) {
					System.out.println("Erro: Nenhum evento cadastrado.");
					break;
				}if(logado.getTipo().equals("Cliente")) {
					try {
						for(Evento x: cent.getRepEven()) {
							System.out.println(cent.getRepEven().indexOf(x)+"-"+x.getAtracao());
						}
						System.out.print("Qual evento você quer participar: ");
						int q = Integer.parseInt(sc.nextLine());
						Cliente p = (Cliente) logado;
						cent.addEvento(p, cent.getRepEven().get(q));
					}catch(IndexOutOfBoundsException | NumberFormatException x) {
						System.out.println("Comando invalido.");
					}catch(NullException l) {
						System.out.println("Erro: Evento já cadastrado.");
					}
				}else {
					System.out.println("Erro: Você não é Cliente.");
				}
				break;
				
			//evento e qual produto
			case "comprar":
				if(logado==null) {
					System.out.println("Erro: Você não está logado");
					break;
				}if(logado.getTipo().equals("Cliente")) {
					Cliente p1 = (Cliente) logado;
					if(p1.getCliEvent().size()==0) {
						System.out.println("Erro: Nenhum evento cadastrado.");
						break;
					}
				}if(logado.getTipo().equals("Cliente")) {
					Cliente p2 = (Cliente) logado;
					for(Evento x: p2.getCliEvent()) {
						System.out.println(p2.getCliEvent().indexOf(x)+"-"+x.getAtracao());
					}
					System.out.print("Em Qual evento você está: ");
					int q = Integer.parseInt(sc.nextLine());
					if(cent.getRepEven().get(q).getProdutos().size()==0) {
						System.out.println("Erro: Nenhum produto cadastrado.");
						break;
					}else {
						for(Produto x: cent.getRepEven().get(q).getProdutos()) {
							System.out.println(cent.getRepEven().get(q).getProdutos().indexOf(x)+"-"+x.toString());
	
						}
						System.out.print("Qual produto você quer comprar: ");
						int q1 = Integer.parseInt(sc.nextLine());
						if(cent.getRepEven().get(q).getProdutos().get(q1).getPreço()>p2.getCredito()) {
							System.out.println("Erro: Credito insuficinte.");
							break;
						}else {
							cent.comprar(cent.getRepEven().get(q),p2, cent.getRepEven().get(q).getProdutos().get(q1));
						}
					}
				}else {
					System.out.println("Erro: Você não é Cliente.");
				}
				break;
			default:
				System.out.println("Comando invalido.");

			}
			
		}

	}
}
