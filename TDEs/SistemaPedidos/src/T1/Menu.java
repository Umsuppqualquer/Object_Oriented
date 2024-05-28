package T1;
import java.util.Scanner;
import java.util.ArrayList;

// deletar por indice
// sistema colocar id

public class Menu {
   
    public static void main(String[] args) {

        int esc = 1;
        int cont_fornecedor = 0;
        ArrayList<Fornecedor> f2 = new ArrayList<>();
        Scanner sc1 = new Scanner(System.in);

        //f2.add(new Fornecedor("Silva & Silva", "Empresa de Advocacia", "(54) 99144-2901", "Silva@advogado.com", "Av. Júlio de Castilhos", "203", "Sala Comercial", "Centro", "95081-312", "Porto Alegre", "RS"));
        //cont_fornecedor++; //provisorio lembrar de tirar
        //f2.add(new Fornecedor("João da Silva", "Padaria Pão Quente", "(31) 98765-4321","Joao@padeiro.com", "Rua das Flores", "100", "Loja 1", "Bairro Novo", "12345-678", "Belo Horizonte", "MG"));
        //cont_fornecedor++;
        //f2.add(new Fornecedor("Maria Oliveira", "Consultório Médico", "(11) 98765-4321","Maria@medica.com", "Rua das Palmeiras", "500", "Sala 302", "Jardim das Flores", "54321-876", "São Paulo", "SP"));
        //cont_fornecedor++;
        while(true){
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro de fornecedor. ");
            System.out.println("2. Printar os fornecedores. ");
            System.out.println("3. Excluir fornecedor. ");
            System.out.println("4. Consulta de fornecedor. ");
            System.out.println("5. Sair");
            esc = sc1.nextInt();

            switch (esc) {
                case 1:
                    System.out.println("Você escolheu a Opção 1. Cadastro de fornecedor.");
                    cadForn(f2,cont_fornecedor++);
                    break;
                case 2:
                    System.out.println("Você escolheu a Opção 2. Printar os fornecedores.\n\n");
                    escForn(f2, cont_fornecedor);
                    break;
                case 3:
                    System.out.println("Você escolheu a Opção 3. Excluir fornecedor.");
                    System.out.println("Digite o nome do fornecedor no qual quer excluir.");
                    sc1.nextLine();
                    excForn(f2);
                    break;
                case 4:
                    System.out.println("Você escolheu a Opção 4. Ajuste de cadastro de fornecedor. ");
                    // Adicione aqui o código para a Opção 4
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return; // Sai do programa
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }

    }

    public static void cadForn(ArrayList<Fornecedor> f2,int cont_fornecedor){ //quando crio o vetor de objetos tenho que estanciar cada posição?
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

    public static void escForn(ArrayList<Fornecedor> f2, int cont_fornecedor){
        Endereco aux;
        for(int i = 0; i < cont_fornecedor; i++){
            System.out.println("\n----------------------------------------\n");
            System.out.println("Nome da empresa: " + f2.get(i).getNome() + "\n- " + f2.get(i).getDescricao() + "\nTelefone: " + f2.get(i).getTelefone() + "\nEmail: " + f2.get(i).getEmail());
            aux = f2.get(i).getEnd();
            System.out.println("Rua: " + aux.getRua() + "\nNúmero: " + aux.getNumero() + "\nComplmento: " + aux.getComplmento() + "\nBairro: " + aux.getBairro() + "\nCep: " + aux.getCep() + "\nCidade: " + aux.getCidade() + "\nEstado: " + aux.getEstado());
            System.out.println("\n----------------------------------------\n");
        }
    }

    public static void excForn(ArrayList<Fornecedor> f2){
        
    }
}