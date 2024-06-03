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
            System.out.println("0. Sair");
            esc = sc1.nextInt();

            switch (esc) {
                case 1:
                    System.out.println("Você escolheu a Opção 1. Cadastro de produto.");
                    cadProd(p1,f2);
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2. Printar os fornecedores.\n\n");
                    escProd(p1);
                    break; 
                case 3:
                    System.out.println("Você escolheu a Opção 3. Excluir fornecedor.");
                    SimpEsc();
                    System.out.println("Digite o número do fornecedor que deseja excluir:");
                    int i = sc1.nextInt();
                    excForn(, i);
                    break;
                case 4:
                    System.out.println("Você escolheu a Opção 4. Ajuste de cadastro de fornecedor. ");
                    SimpEsc();
                    System.out.println("Digite o número do fornecedor que deseja ajustar:");
                    int j = sc1.nextInt();
                    AjustForn(, j);
                    break;

                case 5:
                    System.out.println("Você escolheu a Opção 5. Consulta por nome ou código.");
                    System.out.println("Digite o nome ou código do fornecedor que deseja pesquisar:");
                    sc1.nextLine();
                    String chavePesquisa = sc1.nextLine();
                    searchForn(, chavePesquisa);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return; // Sai do programa
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

    public static void SimpEsc(ArrayList<Produto> p1){
        char a = '\n';
        for(int i = 0; i < .size(); i++){
            if(.get(i).getNome().charAt(0) == a){
                System.out.println(i + "° - " + .get(i).getNome());
            }
            else{
                a = .get(i).getNome().charAt(0);
                System.out.println("\n----------------------------------------\n");
                System.out.println(a);
                System.out.println(i + "° - " + .get(i).getNome());
            } 
        }
    }

    public static void excForn(ArrayList<Fornecedor> , int index){
        Scanner sc2 = new Scanner(System.in);
        System.out.println("\nConfirmar exclusão de cadastro: " + .get(index).getNome());
        System.out.println("1 - Sim\n" + "2 - Não");
        int op = sc2.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    .remove(index);
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

    public static void orgList(ArrayList<Produto> p1){
        Collections.sort(p1, new Comparator<Produto>() {
            @Override
            public int compare(Produto produto1, Produto produto2){
                return produto1.getNome().compareTo(produto2.getNome());
            }
        });
    }

    public static void AjustForn(ArrayList<Fornecedor> , int index){
        Scanner sc = new Scanner(System.in);

        if(index >= 0 && index < .size()){
            Fornecedor aux = .get(index);

            System.out.println("\nMenu de Ajuste para Fornecedor: " + aux.getNome());
            System.out.println("Digite o novo nome do fornecedor (ou ENTER para manter o mesmo):");
            String novoNome = sc.nextLine();
            if (!novoNome.isEmpty()) {
                aux.setNome(novoNome);
            }

            System.out.println("Digite a nova descrição do fornecedor (ou ENTER para manter a mesma):");
            String novaDescricao = sc.nextLine();
            if (!novaDescricao.isEmpty()) {
                aux.setDescricao(novaDescricao);
            }

            System.out.println("Digite o novo telefone do fornecedor (ou ENTER para manter o mesmo):");
            String novoTelefone = sc.nextLine();
            if (!novoTelefone.isEmpty()) {
                aux.setTelefone(novoTelefone);
            }

            System.out.println("Digite o novo email do fornecedor (ou ENTER para manter o mesmo):");
            String novoEmail = sc.nextLine();
            if (!novoEmail.isEmpty()) {
                aux.setEmail(novoEmail);
            }

            Endereco enderecoAtual = aux.getEnd();
            System.out.println("Digite os novos dados do endereço:");

            System.out.println("Rua (ou ENTER para manter a mesma):");
            String novaRua = sc.nextLine();
            if (!novaRua.isEmpty()) {
                enderecoAtual.setRua(novaRua);
            }

            System.out.println("Número (ou ENTER para manter o mesmo):");
            String novoNumero = sc.nextLine();
            if (!novoNumero.isEmpty()) {
                enderecoAtual.setNumero(novoNumero);
            }

            System.out.println("Complemento (ou ENTER para manter o mesmo):");
            String novoComplemento = sc.nextLine();
            if (!novoComplemento.isEmpty()) {
                enderecoAtual.setComplmento(novoComplemento);
            }

            System.out.println("Bairro (ou ENTER para manter o mesmo):");
            String novoBairro = sc.nextLine();
            if (!novoBairro.isEmpty()) {
                enderecoAtual.setBairro(novoBairro);
            }

            System.out.println("CEP (ou ENTER para manter o mesmo):");
            String novoCep = sc.nextLine();
            if (!novoCep.isEmpty()) {
                enderecoAtual.setCep(novoCep);
            }

            System.out.println("Cidade (ou ENTER para manter a mesma):");
            String novaCidade = sc.nextLine();
            if (!novaCidade.isEmpty()) {
                enderecoAtual.setCidade(novaCidade);
            }

            System.out.println("Estado (ou ENTER para manter o mesmo):");
            String novoEstado = sc.nextLine();
            if (!novoEstado.isEmpty()) {
                enderecoAtual.setEstado(novoEstado);
            }

            System.out.println("Fornecedor ajustado com sucesso:");
        } 
        else {
            System.out.println("Opção de fornecedor inválida.");
        }
    }

    public static void searchForn(ArrayList<Fornecedor> , String key) {
        ArrayList<Fornecedor> resultados = pesquisarFornecedor(, key);
    
        if (resultados.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado com o nome '" + key + "'.");
        } else {
            System.out.println("Resultados da pesquisa:");
            for (Fornecedor fornecedor : resultados) {
                System.out.println(fornecedor);
            }
        }
    }
    
    public static ArrayList<Fornecedor> pesquisarFornecedor(ArrayList<Fornecedor> fornecedores, String nomePesquisa) {
        ArrayList<Fornecedor> resultados = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getNome().equalsIgnoreCase(nomePesquisa)) {
                resultados.add(fornecedor);
            }
        }
        return resultados;
    }

}
