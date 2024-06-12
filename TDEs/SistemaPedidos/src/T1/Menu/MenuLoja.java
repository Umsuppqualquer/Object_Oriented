package T1.Menu;

import java.util.*;

import T1.Shop;
import T1.Utils;

public class MenuLoja {
	public static void main(String[] args) {
		Shop c1 = new Shop();
		int esc = 1;
		Scanner sc1 = new Scanner(System.in);

		while (true) {
			Utils.clearConsole();
			System.out.println("Selecione uma opção:");
			System.out.println("1. Fornecedor.");
			System.out.println("2. Produto.");
			System.out.println("3. Estoque.");
			System.out.println("9. Modo teste.");
			System.out.println("0. Sair\n");
			esc = sc1.nextInt();
			switch (esc) {
			case 1:
				System.out.println("1. Fornecedor");
				MenuFornecedor.SupMenu(c1.getListForne());
				break;
			case 2:
				System.out.println("2. Produto");
				MenuProduto.ProMenu(c1.getListForne(), c1.getListProd());
				break;
			case 3:
				System.out.println("3. Estoque");
				MenuEstoque.EstqMenu(c1.getListProd(),c1.getListForne());
				break;
			case 9:
				Utils.clearConsole();
				System.out.println("Modo Teste...");
				Utils.setup(c1.getListForne(), c1.getListProd());
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
