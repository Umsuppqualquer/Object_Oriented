package T1;

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
		Fornecedor f4 = new Fornecedor("Tech Solutions Ltda.", "Empresa especializada em soluções de TI",
				"11 98765-4321", "contato@techsolutions.com", enderecoCliente1);
		f2.add(f4);

		Endereco enderecoFornecedor = new Endereco("Rua das Flores", "123", "Sala 101", "Centro", "12345-678",
				"Cidade A", "Estado X");
		Fornecedor f5 = new Fornecedor("Magazine Luiza", "Descrição do fornecedor", "123456789",
				"fornecedor@empresa.com", enderecoFornecedor);
		f2.add(f5);

		Endereco enderecoCliente = new Endereco("Avenida Principal", "456", "Apartamento 202", "Bairro B", "54321-987",
				"Cidade B", "Estado Y");
		Fornecedor f6 = new Fornecedor("Pao Quente", "Outra descrição do fornecedor", "987654321", "outro@empresa.com",
				enderecoCliente);
		f2.add(f6);

		Endereco enderecoFilial = new Endereco("Rua do Comércio", "789", "Sala 303", "Centro", "98765-432", "Cidade C",
				"Estado Z");
		Fornecedor f7 = new Fornecedor("Kabum", "Mais uma descrição do fornecedor", "654321987", "maisum@empresa.com",
				enderecoFilial);
		f2.add(f7);

		Produto prod1 = new Produto("Melancia", "Melancia quadrada", f4);
		p1.add(prod1);

		Produto prod2 = new Produto("Suporte Tv", "51 polegadas", f5);
		p1.add(prod2);

		Produto prod3 = new Produto("Parafausadeira", "T500", f6);
		p1.add(prod3);

		Produto prod4 = new Produto("Camera", "Tekpix", f7);
		p1.add(prod4);
	}

}
