package Geral;

import java.util.*;

import Externo.Class.*;
import Externo.Menu.*;
import Interno.Menu.*;

public class MenuLoja {
	public static void main(String[] args) {
		Shop lista = new Shop();
		int esc = 1;
		Scanner sc = new Scanner(System.in);

		Cliente log = new Cliente();
		Teste t1 = new Teste();

		while (true) {
			Utils.clearConsole();
			System.out.println("=======================================");
			System.out.println("           Menu Principal              ");
			System.out.println("=======================================");
			System.out.println("Selecione uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Fornecedor");
			System.out.println("2. Produto");
			System.out.println("3. Estoque");
			System.out.println("---------------------------------------");
			System.out.println("4. Cadastro Cliente");
			System.out.println("5. Login");
			System.out.println("---------------------------------------");
			System.out.println("6. Pedidos em aberto");
			System.out.println("9. Modo teste");
			System.out.println("0. Sair\n");
			System.out.print("Opção: ");
			esc = sc.nextInt();
			switch (esc) {
			case 1: //fornecedor
				MenuFornecedor.SupMenu(lista,sc);
				break;
			case 2: //produto
				MenuProduto.ProMenu(lista,sc);
				break;
			case 3: //estoque
				MenuEstoque.EstqMenu(lista,sc);
				break;
			case 4: //Cliente
				MenuCad.cadMenu(lista,sc);
				break;
			case 5: //Login
				Utils.clearConsole();
				System.out.println("------------------------------");
				System.out.println("           LOGIN              ");
				System.out.println("------------------------------");

				sc.nextLine();
			
				System.out.print("Usuário: ");
				String usuario = sc.nextLine();
			
				System.out.print("Senha: ");
				String senha = sc.nextLine();
			
				log.setLogin(usuario);
				log.setSenha(senha);
			
				t1 = lista.authUser(log);
			
				System.out.println("------------------------------");
			
				if (t1.getTest()) {
					System.out.println("Login bem-sucedido! Bem-vindo, " + lista.userAt(t1.getIndex()).getNome() + ".");
					Utils.fim();
					MenuCliente.menuUser(lista.userAt(t1.getIndex()), lista,sc);
				} else {
					System.out.println("Usuário ou senha inválido, tente novamente.");
				}
				System.out.println("------------------------------");
				Utils.fim();
			break;
			case 6: //Pedidos
				MenuPedidos.cadMenu(lista, sc);
				break;
			case 9:
				Utils.clearConsole();
				Utils.lerARQ(lista);
				System.out.println("=======================================");
				System.out.println("       Modo Teste Ativado!             ");
				System.out.println("=======================================");
				Utils.fim();
				break;
			case 0:
				System.out.println("Fim...");
				sc.close();
				return;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				Utils.fim();
			}
		}
	}
}
