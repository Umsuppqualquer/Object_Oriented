package Externo.Menu;

import java.util.*;

import Externo.Class.*;
import Geral.*;
import Interno.Class.*;

public class MenuCadastro {

	public static void cadMenu(Shop list, Scanner sc) {
		int esc = 1;

		while (true) {
			Utils.clearConsole();
			System.out.println("=======================================");
			System.out.println("           Menu de Cadastro            ");
			System.out.println("=======================================");
			System.out.println("Selecione uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Cadastrar Usuário");
			System.out.println("2. Usuários Cadastrados");
			System.out.println("3. Esqueci minha senha");
			System.out.println("4. Excluir conta");
			System.out.println("---------------------------------------");
			System.out.println("0. Retornar ao menu principal\n");
			System.out.print("Opção: ");
			esc = sc.nextInt();
			switch (esc) {
			case 1:
				System.out.println("1. Cadastrar Usuário.");
				cadUser(list,sc);
				Utils.fim();
				break;
			case 2:
				System.out.println("2. Usuários Cadastro.");
				escUser(list);
				Utils.fim();
				break;
			case 3:
				System.out.println("3. Esqueci Minha Senha.");
				recUser(list,sc);
				Utils.fim();
				break;
			case 4:
				System.out.println("4. Excluir Usuário.");
				excUser(list,sc);
				Utils.fim();
				break;
			case 0:
				System.out.println("\nRetornando ao menu principal...");
				return;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				Utils.fim();
			}
		}
	
	}

	public static void cadUser(Shop list, Scanner sc){ //ok
		Endereco aux = new Endereco();
		Cliente c = new Cliente();

		System.out.println("\nDigite o seu nome:");
		c.setNome(sc.nextLine());
		System.out.println("\nDigite o nome do seu Usuário:");
		c.setLogin(sc.nextLine());
		System.out.println("\nAgora uma senha:");
		c.setSenha(sc.nextLine());
		System.out.println("\nDigite o email do fornecedor:");
		c.setEmail(sc.nextLine());
		System.out.println("Telefone para contato: ");
		c.setTelefone(sc.nextLine());
		System.out.println("\nEndereço para a entrega rua:");
		aux.setRua(sc.nextLine());
		System.out.println("\nNúmero da residência:");
		aux.setNumero(sc.nextLine());
		System.out.println("\nComplemento:");
		aux.setComplmento(sc.nextLine());
		System.out.println("\nBairro:");
		aux.setBairro(sc.nextLine());
		System.out.println("\nCódigo CEP:");
		aux.setCep(sc.nextLine());
		System.out.println("\nCidade:");
		aux.setCidade(sc.nextLine());
		System.out.println("\nEstado:");
		aux.setEstado(sc.nextLine());

		c.setLocal(aux);

		list.addUser(c);

		return;
	}

	public static void escUser(Shop list) {
		System.out.println("\n========================================\n");
		System.out.println("         Lista de Usuários              ");
		System.out.println("\n========================================\n");
	
		for (int i = 0; i < list.sizeUser(); i++) {
			System.out.println("Nome: " + list.userAt(i).getNome());
			System.out.println("Login: " + list.userAt(i).getLogin());
			System.out.println("Email: " + list.userAt(i).getEmail());
			System.out.println("\n----------------------------------------\n");
		}
	}

	public static void recUser(Shop list, Scanner sc){ //ok
		System.out.println("Digite o usuário ou o email: ");
		String aux = sc.nextLine();
		Teste t1 = new Teste();
		t1 = list.recSenha(aux);
		if(t1.getTest()){
			System.out.println("Nome/Email: " + aux);
			System.out.println("Digite sua nova senha: ");
			list.userAt(t1.getIndex()).setSenha(sc.nextLine());
			System.out.println("Senha atualizada!!!");
		}
		else{
			System.out.println("Usuário não encontrado ou não cadastrado.");
		}
	}

	public static void excUser(Shop list, Scanner sc){
		System.out.println("Digite o usuário ou o email: ");
		String aux = sc.nextLine();
		Teste t1 = new Teste();
		t1 = list.recSenha(aux);
		if(t1.getTest()){
			System.out.println("Usuário: " + list.userAt(t1.getIndex()).getLogin() + "Nome: " + list.userAt(t1.getIndex()).getLogin());
			System.out.println("Deseja excluir sua conta? (Todas os seus pontos serão perdidos)");
			System.out.println("1 - Sim / 2 - Não ");
			int esc = sc.nextInt();
			while (true) {
				switch (esc) {
					case 1:
						System.out.println("Foi excluido o usuário.");
						list.excUser(list.userAt(t1.getIndex()));
						return;
					case 2:
						System.out.println("Operação cancelada...");
						return;
					default:
						System.out.println("Opção inválida tente.");
						break;
				}
				
			}

		}
		else{
			System.out.println("Usuário não encontrado ou não cadastrado.");
		}


	}


}