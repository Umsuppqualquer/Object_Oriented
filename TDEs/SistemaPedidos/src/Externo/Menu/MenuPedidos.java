package Externo.Menu;

import java.text.SimpleDateFormat;
import java.util.*;

import Externo.Class.*;
import Geral.*;

public class MenuPedidos {

	public static void cadMenu(Shop list, Scanner sc) {
		List<Cliente> control;
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
				escOrder(control, list.getSleeptime());
				Utils.fim();
				break;
			case 2:
				System.out.println("2. Alterar Status de pedidos.");
				Pedido p1 = searchOrder(control, sc, list.getSleeptime());
				if(p1 != null){
					altOrder(list,p1, sc);
				}
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

	public static void escOrder(List<Cliente> c1, SimpleDateFormat simple){
		Utils.clearConsole();
		for(int j = 0; j < c1.size();j++){
			Cliente p1 = c1.get(j);
			System.out.println("Usuário: " + p1.getNome());
			System.out.println("========================================\n");
			for(int i = 0; i < p1.sizeHistorico(); i++){
				if(p1.pedidoAt(i).getSituação().equals("Em aberto")){
					System.out.println("Id: " + p1.pedidoAt(i).getNumero());			
					System.out.println("- Data do pedido: " + simple.format(p1.pedidoAt(i).getDataPedido()));
					System.out.printf("- Situação: " + p1.pedidoAt(i).getSituação());
					System.out.println("\n----------------------------------------");
				}
			}
			System.out.println("\n");
		}
	}

	public static Pedido searchOrder(List<Cliente> c1, Scanner sc, SimpleDateFormat simple){
		Utils.clearConsole();
		escOrder(c1, simple);
		System.out.println("Digite o id o qual gostaria de alterar o status: ");
		int aux = sc.nextInt();
		for(int i = 0; i < c1.size(); i++){
			Cliente p1 = c1.get(i);
			for(int j = 0; j < c1.size(); j++){
				if(p1.pedidoAt(j).getNumero() == aux){
					return p1.pedidoAt(j);
				}
			}
		}
		return null;
	}

	public static void altOrder(Shop list,Pedido p1, Scanner sc){
		Utils.clearConsole();
		p1.fullOrder(list.getSleeptime());
		System.out.println("Deseja alterar o status para a caminho?  \n");
		System.out.println("0 - Não / 1 - Sim");
		int aux = sc.nextInt();
		if(aux != 0){
			p1.setSituação("A caminho");
			Utils.clearConsole();
			System.out.println("\nFoi realizado a alteração.");
			Utils.pressEnter();
		}
		System.out.println("Deseja colocar a previsão de entrega?  \n");
		System.out.println("0 - Não / 1 - Sim");
		if(aux != 0){
			System.out.println("Digite em quantos dias serão necessários para entrega: ");
			aux = sc.nextInt();
			Date data = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			cal.add(Calendar.DATE, aux);
			p1.setDataEntrega(cal.getTime());
			Utils.clearConsole();
			System.out.println("\nFoi realizado a alteração.");
			Utils.pressEnter();
		}
	}


}