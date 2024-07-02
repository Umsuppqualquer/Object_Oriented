package Geral;

import java.util.Scanner;

import Externo.Class.Cliente;
import Interno.Class.*;

public class Utils {
	private static final Scanner scanner = new Scanner(System.in);

	public static void pressEnter() {
		System.out.println("Pressione Enter para continuar...");
		scanner.nextLine(); // Espera o usuário pressionar Enter
	}

	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void fim() {
		pressEnter();
		clearConsole();
	}

	public static void setup(Shop list) {
		Endereco endereco1 = new Endereco("Rua da Paz", "456", "Bloco B, Ap. 301", "Jardim Botânico",
				"54321-123", "São Paulo", "SP");
		Fornecedor f4 = new Fornecedor();
				f4.setNome("Tech Solutions Ltda.");
				f4.setDescricao("Empresa especializada em soluções de TI");
				f4.setTelefone("11 98765-4321");
				f4.setEmail("contato@techsolutions.com");
				f4.setLocal(endereco1);
		list.addForne(f4);

		Endereco endereco2 = new Endereco("Rua das Flores", "123", "Sala 101", "Centro", "12345-678",
				"Cidade A", "Estado X");
		Fornecedor f5 = new Fornecedor();
				f5.setNome("Magazine Luiza.");
				f5.setDescricao("Descrição do fornecedor");
				f5.setTelefone("(12) 3456-1789");
				f5.setEmail("fornecedor@empresa.com");
				f5.setLocal(endereco2);
		list.addForne(f5);

		Estoque e1 = new Estoque(200, 2.50);

		Estoque e2 = new Estoque(10, 4.00);

		Produto prod1 = new Produto("Melancia", "Melancia quadrada", f4, e1);
		list.addProd(prod1);

		Produto prod2 = new Produto("Suporte Tv", "51 polegadas", f5, e2);
		list.addProd(prod2);


		Cliente c1 = new Cliente("Caetano Veloso", "(04) 4002-8922","email@ucs.br" , 
					endereco2, "cveloso", "4321", "9876 5432 1234 5678");

		Cliente c2 = new Cliente("Luiz P. Kakuichi", "(54) 99123-5166","lpkakuichi@ucs.br" , 
					endereco1, "lpkaku", "1234", "1234 5678 9876 5432");

		list.addUser(c1);

		list.addUser(c2);

		escArq(list);
		
	}

	public static void lerARQ(Shop list) {
		list.carregarDados();	
	}

	public static void escArq(Shop list){
		list.salvarDados();
	}
}
