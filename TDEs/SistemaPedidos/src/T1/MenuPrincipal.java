package T1;
import java.util.*;

// deletar por indice
// sistema colocar id
// colocar para cadastrar o estoque ou seja cria o objeto depois joga para o objeto produto.

public class MenuPrincipal {
   
    public static void main(String[] args) {

        int esc = 1;
        ArrayList<Fornecedor> f2 = new ArrayList<>();
        ArrayList<Produto> p1 = new ArrayList<>();
        Scanner sc1 = new Scanner(System.in);

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
            System.out.println("Selecione uma opção:");
            System.out.println("1. Fornecedor");
            System.out.println("2. Produto");
            System.out.println("3. Opção 3");
            System.out.println("0. Sair");
            esc = sc1.nextInt();
            switch (esc) {
                case 1:
                    System.out.println("1. Fornecedor");
                    

                    break;
                case 2:
                    System.out.println("2. Produto");

                    break;
                case 3:

                

                case 0:
                    System.out.println("0. Fechar o programa");
                    return;

                
            
                default:
                
            }
        }
    }
}
