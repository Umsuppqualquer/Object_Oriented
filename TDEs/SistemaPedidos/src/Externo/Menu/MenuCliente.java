package Externo.Menu;

import java.util.Scanner;

import Geral.*;
import Externo.Class.Cliente;
import Externo.Class.ItemPedido;

public class MenuCliente {

    public static void menuUser(Cliente log, Shop list, Scanner sc, Contador cont){
        int esc = 1;

		while (true) {
			//Utils.clearConsole();
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
					
					System.out.println("Digite o ID do item que deseja comprar (ou pressione 0 para sair):");
					int id = sc.nextInt();
					
					if (id == 0) {
						Utils.clearConsole();
						break;
					}
					
					Teste t1 = list.returnId(id);
					
					if (t1.getTest()) {
						novo.setNome(list.prodAt(t1.getIndex()).getNome());
						
						System.out.println("Digite a quantidade que gostaria de adicionar ao carrinho:");
						int qntd = sc.nextInt();
						sc.nextLine();
						
						novo.setQuantidade(qntd);
						novo.setPreco((float) (qntd * list.prodAt(t1.getIndex()).getEstoque().getPreco() * 1.17));
						Utils.clearConsole();
						System.out.println("Item adicionado ao carrinho:");
						list.showItem(novo);
						log.getCarrinho().addItemCarrinho(novo);
						Utils.escArq(list);
						Utils.fim();
						break;
					} else {
						Utils.clearConsole();
						System.out.println("ID digitado indisponível.");
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
					System.out.println("Gostaria de confirmar o pedido?");
					System.out.println("0 - Não / 1 - Sim");
					if (sc.nextInt() == 1) {
						if (contEstq(log, list, sc) <= 0) {
							break;
						}
						sc.nextLine();
				
						System.out.println("Informe o número do cartão que será utilizado no pagamento:");
						String numeroCartao = sc.nextLine();
				
						log.getCarrinho().endPedido(cont);
						log.setCartaoCredito(numeroCartao);
						list.attEstq(log.getCarrinho());
						log.addHistorico(log.getCarrinho());
						log.clearCart(cont);
						Utils.escArq(list);

						Utils.clearConsole();				
						System.out.println("Pedido realizado com sucesso.");
					}
					Utils.fim();
					break;
				case 4:
					System.out.println("4. Meus pedidos.");
					log.showPedidos(list.getSleeptime());				
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
	
	public static int contEstq(Cliente log, Shop list, Scanner sc){
		int flag = log.getCarrinho().produtoSize();
		for (int i = 0; i < log.getCarrinho().produtoSize(); i++){
			ItemPedido item = log.getCarrinho().produtoAT(i);
			int faltaEstoque = list.verEstq(item);
			if (faltaEstoque > 0){
				System.out.println("O produto '" + item.getNome() + "' possui quantidade insuficiente em estoque.");
					System.out.println("Quantidade disponível em estoque: " + (item.getQuantidade() - faltaEstoque));
				System.out.println("Quantidade no carrinho: " + item.getQuantidade());
				System.out.println("Deseja ajustar a quantidade no carrinho ou excluir o item?");
				System.out.println("1 - Ajustar a quantidade");
				System.out.println("2 - Excluir o item do carrinho");
				System.out.print("Opção: ");
				int op = sc.nextInt();
				sc.nextLine();
				switch (op) {
					case 1:// Ajustar a quantidade no carrinho para a quantidade disponível em estoque
						System.out.println("Digite a nova quantidade para o item:");
						int novaQuantidade = sc.nextInt();
						sc.nextLine();
						int estoqueDisponivel = item.getQuantidade() - faltaEstoque;
						if (novaQuantidade <= estoqueDisponivel) {
							// Atualizar a quantidade no carrinho
							item.setQuantidade(novaQuantidade);
							System.out.println("Quantidade ajustada para: " + novaQuantidade);
						} else {
							Utils.clearConsole();
							System.out.println("Quantidade digitada excede o estoque disponível. Operação cancelada.");
							Utils.pressEnter();
							return 0;
						}
						break;
					case 2:// Remover o item do carrinho
						log.getCarrinho().excItemCarrinho(item);
						System.out.println("Item removido do carrinho.");
						flag--;
					default:
						System.out.println("Opção inválida. O item permanecerá no carrinho com a quantidade original.");
						return 0;
				}

			}
		}
		return flag;

	}
}
