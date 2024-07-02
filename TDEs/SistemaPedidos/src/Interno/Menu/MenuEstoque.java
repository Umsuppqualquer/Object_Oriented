package Interno.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Geral.*;
import Interno.Class.Estoque;
import Interno.Class.Fornecedor;
import Interno.Class.Produto;

//ajustado

public class MenuEstoque {

	public static void EstqMenu(Shop list, Scanner sc) {

		Utils.clearConsole();

		while (true) {
			int esc;

			System.out.println("=======================================");
			System.out.println("           Menu de Estoque              ");
			System.out.println("=======================================");
			System.out.println("Escolha uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Entrada de novo lote no estoque");
			System.out.println("2. Mostrar os estoques de produto");
			System.out.println("3. Excluir estoque");
			System.out.println("4. Ajuste de estoque");
			System.out.println("5. Troca de fornecedor");
			System.out.println("---------------------------------------");
			System.out.println("0. Retornar ao menu principal\n");
			System.out.print("Opção: ");
			esc = sc.nextInt();

			switch (esc) {
				case 1:
					System.out.println("\nVocê escolheu a Opção 1. Entrada de novo lote no estoque.");
					cadEstq(list, sc);
					Utils.escArq(list);
					Utils.fim();
					break;
				case 2:
					System.out.println("\nVocê escolheu a Opção 2. Mostrar os produtos com estoque.");
					escEstq(list);
					Utils.fim();
					break;
				case 3:
					System.out.println("\nVocê escolheu a Opção 3. Excluir estoque.");
					list.prodSimp();
					System.out.println("Digite o número do produto que deseja excluir:");
					int i = sc.nextInt();
					if (list.prodAt(i).getEstoque() != null) {
						System.out.println("Foi excluído o estoque do item " + list.prodAt(i).getNome());
						list.excProd(list.prodAt(i));
					} else {
						System.out.println("Este produto não possui estoque cadastrado.");
					}
					Utils.escArq(list);
					Utils.fim();
					break;
				case 4:
					System.out.println("\nVocê escolheu a Opção 4. Ajuste de estoque.");
					ajustEstq(list, sc);
					Utils.escArq(list);
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

	public static void cadEstq(Shop list, Scanner sc) { //corrigido
		Estoque aux = new Estoque();

		System.out.println("\nSelecione o produto no qual deseja dar entrada:");
		list.prodSimp();
		int i = sc.nextInt();

		System.out.println("Digite a quantidade:");
		int j = sc.nextInt();
		aux.setQuantidade(j);

		System.out.println("Digite o valor:");
		double val = sc.nextDouble();
		aux.setPreco(val);

		list.prodAt(i).setQuantidade(aux);

		System.out.println("Foi dada entrada no estoque do item " +list.prodAt(i).getNome());
	}

	public static void escEstq(Shop list) {
		Estoque aux;
		Fornecedor f1;
		for (int i = 0; i < list.sizeProd(); i++) {
			System.out.println("\n----------------------------------------");
			System.out.println("Nome do produto: " + list.prodAt(i).getNome());
			System.out.println("Descrição: " + list.prodAt(i).getDescproduto());
			aux = list.prodAt(i).getEstoque();
			f1 = list.prodAt(i).getFornecedor();
			if (aux != null) {
				System.out.println("Fornecedor: " + f1.getNome());
				System.out.println("Quantidade em estoque: " + aux.getQuantidade());
				System.out.println("Preço unitário: R$" + aux.getPreco());
			} else {
				System.out.println("Este produto não possui registro de entrada no estoque.");
			}
			
		}
	}

	public static void excEstq(ArrayList<Produto> p1, int index, Scanner sc) {
		System.out.println("\nConfirmar exclusão de estoque: " + p1.get(index).getNome());
		System.out.println("1 - Sim\n" + "2 - Não");
		int op = sc.nextInt();
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

	public static void ajustEstq(Shop list, Scanner sc) {
		while (true) {
			System.out.println("\nSelecione o produto que deseja alterar o estoque (ou digite 0 para sair):");
			for (int i = 0; i < list.sizeProd(); i++) {
				if (list.prodAt(i).getEstoque() != null) {
					System.out.println((i) + ". " + list.forneAt(i).getNome() + " - " + list.forneAt(i).getDescricao());
				}
			}
			int escolha = sc.nextInt();
			if (escolha == 0) {
				break;
			} else if (escolha > 0 && escolha <= list.sizeProd()) {
				Estoque estqaux = list.prodAt(escolha).getEstoque();
				System.out.println("Produto selecionado: " + list.prodAt(escolha).getNome());
				System.out.println("Quantidade atual: " + estqaux.getQuantidade() + " / Preço: R$"
						+ estqaux.getPreco());
				System.out.println("Digite a nova quantidade:");
				int novaQuantidade = sc.nextInt();
				estqaux.setQuantidade(novaQuantidade);
				System.out.println("Quantidade alterada com sucesso para: " + estqaux.getQuantidade());
				System.out.println("Digite o novo valor:");
				double novoPreco = sc.nextDouble();
				estqaux.setPreco(novoPreco);
				System.out.println("Preço alterado com sucesso para: R$" + estqaux.getPreco()); 

			} else {
				System.out.println("Opção inválida. Por favor, escolha novamente.");
			}
		}
	}
}
