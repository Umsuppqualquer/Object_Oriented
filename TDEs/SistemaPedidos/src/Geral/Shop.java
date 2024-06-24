//Lembrar de salvar está classe em um arquivo, ver anotações de aula. (Tentar fazer em json);

//Sempre sobrescrever tudo.

//Criar objeto e ir chamando os menus

//Adcionar try catch;

//Passar por parametro os scanners

package Geral;

import java.util.*;

import Interno.Class.*;
import Externo.Class.*;

public class Shop {

    private List<Fornecedor> supplyer;
    private List<Produto> product;
    private List<Cliente> users;

    public Shop(){
        this.supplyer = new ArrayList<>();
        this.product = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addForne(Fornecedor f1){
        this.supplyer.add(f1);
    }

    public void excForne(Fornecedor f1){
        this.supplyer.remove(f1);
    }

    public void addProd(Produto p1){
        this.product.add(p1);
    }

    public void excProd(Produto p1){
        this.product.remove(p1);
    }

    public void addUser(Cliente u1){
        this.users.add(u1);
    }

    public void excUser(Cliente u1){
        this.users.remove(u1);
    }

    public int sizeForne(){
        return this.supplyer.size();
    }

    public int sizeProd(){
        return this.product.size();
    }

    public int sizeUser(){
        return this.users.size();
    }

    public Fornecedor forneAt(int index){
        return this.supplyer.get(index);
    }

    public Produto prodAt(int index){
        return this.product.get(index);
    }

    public Cliente userAt(int index){
        return this.users.get(index);
    }

    public void prodSimp() {
        System.out.println("\n========================================");
        System.out.println("             Lista de Produtos           ");
        System.out.println("========================================\n");
    
        char last = '\0';
    
        for (int i = 0; i < this.product.size(); i++) {
            char currentInitial = this.product.get(i).getNome().charAt(0);
            if (currentInitial != last) {
                System.out.println(currentInitial);
                System.out.println("----------------------------------------");
                last = currentInitial;
            }
            System.out.println(i + "° - " + product.get(i).getNome());
            System.out.println();
        }
        System.out.println("\n========================================\n");
    }

    public void fornSimp() {
        System.out.println("\n========================================");
        System.out.println("          Lista de Fornecedores          ");
        System.out.println("========================================\n");
        char lastInitial = '\0';
        for (int i = 0; i < this.supplyer.size(); i++) {
            String nomeFornecedor = this.supplyer.get(i).getNome();
            char currentInitial = nomeFornecedor.charAt(0);
            if (currentInitial != lastInitial) {
                System.out.println(currentInitial);
                System.out.println("----------------------------------------");
                lastInitial = currentInitial;
            }
            System.out.println(i + "° - " + nomeFornecedor);
            System.out.println();
        }
        System.out.println("\n========================================\n");
    }

    public Teste recSenha(String key) {
        Teste t1 = new Teste();
    
        for (int i = 0; i < this.users.size(); i++) {
            Cliente user = this.userAt(i);
            if (user.getLogin().equalsIgnoreCase(key) || user.getEmail().equalsIgnoreCase(key)) {
                t1.setIndex(i);
                t1.setTest(true);
                return t1;
            }
        }
    
        t1.setTest(false);
        return t1;
    }

    public Teste authUser(Cliente cliente) {
        Teste t1 = recSenha(cliente.getLogin());
    
        if (t1.getTest()) {
            Cliente clienteAutenticado = this.userAt(t1.getIndex());
    
            if (clienteAutenticado.autenticUser(cliente)) {
                return t1;
            } else {
                t1.setTest(false);
            }
        } else {
            // Login inválido
            t1.setTest(false);
        }
    
        return t1;
    }
    

    public void showShop() {
        System.out.println("\n========================================");
        System.out.println("           Produtos Disponíveis        ");
        System.out.println("========================================\n");
        for (int i = 0; i < this.product.size(); i++) {
            Produto produto = this.product.get(i);
            if (produto.getEstoque() != null && produto.getEstoque().getQuantidade() != 0) {
                System.out.println("Id: " + produto.getId() + " - " + produto.getNome());
                System.out.println("- Estoque: " + produto.getEstoque().getQuantidade() + " unidade(s)");
                System.out.printf("- Valor (un): R$ %.2f\n", produto.getEstoque().getPreco() * 1.17);
                System.out.println("----------------------------------------");
            }
        }
        System.out.println("\n");
    }

    public Produto returnId(int id){
        for (int i = 0; i < this.product.size(); i++) {
            Cliente user = this.userAt(i);
            if (this.prodAt(i).getId() == id){
                return prodAt(i);
            }
            else{
                return false;
            }
        }
    
        t1.setTest(false);
        return t1;
    }
}
