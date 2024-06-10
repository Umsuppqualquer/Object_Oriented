package T1;

import java.util.*;

//ajustado

public class MenuProduto {

	public static void ProMenu(ArrayList<Fornecedor> f2, ArrayList<Produto> p1) {

		Utils.clearConsole();

		Scanner sc1 = new Scanner(System.in);

		while (true) {
			int esc;

			System.out.println("Escolha uma opção:");
			System.out.println("1. Cadastro de produto.");
			System.out.println("2. Mostrar todos os produtos.");
			System.out.println("3. Excluir produto.");
			System.out.println("4. Ajuste de cadastro de produto.");
			System.out.println("5. Consulta por nome ou código.");
			System.out.println("0. Retornar ao menu principal.\n");
			esc = sc1.nextInt();

			switch (esc) {
			case 1:
				System.out.println("\nVocê escolheu a Opção 1. Cadastro de produto.");
				cadProd(p1, f2);
				Utils.fim();
				break;
			case 2:
				System.out.println("\nVocê escolheu a Opção 2. Mostrar os produtos.");
				escProd(p1);
				Utils.fim();
				break;
			case 3:
				System.out.println("\nVocê escolheu a Opção 3. Excluir produto.");
				SimpEsc(p1);
				System.out.println("Digite o número do produto que deseja excluir:");
				int i = sc1.nextInt();
				excProd(p1, i);
				Utils.fim();
				break;
			case 4:
				System.out.println("\nVocê escolheu a Opção 4. Ajuste de cadastro de produto.");
				SimpEsc(p1);
				System.out.println("Digite o número do produto que deseja ajustar:");
				int j = sc1.nextInt();
				AjustProd(p1, f2, j);
				Utils.fim();
				break;
			case 5:
				System.out.println("\nVocê escolheu a Opção 5. Consulta por nome ou código.");
				System.out.println("Digite o nome ou código do produto que deseja pesquisar:");
				sc1.nextLine();
				String chavePesquisa = sc1.nextLine();
				searchForn(p1, chavePesquisa);
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

	public static void cadProd(ArrayList<Produto> p1, ArrayList<Fornecedor> f2) {

		Scanner sc2 = new Scanner(System.in);
		Fornecedor aux = new Fornecedor();
		Produto p = new Produto();

		System.out.println("\nDigite o nome do produto:");
		p.setNome(sc2.nextLine());
		System.out.println("\nDigite a descrição do produto:");
		p.setDescproduto(sc2.nextLine());
		System.out.println("\nSelecione o fornecedor:");
		MenuFornecedor.SimpEsc(f2);
		aux = f2.get(sc2.nextInt());
		p.setSuplyer(aux);

		p1.add(p);

		orgList(p1);

		return;
	}

	public static void escProd(ArrayList<Produto> p1) {
		System.out.println("\n----------------------------------------");
		for (int i = 0; i < p1.size(); i++) {
			System.out.println("Nome do produto: " + p1.get(i).getNome() + "\n-Desc:" + p1.get(i).getDescproduto()
					+ "\n-Id: " + p1.get(i).getId());
			Fornecedor aux = p1.get(i).getSuplyer();
			System.out.println("-Fornecedor: " + aux.getNome());
			System.out.println("\n----------------------------------------");
		}
		System.out.println("");
	}

	public static void SimpEsc(ArrayList<Produto> p1) {
		char a = '\n';
		System.out.println("\n----------------------------------------");
		for (int i = 0; i < p1.size(); i++) {
			if (p1.get(i).getNome().charAt(0) == a) {
				System.out.println(i + "° - " + p1.get(i).getNome());
			} else {
				a = p1.get(i).getNome().charAt(0);
				System.out.println(a);
				System.out.println(i + "° - " + p1.get(i).getNome());
				System.out.println("\n----------------------------------------");
			}
		}
	}

	public static void excProd(ArrayList<Produto> p1, int index) {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\nConfirmar exclusão de cadastro: " + p1.get(index).getNome());
		System.out.println("1 - Sim\n2 - Não");
		int op = sc2.nextInt();
		while (true) {
			switch (op) {
			case 1:
				p1.remove(index);
							orgList(p1);
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

	public static void orgList(ArrayList<Produto> p1) {
		Collections.sort(p1, new Comparator<Produto>() {
			@Override
			public int compare(Produto produto1, Produto produto2) {
				return produto1.getNome().compareTo(produto2.getNome());
			}
		});
	}

	public static void AjustProd(ArrayList<Produto> p1, ArrayList<Fornecedor> f1, int index) {
		Scanner sc = new Scanner(System.in);

		if (index >= 0 && index < p1.size()) {
			Produto aux = p1.get(index);

			System.out.println("\nMenu de Ajuste para Produto: " + aux.getNome());
			System.out.println("Digite o novo nome do produto (ou ENTER para manter o mesmo):");
			String novoNome = sc.nextLine();
			if (!novoNome.isEmpty()) {
				aux.setNome(novoNome);
			}

			System.out.println("Digite a nova descrição do produto (ou ENTER para manter a mesma):");
			String novaDescricao = sc.nextLine();
			if (!novaDescricao.isEmpty()) {
				aux.setDescproduto(novaDescricao);
			}

			System.out.println("Selecione o novo fornecedor (ou ENTER para manter o mesmo):");
			MenuFornecedor.SimpEsc(f1);
			String newsup = sc.nextLine();
			int conv = Integer.valueOf(newsup);
			if (!newsup.isEmpty()) {
				aux.setSuplyer(f1.get(conv));
			}

			System.out.println("Produto ajustado com sucesso:");
		} else {
			System.out.println("Opção de produto inválida.");
		}
	}

	public static void searchForn(ArrayList<Produto> p1, String key) {// ok
		Utils.clearConsole();

		ArrayList<Produto> resultados = new ArrayList<>();

		for (Produto produto : p1) {
			if (produto.getNome().toLowerCase().contains(key.toLowerCase())) {
				resultados.add(produto);
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
				aux = produto.getSuplyer();
				System.out.println("Fornecedor: " + aux.getNome());
			}
			System.out.println("----------------------------------------");
		}
	}
}
