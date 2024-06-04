package T1;
import java.util.*;

// deletar por indice
// sistema colocar id
// colocar para cadastrar o estoque ou seja cria o objeto depois joga para o objeto produto.

public class MenuProduto {
   
    public static void ProMenu(ArrayList<Fornecedor> f2, ArrayList<Produto> p1){

        while(true){

            Scanner sc1 = new Scanner(System.in);
            int esc;

            orgList(p1);
            
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro de produto. ");
            System.out.println("2. Mostra todos os produtos. ");
            System.out.println("3. Excluir produto. ");
            System.out.println("4. Ajuste de cadastro de produto. ");
            System.out.println("5. Consulta por nome ou código. ");
            System.out.println("0. Retornar ao menu principal. ");
            esc = sc1.nextInt();

            switch (esc) {
                case 1:
                    System.out.println("Você escolheu a Opção 1. Cadastro de produto.");
                    cadProd(p1,f2);
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2. Printar os produto.\n\n");
                    escProd(p1);
                    break; 
                case 3:
                    System.out.println("Você escolheu a Opção 3. Excluir produto.");
                    SimpEsc(p1);
                    System.out.println("Digite o número do produto que deseja excluir:");
                    int i = sc1.nextInt();
                    excProd(p1, i);
                    break;
                case 4:
                    System.out.println("Você escolheu a Opção 4. Ajuste de cadastro de produto. ");
                    SimpEsc(p1);
                    System.out.println("Digite o número do produto que deseja ajustar:");
                    int j = sc1.nextInt();
                    AjustProd(p1, f2, j);
                    break;

                case 5:
                    System.out.println("Você escolheu a Opção 5. Consulta por nome ou código.");
                    System.out.println("Digite o nome ou código do produto que deseja pesquisar:");
                    sc1.nextLine();
                    String chavePesquisa = sc1.nextLine();
                    searchForn(p1, chavePesquisa);
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }

    }

    public static void cadProd(ArrayList<Produto> p1, ArrayList<Fornecedor> f2){ //ok 

        Scanner sc2 = new Scanner(System.in);
        Fornecedor aux = new Fornecedor();
        Produto p = new Produto();
        
        System.out.println("\n\nDigite o nome do produto: ");
        p.setNome(sc2.nextLine());
        System.out.println("\n\nDigite a descrição do produto: ");
        p.setDescproduto(sc2.nextLine());
        System.out.println("\n\nSelecione o fornecedor: ");
        MenuFonecedor.SimpEsc(f2);
        sc2.nextLine();
        aux = f2.get(sc2.nextInt());
        p.setSuplyer(aux);
        
        p1.add(p);

        System.out.println("\n\n\nProduto cadastrado com sucesso, pressione ENTER para retornar.");
        return;
    }

    public static void escProd(ArrayList<Produto> p1){ //ok
        Fornecedor aux;
        for(int i = 0; i < p1.size(); i++){
            System.out.println("\n----------------------------------------\n");
            System.out.println("Nome do produto: " + p1.get(i).getNome() + "\n- " + p1.get(i).getDescproduto());
            aux = p1.get(i).getSuplyer();
            System.out.println("Fornecedor: " + aux.getNome());
        System.out.println("\n");
        }
    }

    public static void SimpEsc(ArrayList<Produto> p1){ //ok
        char a = '\n';
        for(int i = 0; i < p1.size(); i++){
            if(p1.get(i).getNome().charAt(0) == a){
                System.out.println(i + "° - " + p1.get(i).getNome());
            }
            else{
                a = p1.get(i).getNome().charAt(0);
                System.out.println("\n----------------------------------------\n");
                System.out.println(a);
                System.out.println(i + "° - " + p1.get(i).getNome());
            } 
        }
    }

    public static void excProd(ArrayList<Produto> p1, int index){//ok
        Scanner sc2 = new Scanner(System.in);
        System.out.println("\nConfirmar exclusão de cadastro: " + p1.get(index).getNome());
        System.out.println("1 - Sim\n" + "2 - Não");
        int op = sc2.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    p1.remove(index);
                    System.out.println("\n Foi realizado a remoção do cadastro!!!");
                    return;
                case 2:
                    System.out.println("Operação de remoção cancelada;");
                    return;
            
                default:
                    System.out.println("Opção inválida tente novamente.");
                    break;
            }
        }
    }

    public static void orgList(ArrayList<Produto> p1){//ok
        Collections.sort(p1, new Comparator<Produto>() {
            @Override
            public int compare(Produto produto1, Produto produto2){
                return produto1.getNome().compareTo(produto2.getNome());
            }
        });
    }

    public static void AjustProd(ArrayList<Produto> p1, ArrayList<Fornecedor> f1, int index){ //ok
        Scanner sc = new Scanner(System.in);

        if(index >= 0 && index < p1.size()){
            Produto aux = p1.get(index);

            System.out.println("\nMenu de Ajuste para Produto: " + aux.getNome());
            System.out.println("Digite o novo nome do produto (ou ENTER para manter o mesmo):");
            String novoNome = sc.nextLine();
            if (!novoNome.isEmpty()) {
                aux.setNome(novoNome);
            }

            System.out.println("Digite a nova descrição do produto (ou ENTER para manter a mesma):");
            String novaDescricao = sc.nextLine();
            if (!novaDescricao.isEmpty()) {
                aux.setDescproduto(novaDescricao);
            }

            Fornecedor FornecedorAtt = aux.getSuplyer();
            System.out.println("Selecione o novo fornecedor (ou Enter para manter o mesmo):");
            MenuFonecedor.SimpEsc(f1);
            String newsup = sc.nextLine();
            int conv = Integer.valueOf(newsup);
            if (!newsup.isEmpty()) {
                aux.setSuplyer(f1.get(conv));;
            }

            System.out.println("Produto ajustado com sucesso:");
        } 
        else {
            System.out.println("Opção de produto inválida.");
        }
    }

    public static void searchForn(ArrayList<Produto> p1, String key) {//ok
        ArrayList<Produto> resultados = pesquisarProduto(p1, key);
    
        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome '" + key + "'.");
        } else {
            System.out.println("Resultados da pesquisa:");
            for (Produto produto : resultados) {
                System.out.println(produto);
            }
        }
    }
    
    public static ArrayList<Produto> pesquisarProduto(ArrayList<Produto> p1, String nomePesquisa) {//ok
        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto produto : p1) {
            if (produto.getNome().equalsIgnoreCase(nomePesquisa)) {
                resultados.add(produto);
            }
        }
        return resultados;
    }

}
