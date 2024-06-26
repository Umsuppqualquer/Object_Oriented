package Externo.Menu;

import java.util.Scanner;

import Geral.*;
import Externo.Class.Cliente;
import Externo.Class.ItemPedido;

public class MenuCliente {

    public static void menuUser(Cliente log, Shop list, Scanner sc){
        int esc = 1;

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
			esc = sc.nextInt();
			switch (esc) {
			case 1:
				Utils.clearConsole();
				while (true) {
					list.showShop();
					ItemPedido novo = new ItemPedido();
					System.out.println("Digite o id, do item que deseja comprar.");
					int id = sc.nextInt();
					Teste t1 = list.returnId(id);
				if(t1.getTest()){
					novo.setNome(list.prodAt(t1.getIndex()).getNome());
					System.out.println("Digite a quantidade que gostaria de adicionar ao carrinho.");
					int qntd = sc.nextInt();
					novo.setQuantidade(qntd);
					novo.setPreco((float) (qntd * list.prodAt(t1.getIndex()).getEstoque().getPreco() * 1.17));
					Utils.clearConsole();
					System.out.println("Item adicionado ao carrinho: ");
					list.showItem(novo);
					log.getCarrinho().addItemCarrinho(novo);
					Utils.fim();
					break;
				}
				else{
					Utils.clearConsole();
					System.out.println("Id digitado indisponível.");
				}
				}
			case 2:
				Utils.clearConsole();
				log.getCarrinho().showItens();	
				Utils.fim();
				break;
			case 3:
				Utils.clearConsole();
				log.getCarrinho().showItens();
				System.out.println("Gostaria de confirmar o pedido");
				System.out.println("0 - Não / 1 - Sim");
				if(sc.nextInt() == 1){
					System.out.println("Informe o número do cartão que será utilizado no pagamento.");
					log.getCarrinho().endPedido();
					log.setCartaoCredito(sc.nextLine());
					log.addHistorico(log.getCarrinho());
					log.clearCart();
					System.out.println("Pedido realizado com sucesso.");
					Utils.fim();
					break;

				}
				else{
					break;
				}
			case 4:
				System.out.println("4. Meus pedidos.");
				log.showPedidos();				
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
}
