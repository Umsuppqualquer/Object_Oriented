//Lembrar de salvar está classe em um arquivo, ver anotações de aula. (Tentar fazer em json);

//Sempre sobrescrever tudo.

//Criar objeto e ir chamando os menus

//Adcionar try catch;

//Passar por parametro os scanners

package Geral;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import Interno.Class.*;
import Externo.Class.*;

public class Shop implements Serializable {

    private List<Fornecedor> supplyer;
    private List<Produto> product;
    private List<Cliente> users;
    private Contador cont;
    private SimpleDateFormat sleeptime;

    public Shop(){
        this.supplyer = new ArrayList<>();
        this.product = new ArrayList<>();
        this.users = new ArrayList<>();
        this.cont = new Contador();
        this.sleeptime = new SimpleDateFormat("dd/MM/YYYY");
    }

    public SimpleDateFormat getSleeptime() {
        return sleeptime;
    }

    public Contador getCont() {
        return cont;
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

    public void showItem(ItemPedido p1){
        System.out.println("========================================\n");
        System.out.println("Nome: " + p1.getNome());
        System.out.println("- Qntd: " + p1.getQuantidade() + " unidade(s)");
        System.out.printf("- Valor (un): R$ %.2f\n", p1.getPreco());
        System.out.println("----------------------------------------");
    
    }

    public Teste returnId(int id){
        Teste t1 = new Teste();
        for (int i = 0; i < this.product.size(); i++) {
            if (this.prodAt(i).getId() == id){
                t1.setIndex(i);
                t1.setTest(true);
                return t1;
            }
        }
        t1.setTest(false);         
        return t1;
    }

    public int verEstq(ItemPedido p1) {
        for (int j = 0; j < this.sizeProd(); j++) {
            if (p1.getNome().equals(this.prodAt(j).getNome())) {
                int estoqueAtual = this.prodAt(j).getEstoque().getQuantidade();
                int quantidadePedido = p1.getQuantidade();
                
                if (estoqueAtual < quantidadePedido) {
                    return quantidadePedido - estoqueAtual; // Retorna a quantidade que excede o estoque atual
                } else {
                    return 0; // Não há excedente, estoque é suficiente
                }
            }
        }
        
        return -1; // Retorna um valor de erro caso o produto não seja encontrado
    }

    public void attEstq(Pedido p1) {
        for (int i = 0; i < p1.produtoSize(); i++) {
            for (int j = 0; j < this.sizeProd(); j++) {
                if (p1.produtoAT(i).getNome().equals(this.prodAt(j).getNome())) {
                    int novaQuantidade = this.prodAt(j).getEstoque().getQuantidade() - p1.produtoAT(i).getQuantidade();
                    this.prodAt(j).getEstoque().setQuantidade(novaQuantidade);
                    break;                    
                }
            }
        }
    }

    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Banco.txt"))) {
            oos.writeObject(supplyer);  // Grava a lista de fornecedores
            oos.writeObject(product);   // Grava a lista de produtos
            oos.writeObject(users);     // Grava a lista de clientes
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Banco.txt"))) {
            supplyer = (List<Fornecedor>) ois.readObject();  // Lê a lista de fornecedores
            product = (List<Produto>) ois.readObject();      // Lê a lista de produtos
            users = (List<Cliente>) ois.readObject();        // Lê a lista de clientes
            //System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
            Utils.setup(this);
        }
    }

    public ArrayList<Cliente> openOrder(String s1){
        ArrayList<Cliente> aux = new ArrayList<>();
        for(int i = 0; i < this.sizeUser(); i++){
            Cliente aux1 = this.userAt(i);
            for(int j = 0; j < aux1.sizeHistorico(); j++){
                if(aux1.pedidoAt(j).getSituação().equals(s1)){
                   aux.add(aux1);
                   break;
                }

            }
        }
        return aux;
    }
}
