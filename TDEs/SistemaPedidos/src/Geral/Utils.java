package Geral;


import java.util.*;
import java.util.Scanner;

import T1.Class.Endereco;
import T1.Class.Fornecedor;
import T1.Class.Produto;

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

	public static void setup(ArrayList<Fornecedor> f2, ArrayList<Produto> p1) {
		Endereco enderecoCliente1 = new Endereco("Rua da Paz", "456", "Bloco B, Ap. 301", "Jardim Botânico",
				"54321-123", "São Paulo", "SP");
		Fornecedor f4 = new Fornecedor();
				f4.setNome("Tech Solutions Ltda.");
				f4.setDescricao("Empresa especializada em soluções de TI");
				f4.setTelefone("11 98765-4321");
				f4.setEmail("contato@techsolutions.com");
				f4.setLocal(enderecoCliente1);
		f2.add(f4);

		Endereco enderecoFornecedor = new Endereco("Rua das Flores", "123", "Sala 101", "Centro", "12345-678",
				"Cidade A", "Estado X");
		Fornecedor f5 = new Fornecedor();
				f5.setNome("Magazine Luiza.");
				f5.setDescricao("Descrição do fornecedor");
				f5.setTelefone("(12) 3456-1789");
				f5.setEmail("fornecedor@empresa.com");
				f5.setLocal(enderecoFornecedor);
		f2.add(f5);

		Produto prod1 = new Produto("Melancia", "Melancia quadrada", f4);
		p1.add(prod1);

		Produto prod2 = new Produto("Suporte Tv", "51 polegadas", f5);
		p1.add(prod2);

	}

}
