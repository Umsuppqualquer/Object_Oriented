package T1.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Geral.*;
import T1.Class.Estoque;
import T1.Class.Fornecedor;
import T1.Class.Produto;

//ajustado

public class MenuEstoque {

	public static void EstqMenu(Shop list) {

		Utils.clearConsole();

		Scanner sc2 = new Scanner(System.in);

		while (true) {
			int esc;

			System.out.println("Escolha uma opção:");
			System.out.println("1. Entrada de novo lote no estoque.");
			System.out.println("2. Mostrar os estoques de produto.");
			System.out.println("3. Excluir estoque.");
			System.out.println("4. Ajuste de estoque.");
			System.out.println("5. Troca de fornecedor.");
			System.out.println("0. Retornar ao menu principal.");
			esc = sc2.nextInt();

			switch (esc) {
			case 1:
				System.out.println("\nVocê escolheu a Opção 1. Entrada de novo lote no estoque.");
				cadEstq(p1);
				Utils.fim();
				break;
			case 2:
				System.out.println("\nVocê escolheu a Opção 2. Mostrar os produtos com estoque.");
				escEstq(p1);
				Utils.fim();
				break;
			case 3:
				System.out.println("\nVocê escolheu a Opção 3. Excluir estoque.");
				MenuProduto.SimpEsc(p1);
				System.out.println("Digite o número do produto que deseja exluir:");
				int i = sc2.nextInt();
				if (p1.get(i).getQuantidade() != null) {
					excEstq(p1, i);
					System.out.println("Foi excluído o estoque do item " + p1.get(i).getNome());
				} else {
					System.out.println("Este produto não possui estoque cadastrado.");
				}
				Utils.fim();
				break;
			case 4:
				System.out.println("\nVocê escolheu a Opção 4. Ajuste de estoque.");
				ajustEstq(p1);
				Utils.fim();
				break;
			case 0:
				System.out.println("\nRetornando ao menu principal...");
				return;
			default:
				System.out.println("\nOpção inválida. Escolha novamente.");
				Utils.fim();
				break;
			}
		}
	}

	public static void cadEstq(ArrayList<Produto> p1) {
		Estoque aux = new Estoque();
		Scanner sc2 = new Scanner(System.in);

		System.out.println("\nSelecione o produto no qual deseja dar entrada:");
		MenuProduto.SimpEsc(p1);
		int i = sc2.nextInt();

		System.out.println("Digite a quantidade:");
		int j = sc2.nextInt();
		aux.setQuantidade(j);

		System.out.println("Digite o valor:");
		double val = sc2.nextDouble();
		aux.setPreco(val);

		p1.get(i).setQuantidade(aux);

		System.out.println("Foi dada entrada no estoque do item " + p1.get(i).getNome());
	}

	public static void escEstq(ArrayList<Produto> p1) {
		Estoque aux;
		Fornecedor f1;
		for (int i = 0; i < p1.size(); i++) {
			System.out.println("\n----------------------------------------");
			System.out.println("Nome do produto: " + p1.get(i).getNome());
			System.out.println("Descrição: " + p1.get(i).getDescproduto());
			aux = p1.get(i).getQuantidade();
			f1 = p1.get(i).getFornecedor();
			if (aux != null) {
				System.out.println("Fornecedor: " + f1.getNome());
				System.out.println("Quantidade em estoque: " + aux.getQuantidade());
				System.out.println("Preço unitário: R$" + aux.getPreco());
			} else {
				System.out.println("Este produto não possui registro de entrada no estoque.");
			}
			
		}
	}

	public static void excEstq(ArrayList<Produto> p1, int index) {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\nConfirmar exclusão de estoque: " + p1.get(index).getNome());
		System.out.println("1 - Sim\n" + "2 - Não");
		int op = sc2.nextInt();
		while (true) {
			switch (op) {
			case 1:
				p1.remove(index);
				System.out.println("\nFoi realizada a remoção do cadastro.");
				return;
			case 2:
				System.out.println("Operação de remoção cancelada.");
				return;
			default:
				System.out.println("Opção inválida, tente novamente.");
				break;
			}
		}
	}

	public static void ajustEstq(ArrayList<Produto> p1) {
		Scanner sc2 = new Scanner(System.in);
		while (true) {
			System.out.println("\nSelecione o produto que deseja alterar o estoque (ou digite 0 para sair):");
			for (int i = 0; i < p1.size(); i++) {
				Produto produto = p1.get(i);
				Estoque estoque = produto.getQuantidade();
				if (estoque != null) {
					System.out.println((i + 1) + ". " + produto.getNome() + " - " + produto.getDescproduto());
				}
			}
			int escolha = sc2.nextInt();
			if (escolha == 0) {
				break;
			} else if (escolha > 0 && escolha <= p1.size()) {
				Produto prodaux = p1.get(escolha - 1);
				Estoque estqaux = prodaux.getQuantidade();
				System.out.println("Produto selecionado: " + prodaux.getNome());
				System.out.println("Quantidade atual: " + estqaux.getQuantidade() + " / Preço: R$"
						+ estqaux.getPreco());
				System.out.println("Digite a nova quantidade:");
				int novaQuantidade = sc2.nextInt();
				estqaux.setQuantidade(novaQuantidade);
				System.out.println("Quantidade alterada com sucesso para: " + estqaux.getQuantidade());
				System.out.println("Digite o novo valor:");
				double novoPreco = sc2.nextDouble();
				estqaux.setPreco(novoPreco);
				System.out.println("Preço alterado com sucesso para: R$" + estqaux.getPreco()); 

			} else {
				System.out.println("Opção inválida. Por favor, escolha novamente.");
			}
		}
	}
}
