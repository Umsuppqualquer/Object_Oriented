package Interno.Menu;

import java.util.*;

import Geral.*;
import Interno.Class.Fornecedor;
import Interno.Class.Produto;

//ajustado

public class MenuProduto {

	public static void ProMenu(Shop list) {

		Utils.clearConsole();

		Scanner sc1 = new Scanner(System.in);

		while (true) {
			int esc;

			System.out.println("=======================================");
			System.out.println("           Menu de Produto              ");
			System.out.println("=======================================");
			System.out.println("Escolha uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Cadastro de produto");
			System.out.println("2. Mostrar todos os produtos");
			System.out.println("3. Excluir produto");
			System.out.println("4. Ajuste de cadastro de produto");
			System.out.println("5. Consulta por nome ou código");
			System.out.println("---------------------------------------");
			System.out.println("0. Retornar ao menu principal\n");
        	System.out.print("Opção: ");
			esc = sc1.nextInt();

			switch (esc) {
			case 1: //corrigido
				System.out.println("\nVocê escolheu a Opção 1. Cadastro de produto.");
				cadProd(list);
				Utils.fim();
				break;
			case 2: //corrigido
				System.out.println("\nVocê escolheu a Opção 2. Mostrar os produtos.");
				escProd(list);
				Utils.fim();
				break;
			case 3: //corrigido
				System.out.println("\nVocê escolheu a Opção 3. Excluir produto.");
				list.prodSimp();
				System.out.println("Digite o número do produto que deseja excluir:");
				int i = sc1.nextInt();
				Produto aux = list.prodAt(i);
				list.excProd(aux);
				Utils.fim();
				break;
			case 4: //corrigido
				System.out.println("\nVocê escolheu a Opção 4. Ajuste de cadastro de produto.");
				list.prodSimp();
				System.out.println("Digite o número do produto que deseja ajustar:");
				int j = sc1.nextInt();
				AjustProd(list.prodAt(j),list);
				Utils.fim();
				break;
			case 5:
				System.out.println("\nVocê escolheu a Opção 5. Consulta por nome ou código.");
				System.out.println("Digite o nome ou código do produto que deseja pesquisar:");
				sc1.nextLine();
				String key = sc1.nextLine();
				searchProd(list, key);
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

	public static void cadProd(Shop list) { //revisado

		Scanner sc2 = new Scanner(System.in);
		Fornecedor aux = new Fornecedor();
		Produto p = new Produto();

		System.out.println("\nDigite o nome do produto:");
		p.setNome(sc2.nextLine());
		System.out.println("\nDigite a descrição do produto:");
		p.setDescproduto(sc2.nextLine());
		System.out.println("\nSelecione o fornecedor:");
		list.fornSimp();;
		aux = list.forneAt(sc2.nextInt());
		p.setFornecedor(aux);
		aux.addItem(p);

		list.addProd(p);

		return;
	}

	public static void escProd(Shop list) { //revisado
		System.out.println("\n----------------------------------------");
		for (int i = 0; i < list.sizeProd(); i++) {
			System.out.println("Nome do produto: " + list.prodAt(i).getNome() + "\n-Desc:" + list.prodAt(i).getDescproduto()
					+ "\n-Id: " + list.prodAt(i).getId());
			Fornecedor aux = list.prodAt(i).getFornecedor();
			System.out.println("-Fornecedor: " + aux.getNome());
			System.out.println("\n----------------------------------------");
		}
		System.out.println("");
	}

	public static void orgList(ArrayList<Produto> p1) {
		Collections.sort(p1, new Comparator<Produto>() {
			@Override
			public int compare(Produto produto1, Produto produto2) {
				return produto1.getNome().compareTo(produto2.getNome());
			}
		});
	}

	public static void AjustProd(Produto p1, Shop list) {
		Scanner sc = new Scanner(System.in);

		if (p1 != null) {
			System.out.println("\nMenu de Ajuste para Produto: " + p1.getNome());
			System.out.println("Digite o novo nome do produto (ou ENTER para manter o mesmo):");
			String novoNome = sc.nextLine();
			if (!novoNome.isEmpty()) {
				p1.setNome(novoNome);
			}

			System.out.println("Digite a nova descrição do produto (ou ENTER para manter a mesma):");
			String novaDescricao = sc.nextLine();
			if (!novaDescricao.isEmpty()) {
				p1.setDescproduto(novaDescricao);
			}

			System.out.println("Selecione o novo fornecedor (ou ENTER para manter o mesmo):");
			list.fornSimp();
			String newsup = sc.nextLine();
			int conv = Integer.valueOf(newsup);
			if (!newsup.isEmpty()) {
				Fornecedor sup = p1.getFornecedor();
				sup.excItem(p1);
				sup = list.forneAt(conv);
				sup.addItem(p1);
				p1.setFornecedor(sup);
			}

			System.out.println("Produto ajustado com sucesso:");
		} else {
			System.out.println("Opção de produto inválida.");
		}
	}

	public static void searchProd(Shop list, String key) {
		ArrayList<Produto> resultados = new ArrayList<>();

		Produto sup = new Produto();
		sup.setNome(key);

		for (int i = 0; i < list.sizeProd(); i++) {
			if (list.prodAt(i).equals(sup) && list.forneAt(i) != null) {
				resultados.add(list.prodAt(i));
			}
		}

		if (resultados.isEmpty()) {
			System.out.println("Nenhum produto encontrado com a palavra '" + key + "'.");
		} else {
			Fornecedor aux = new Fornecedor();
			System.out.println("----------------------------------------");
			System.out.println("Resultados da pesquisa: \n");
			for (Produto produto : resultados) {
				System.out.println("Nome do produto: " + produto.getNome() + "\n-Desc: " + produto.getDescproduto() + "\n-Id: " + produto.getId());
				aux = produto.getFornecedor();
				System.out.println("Fornecedor: " + aux.getNome());
			}
			System.out.println("----------------------------------------");
		}
	}
}
