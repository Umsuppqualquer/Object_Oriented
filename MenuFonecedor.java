package T1;
import java.util.*;

// deletar por indice
// sistema colocar id
// colocar para cadastrar o estoque ou seja cria o objeto depois joga para o objeto produto.

public class MenuFonecedor {
   
    public static void SupMenu(ArrayList<Fornecedor> f2){

        Endereco enderecoCliente1 = new Endereco("Rua da Paz", "456", "Bloco B, Ap. 301", "Jardim Botânico", "54321-123", "São Paulo", "SP");
        Fornecedor f4 = new Fornecedor("Tech Solutions Ltda.", "Empresa especializada em soluções de TI", "11 98765-4321", "contato@techsolutions.com", enderecoCliente1);
        f2.add(f4);

        Endereco enderecoFornecedor = new Endereco("Rua das Flores", "123", "Sala 101", "Centro", "12345-678", "Cidade A", "Estado X");
        Fornecedor f5 = new Fornecedor("Magazine Luiza", "Descrição do fornecedor", "123456789", "fornecedor@empresa.com", enderecoFornecedor);
        f2.add(f5);

        Endereco enderecoCliente = new Endereco("Avenida Principal", "456", "Apartamento 202", "Bairro B", "54321-987", "Cidade B", "Estado Y");
        Fornecedor f6 = new Fornecedor("Pao Quente", "Outra descrição do fornecedor", "987654321", "outro@empresa.com", enderecoCliente);
        f2.add(f6);

        Endereco enderecoFilial = new Endereco("Rua do Comércio", "789", "Sala 303", "Centro", "98765-432", "Cidade C", "Estado Z");
        Fornecedor f7 = new Fornecedor("Kabum", "Mais uma descrição do fornecedor", "654321987", "maisum@empresa.com", enderecoFilial);
        f2.add(f7);

        while(true){

            Scanner sc1 = new Scanner(System.in);
            int esc;

            orgList(f2);
            
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro de fornecedor. ");
            System.out.println("2. Mostra todos os fornecedores. ");
            System.out.println("3. Excluir fornecedor. ");
            System.out.println("4. Ajuste de cadastro de fornecedor. ");
            System.out.println("5. Consulta por nome ou código. ");
            System.out.println("0. Sair");
            esc = sc1.nextInt();

            switch (esc) {
                case 1:
                    System.out.println("Você escolheu a Opção 1. Cadastro de fornecedor.");
                    cadForn(f2);
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2. Printar os fornecedores.\n\n");
                    escForn(f2);
                    break;
                case 3:
                    System.out.println("Você escolheu a Opção 3. Excluir fornecedor.");
                    SimpEsc(f2);
                    System.out.println("Digite o número do fornecedor que deseja excluir:");
                    int i = sc1.nextInt();
                    excForn(f2, i);
                    break;
                case 4:
                    System.out.println("Você escolheu a Opção 4. Ajuste de cadastro de fornecedor. ");
                    SimpEsc(f2);
                    System.out.println("Digite o número do fornecedor que deseja ajustar:");
                    int j = sc1.nextInt();
                    AjustForn(f2, j);
                    break;

                case 5:
                    System.out.println("Você escolheu a Opção 5. Consulta por nome ou código.");
                    System.out.println("Digite o nome ou código do fornecedor que deseja pesquisar:");
                    sc1.nextLine();
                    String chavePesquisa = sc1.nextLine();
                    searchForn(f2, chavePesquisa);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return; // Sai do programa
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }

    }

    public static void cadForn(ArrayList<Fornecedor> f2){ //quando crio o vetor de objetos tenho que estanciar cada posição?
        /*Para manipular este objeto, criar um objeto separado e depois setar no objeto maior, ou seja coloca os atributos de Fornecedor e criar 
        uma variável do tipo de endereço setar para o objeto maior, e depois de acabar o método o garbage colector libera o espaço */

        Scanner sc2 = new Scanner(System.in);
        Endereco aux = new Endereco();
        Fornecedor f = new Fornecedor();
        
        System.out.println("\n\nDigite o nome do fornecedor: ");
        f.setNome(sc2.nextLine());
        System.out.println("\n\nDigite a descrição do fornecedor: ");
        f.setDescricao(sc2.nextLine());
        System.out.println("\n\nDigite o telefone do fornecedor: ");
        f.setTelefone(sc2.nextLine());
        System.out.println("\n\nDigite o email do fornecedor: ");
        f.setEmail(sc2.nextLine());
        System.out.println("\n\nDigite a rua no qual se localiza: ");
        aux.setRua(sc2.nextLine());
        System.out.println("\n\nDigite o número de endereço: ");
        aux.setNumero(sc2.nextLine());
        System.out.println("\n\nComplemento do endereço:  ");
        aux.setComplmento(sc2.nextLine());
        System.out.println("\n\nBairro aonde se localiza: ");
        aux.setBairro(sc2.nextLine());
        System.out.println("\n\nCódigo CEP: ");
        aux.setCep(sc2.nextLine());
        System.out.println("\n\nCidade onde reside: ");
        aux.setCidade(sc2.nextLine());
        System.out.println("\n\nEstado onde reside: ");
        aux.setEstado(sc2.nextLine());

        f.setEnd(aux);
        
        f2.add(f);

        System.out.println("\n\n\nFornecedor cadastrado com sucesso, pressione ENTER para retornar.");
        return;
    }

    public static void escForn(ArrayList<Fornecedor> f2){
        Endereco aux;
        for(int i = 0; i < f2.size(); i++){
            System.out.println("\n----------------------------------------\n");
            System.out.println("Nome da empresa: " + f2.get(i).getNome() + "\n- " + f2.get(i).getDescricao() + "\nTelefone: " + f2.get(i).getTelefone() + "\nEmail: " + f2.get(i).getEmail());
            aux = f2.get(i).getEnd();
            System.out.println("Rua: " + aux.getRua() + "\nNúmero: " + aux.getNumero() + "\nComplmento: " + aux.getComplmento() + "\nBairro: " + aux.getBairro() + "\nCep: " + aux.getCep() + "\nCidade: " + aux.getCidade() + "\nEstado: " + aux.getEstado());
        System.out.println("\n");
        }
    }

    public static void SimpEsc(ArrayList<Fornecedor> f2){
        char a = '\n';
        for(int i = 0; i < f2.size(); i++){
            if(f2.get(i).getNome().charAt(0) == a){
                System.out.println(i + "° - " + f2.get(i).getNome());
            }
            else{
                a = f2.get(i).getNome().charAt(0);
                System.out.println("\n----------------------------------------\n");
                System.out.println(a);
                System.out.println(i + "° - " + f2.get(i).getNome());
            } 
        }
    }

    public static void excForn(ArrayList<Fornecedor> f2, int index){
        Scanner sc2 = new Scanner(System.in);
        System.out.println("\nConfirmar exclusão de cadastro: " + f2.get(index).getNome());
        System.out.println("1 - Sim\n" + "2 - Não");
        int op = sc2.nextInt();
        while (true) {
            switch (op) {
                case 1:
                    f2.remove(index);
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

    public static void orgList(ArrayList<Fornecedor> f2){
        Collections.sort(f2, new Comparator<Fornecedor>() {
            @Override
            public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2){
                return fornecedor1.getNome().compareTo(fornecedor2.getNome());
            }
        });
    }

    public static void AjustForn(ArrayList<Fornecedor> f2, int index){
        Scanner sc = new Scanner(System.in);

        if(index >= 0 && index < f2.size()){
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
        } 
        else {
            System.out.println("Opção de fornecedor inválida.");
        }
    }

    public static void searchForn(ArrayList<Fornecedor> f2, String key) {
        ArrayList<Fornecedor> resultados = pesquisarFornecedor(f2, key);
    
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