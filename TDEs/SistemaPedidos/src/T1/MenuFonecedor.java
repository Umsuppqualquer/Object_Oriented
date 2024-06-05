package T1;
import java.util.*;

//ajustado

public class MenuFonecedor {
   
    public static void SupMenu(ArrayList<Fornecedor> f2){

        Utils.clearConsole();

        Scanner sc1 = new Scanner(System.in);

        while (true) {
            int esc;
        
            orgList(f2);
            
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro de fornecedor.");
            System.out.println("2. Mostrar todos os fornecedores.");
            System.out.println("3. Excluir fornecedor.");
            System.out.println("4. Ajuste de cadastro de fornecedor.");
            System.out.println("5. Consulta por nome ou código.");
            System.out.println("0. Sair");
            esc = sc1.nextInt();
        
            switch (esc) {
                case 1:
                    System.out.println("Você escolheu a Opção 1. Cadastro de fornecedor.");
                    cadForn(f2);
                    Utils.fim();
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2. Mostrar os fornecedores.");
                    escForn(f2);
                    Utils.fim();
                    break;
                case 3:
                    System.out.println("Você escolheu a Opção 3. Excluir fornecedor.");
                    SimpEsc(f2);
                    System.out.println("Digite o número do fornecedor que deseja excluir:");
                    int i = sc1.nextInt();
                    excForn(f2, i);
                    Utils.fim();
                    break;
                case 4:
                    System.out.println("Você escolheu a Opção 4. Ajuste de cadastro de fornecedor.");
                    SimpEsc(f2);
                    System.out.println("Digite o número do fornecedor que deseja ajustar:");
                    int j = sc1.nextInt();
                    AjustForn(f2, j);
                    Utils.fim();
                    break;
                case 5:
                    System.out.println("Você escolheu a Opção 5. Consulta por nome ou código.");
                    System.out.println("Digite o nome ou código do fornecedor que deseja pesquisar:");
                    sc1.nextLine();
                    String chavePesquisa = sc1.nextLine();
                    searchForn(f2, chavePesquisa);
                    Utils.fim();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    Utils.clearConsole();
            }
        }
    }

    public static void cadForn(ArrayList<Fornecedor> f2) {
        Scanner sc2 = new Scanner(System.in);
        Endereco aux = new Endereco();
        Fornecedor f = new Fornecedor();
        
        System.out.println("\nDigite o nome do fornecedor:");
        f.setNome(sc2.nextLine());
        System.out.println("\nDigite a descrição do fornecedor:");
        f.setDescricao(sc2.nextLine());
        System.out.println("\nDigite o telefone do fornecedor:");
        f.setTelefone(sc2.nextLine());
        System.out.println("\nDigite o email do fornecedor:");
        f.setEmail(sc2.nextLine());
        System.out.println("\nDigite a rua onde se localiza:");
        aux.setRua(sc2.nextLine());
        System.out.println("\nDigite o número de endereço:");
        aux.setNumero(sc2.nextLine());
        System.out.println("\nComplemento do endereço:");
        aux.setComplmento(sc2.nextLine());
        System.out.println("\nBairro onde se localiza:");
        aux.setBairro(sc2.nextLine());
        System.out.println("\nCódigo CEP:");
        aux.setCep(sc2.nextLine());
        System.out.println("\nCidade onde reside:");
        aux.setCidade(sc2.nextLine());
        System.out.println("\nEstado onde reside:");
        aux.setEstado(sc2.nextLine());
    
        f.setEnd(aux);
        
        f2.add(f);
    
        return;
    }
    
    public static void escForn(ArrayList<Fornecedor> f2) {
        Endereco aux;
        for (int i = 0; i < f2.size(); i++) {
            System.out.println("\n----------------------------------------\n");
            System.out.println("Nome da empresa: " + f2.get(i).getNome() + "\nDescrição: " + f2.get(i).getDescricao() + "\nTelefone: " + f2.get(i).getTelefone() + "\nEmail: " + f2.get(i).getEmail());
            aux = f2.get(i).getEnd();
            System.out.println("Rua: " + aux.getRua() + "\nNúmero: " + aux.getNumero() + "\nComplemento: " + aux.getComplmento() + "\nBairro: " + aux.getBairro() + "\nCEP: " + aux.getCep() + "\nCidade: " + aux.getCidade() + "\nEstado: " + aux.getEstado());
            System.out.println("\n");
        }
    }

    public static void SimpEsc(ArrayList<Fornecedor> f2) {
        char a = '\n';
        for (int i = 0; i < f2.size(); i++) {
            if (f2.get(i).getNome().charAt(0) == a) {
                System.out.println(i + "° - " + f2.get(i).getNome());
            } else {
                a = f2.get(i).getNome().charAt(0);
                System.out.println("\n----------------------------------------\n");
                System.out.println(a);
                System.out.println(i + "° - " + f2.get(i).getNome());
            } 
        }
    }

    public static void excForn(ArrayList<Fornecedor> f2, int index) {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("\nConfirmar exclusão de cadastro: " + f2.get(index).getNome());
        System.out.println("1 - Sim\n2 - Não");
        int op = sc2.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    f2.remove(index);
                    System.out.println("\nFoi realizado a remoção do cadastro!!!");
                    return;
                case 2:
                    System.out.println("Operação de remoção cancelada;");
                    return;
            
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    public static void orgList(ArrayList<Fornecedor> f2) {
        Collections.sort(f2, new Comparator<Fornecedor>() {
            @Override
            public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2) {
                return fornecedor1.getNome().compareTo(fornecedor2.getNome());
            }
        });
    }    

    public static void AjustForn(ArrayList<Fornecedor> f2, int index) {
        Scanner sc = new Scanner(System.in);
    
        if (index >= 0 && index < f2.size()) {
            Fornecedor aux = f2.get(index);
    
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
        } else {
            System.out.println("Opção de fornecedor inválida.");
        }
    }
    
    public static void searchForn(ArrayList<Fornecedor> f2, String key) {
        ArrayList<Fornecedor> resultados = new ArrayList<>();
        
        for (Fornecedor fornecedor : f2) {
            if (fornecedor.getNome().toLowerCase().contains(key.toLowerCase())) {
                resultados.add(fornecedor);
            }
        }
    
        if (resultados.isEmpty()) {
            System.out.println("Nenhum fornecedor encontrado com a palavra '" + key + "'.");
        } else {
            System.out.println("Resultados da pesquisa:");
            for (Fornecedor fornecedor : resultados) {
                System.out.println(fornecedor);
            }
        }
    }
}
