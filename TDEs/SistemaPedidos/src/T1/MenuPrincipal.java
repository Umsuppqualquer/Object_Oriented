package T1;
import java.util.*;

//ajustado

public class MenuPrincipal {
    public static void main(String[] args) {
        int esc = 1;
        ArrayList<Fornecedor> f2 = new ArrayList<>();
        ArrayList<Produto> p1 = new ArrayList<>();
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            Utils.clearConsole();
            System.out.println("Selecione uma opção:");
            System.out.println("1. Fornecedor");
            System.out.println("2. Produto");
            System.out.println("3. Estoque");
            System.out.println("9. Setup");
            System.out.println("0. Sair");
            esc = sc1.nextInt();
            switch (esc) {
                case 1:
                    System.out.println("1. Fornecedor");
                    MenuFonecedor.SupMenu(f2);
                    break;
                case 2:
                    System.out.println("2. Produto");
                    MenuProduto.ProMenu(f2, p1);
                    break;
                case 3:
                    System.out.println("3. Estoque");
                    MenuEstoque.EstqMenu(p1);
                    break;
                case 9:
                    System.out.println("Realizando o setup...");
                    Utils.setup(f2, p1);
                    Utils.fim();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    Utils.fim();
            }
        }
    }
}
