package Externo.Menu;

import java.util.Scanner;

import Geral.*;
import Externo.Class.Cliente;
import Externo.Class.ItemPedido;
import Externo.Class.Pedido;

public class MenuCliente {

    public static void menuUser(Cliente log, Shop list){
        int esc = 1;
		Scanner sc1 = new Scanner(System.in);
		Pedido p1 = new Pedido();

        System.out.println("Ola: " +  log.getNome() + "\n");

		while (true) {
			Utils.clearConsole();
			System.out.println("=======================================");
			System.out.println("           Menu do Cliente             ");
			System.out.println("=======================================");
			System.out.println("Selecione uma opção:");
			System.out.println("---------------------------------------");
			System.out.println("1. Buscar produtos");
			System.out.println("2. Carrinho de compras");
			System.out.println("3. Finalizar Compra");
			System.out.println("4. Meus pedidos");
			System.out.println("---------------------------------------");
			System.out.println("0. Retornar ao menu principal\n");
			System.out.print("Opção: ");
			esc = sc1.nextInt();
			switch (esc) {
			case 1:
				Utils.clearConsole();
                list.showShop();
				ItemPedido novo = new ItemPedido();
				System.out.println("Digite o id, do item que deseja comprar.");
				int aux = sc1.nextInt();
				System.out.println("Digite a quantidade que gostaria de adicionar ao carrinho.");

				Utils.fim();
				break;
			case 2:
				System.out.println("2. Carrinho de compras.");
				//showCart(p1);			
				Utils.fim();
				break;
			case 3:
				System.out.println("3. Finalizar pedido");

				Utils.fim();
				break;
			case 4:
				System.out.println("4. Meus pedidos.");
				
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

    /*public static void itensSale(Cliente c1, Shop list){ //organizando
		Scanner sc2 = new Scanner(System.in);
		int esc;

		list.showShop();

    }*/

	/*public static void showCart(Pedido p1){

		for (int i = 0; i < p1.produtoSize(); i++) {
            ItemPedido = this.product.get(i);
            if (produto.getEstoque() != null && produto.getEstoque().getQuantidade() != 0) {
                System.out.println("Id: " + produto.getId() + " - " + produto.getNome());
                System.out.println("- Quantidade: " + produto.getEstoque().getQuantidade() + " unidade(s)");
                System.out.printf("- Valor (un): R$ %.2f\n", produto.getEstoque().getPreco() * produto.get);
                System.out.println("----------------------------------------");
            }
        }

	}*/
    
}
