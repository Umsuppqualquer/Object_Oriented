package Externo.Menu;

import java.util.*;

import Externo.Class.*;
import Geral.*;

public class MenuPedidos {

	public static void cadMenu(Shop list, Scanner sc) {
		List<Pedido> control;
		control = list.openOrder();
		int esc = 1;

		while (true) {
			Utils.clearConsole();
			System.out.println("=======================================");
			System.out.println("           Menu de Pedidos             ");
			System.out.println("=======================================");
			System.out.println("Selecione uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Ver pedidos em aberto");
			System.out.println("2. Alterar status de pedidos");
			System.out.println("---------------------------------------");
			System.out.println("0. Retornar ao menu principal\n");
			System.out.print("Opção: ");
			esc = sc.nextInt();
			switch (esc) {
			case 1:
				System.out.println("1. Pedidos em aberto.");
				escOrder(control);
				Utils.fim();
				break;
			case 2:
				System.out.println("2. Usuários Cadastro.");
				
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

	public static void escOrder(List<Pedido> p1){
		for(int i = 0; i < p1.size(); i++){
			System.out.println("========================================\n");
       		System.out.println("Id: " + p1.get(i).getNumero());
        	System.out.println("- Data do pedido: " + p1.get(i).getDataPedido());
        	System.out.printf("- Situação: " + p1.get(i).getSituação());
        	System.out.println("\n----------------------------------------");
		}
	}

}