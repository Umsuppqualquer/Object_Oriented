package Geral;

import java.util.*;

import Externo.Menu.MenuCadastro;
import Interno.Menu.MenuEstoque;
import Interno.Menu.MenuFornecedor;
import Interno.Menu.MenuProduto;

public class MenuLoja {
	public static void main(String[] args) {
		Shop lista = new Shop();
		int esc = 1;
		Scanner sc1 = new Scanner(System.in);

		while (true) {
			Utils.clearConsole();
			System.out.println("Selecione uma opção:");
			System.out.println("1. Fornecedor.");
			System.out.println("2. Produto.");
			System.out.println("3. Estoque.");
			System.out.println("--------------------");
			System.out.println("4. Cadastro Cliente.");
			System.out.println("5. Login.");
			System.out.println("9. Modo teste.");
			System.out.println("0. Sair\n");
			esc = sc1.nextInt();
			switch (esc) {
			case 1:
				System.out.println("1. Fornecedor"); //revisado
				MenuFornecedor.SupMenu(lista);
				break;
			case 2:
				System.out.println("2. Produto");
				MenuProduto.ProMenu(lista);
				break;
			case 3:
				System.out.println("3. Estoque");
				MenuEstoque.EstqMenu(lista);
				break;
			case 4:
				System.out.println("4. Cadastro Cliente.");
				MenuCadastro.cadMenu(lista);
				break;
			case 5:
				System.out.println("5. Login");
			case 9:
				Utils.clearConsole();
				System.out.println("Modo Teste...");
				//Utils.setup(lista);
				Utils.fim();
				break;
			case 0:
				System.out.println("Fim...");
				return;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				Utils.fim();
			}
		}
	}
}
