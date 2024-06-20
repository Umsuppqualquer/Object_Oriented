package Interno.Menu;

import java.util.*;

import Geral.*;
import Interno.Class.Endereco;
import Interno.Class.Fornecedor;

//ajustado

public class MenuFornecedor {

	public static void SupMenu(Shop list, Scanner sc) {

		Utils.clearConsole();

		while (true) {
			int esc;

			System.out.println("=======================================");
			System.out.println("           Menu de Fornecedor           ");
			System.out.println("=======================================");
			System.out.println("Escolha uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Cadastro de fornecedor");
			System.out.println("2. Mostrar todos os fornecedores");
			System.out.println("3. Excluir fornecedor");
			System.out.println("4. Ajuste de cadastro de fornecedor");
			System.out.println("5. Consulta por nome ou código");
			System.out.println("---------------------------------------");
			System.out.println("0. Retornar ao menu principal\n");
			System.out.print("Opção: ");

			esc = sc.nextInt();

			switch (esc) {
			case 1:
				System.out.println("Você escolheu a Opção 1. Cadastro de fornecedor.");
				cadForn(list,sc);
				Utils.fim();
				break;
			case 2:
				System.out.println("Você escolheu a Opção 2. Mostrar os fornecedores.");
				escForn(list);
				Utils.fim();
				break;
			case 3:
				System.out.println("Você escolheu a Opção 3. Excluir fornecedor.");
				list.fornSimp();
				System.out.println("Digite o número do fornecedor que deseja excluir:");
				int i = sc.nextInt();
				Fornecedor aux = list.forneAt(i);
				list.excForne(aux);
				Utils.fim();
				break;
			case 4:
				System.out.println("Você escolheu a Opção 4. Ajuste de cadastro de fornecedor.");
				list.fornSimp();
				System.out.println("Digite o número do fornecedor que deseja ajustar:");
				int j = sc.nextInt();
				AjustForn(list.forneAt(j),sc);
				Utils.fim();
				break;
			case 5:
				System.out.println("Você escolheu a Opção 5. Consulta por nome ou código.");
				System.out.println("Digite o nome ou código do fornecedor que deseja pesquisar:");
				sc.nextLine();
				String key = sc.nextLine();
				searchForn(list, key);
				Utils.fim();
				break;
			case 0:
				System.out.println("\nRetornando ao menu principal...");
				return;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				Utils.clearConsole();
			}
		}
	}

	public static void cadForn(Shop list, Scanner sc) { //revisado
		Endereco aux = new Endereco();
		Fornecedor f = new Fornecedor();

		System.out.println("\nDigite o nome do fornecedor:");
		f.setNome(sc.nextLine());
		System.out.println("\nDigite a descrição do fornecedor:");
		f.setDescricao(sc.nextLine());
		System.out.println("\nDigite o telefone do fornecedor:");
		f.setTelefone(sc.nextLine());
		System.out.println("\nDigite o email do fornecedor:");
		f.setEmail(sc.nextLine());
		System.out.println("\nDigite a rua onde se localiza:");
		aux.setRua(sc.nextLine());
		System.out.println("\nDigite o número de endereço:");
		aux.setNumero(sc.nextLine());
		System.out.println("\nComplemento do endereço:");
		aux.setComplmento(sc.nextLine());
		System.out.println("\nBairro onde se localiza:");
		aux.setBairro(sc.nextLine());
		System.out.println("\nCódigo CEP:");
		aux.setCep(sc.nextLine());
		System.out.println("\nCidade onde reside:");
		aux.setCidade(sc.nextLine());
		System.out.println("\nEstado onde reside:");
		aux.setEstado(sc.nextLine());

		f.setLocal(aux);

		list.addForne(f);

		return;
	}

	public static void escForn(Shop list) { //revisado
		System.out.println("\n----------------------------------------\n");
		for (int i = 0; i < list.sizeForne(); i++) {
			System.out.println("Nome da empresa: " + list.forneAt(i).getNome() + "\nDescrição: " + list.forneAt(i).getDescricao()
					+ "\nTelefone: " + list.forneAt(i).getTelefone() + "\nEmail: " + list.forneAt(i).getEmail());
			System.out.println("Rua: " + list.forneAt(i).getLocal().getRua() + "\nNúmero: " + list.forneAt(i).getLocal().getNumero() + "\nComplemento: "
					+ list.forneAt(i).getLocal().getComplmento() + "\nBairro: " + list.forneAt(i).getLocal().getBairro() + "\nCEP: " + list.forneAt(i).getLocal().getCep() + "\nCidade: "
					+ list.forneAt(i).getLocal().getCidade() + "\nEstado: " + list.forneAt(i).getLocal().getEstado());
			System.out.println("Produtos: ");
			for(int j = 0; j < list.forneAt(i).sizeProd(); j++){
				System.out.println(j + ". " + list.forneAt(i).prodAt(j).getNome());
			}
			System.out.println("\n----------------------------------------\n");
		}
	}

	public static void orgList(List<Fornecedor> f2) {
		Collections.sort(f2, new Comparator<Fornecedor>() {
			@Override
			public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2) {
				return fornecedor1.getNome().compareTo(fornecedor2.getNome());
			}
		});
	}

	public static void AjustForn(Fornecedor p1, Scanner sc) { //revisado

		if (p1 != null) {
			System.out.println("\nMenu de Ajuste para Fornecedor: " + p1.getNome());
			System.out.println("Digite o novo nome do fornecedor (ou ENTER para manter o mesmo):");
			String aux = sc.nextLine();
			if (!aux.isEmpty()) {
				p1.setNome(aux);
			}

			System.out.println("Digite a nova descrição do fornecedor (ou ENTER para manter a mesma):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				p1.setDescricao(aux);
			}

			System.out.println("Digite o novo telefone do fornecedor (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				p1.setTelefone(aux);
			}

			System.out.println("Digite o novo email do fornecedor (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				p1.setEmail(aux);
			}

			Endereco enderecoAtual = p1.getLocal();
			System.out.println("Digite os novos dados do endereço:");

			System.out.println("Rua (ou ENTER para manter a mesma):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setRua(aux);
			}

			System.out.println("Número (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setNumero(aux);
			}

			System.out.println("Complemento (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setComplmento(aux);
			}

			System.out.println("Bairro (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setBairro(aux);
			}

			System.out.println("CEP (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setCep(aux);
			}

			System.out.println("Cidade (ou ENTER para manter a mesma):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setCidade(aux);
			}

			System.out.println("Estado (ou ENTER para manter o mesmo):");
			aux = sc.nextLine();
			if (!aux.isEmpty()) {
				enderecoAtual.setEstado(aux);
			}

			System.out.println("Fornecedor ajustado com sucesso:");
		} else {
			System.out.println("Opção de fornecedor inválida.");
		}
	}

	public static void searchForn(Shop list, String key) {
		List<Fornecedor> resultados = new ArrayList<>();

		Fornecedor sup = new Fornecedor();
		sup.setNome(key);

		for (int i = 0; i < list.sizeForne(); i++) {
			if (list.forneAt(i).equals(sup) && list.forneAt(i) != null){
				resultados.add(list.forneAt(i));
			}
		}

		if (resultados.isEmpty()) {
			System.out.println("Nenhum fornecedor encontrado com a palavra '" + key + "'.");
		} else {
			Endereco aux = new Endereco();
			System.out.println("Resultados da pesquisa:");
			for (Fornecedor fornecedor : resultados) {
				System.out.println("\n----------------------------------------\n");
				System.out.println("Nome da empresa: " + fornecedor.getNome() + "\nDescrição: " + fornecedor.getDescricao()+ 
					"\nTelefone: " + fornecedor.getTelefone() + "\nEmail: " + fornecedor.getEmail());
				aux = fornecedor.getLocal();
				System.out.println("Rua: " + aux.getRua() + "\nNúmero: " + aux.getNumero() + "\nComplemento: "+ aux.getComplmento()
					 + "\nBairro: " + aux.getBairro() + "\nCEP: " + aux.getCep() + "\nCidade: "+ aux.getCidade() + "\nEstado: "
					 + aux.getEstado());
				System.out.println("\n");
			}
		}
	}
}
