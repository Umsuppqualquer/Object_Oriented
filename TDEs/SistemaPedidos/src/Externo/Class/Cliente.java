package Externo.Class;

import java.util.ArrayList;
import java.util.List;

import Interno.Class.*;

public class Cliente extends Cadastro{
    private String login;
    private String senha;
    private String cartaoCredito;
    private Pedido carrinho;
    private List<Pedido> historico; //tem que ser armazenado os pedidos no qual este cliente fez

    public Cliente(){
        this.carrinho = new Pedido();
        this.historico = new ArrayList<Pedido>();

    }

    public Cliente(String nome, String telefone, String email, Endereco local,String login, String senha, String cartaoCredito){
        super(nome, telefone, email, local); //da para chamar deste jeito o construtor da classe cadastro
        
        this.login = login;
        this.senha = senha;
        this.cartaoCredito = cartaoCredito;
        this.carrinho = new Pedido();
        this.historico = new ArrayList<Pedido>();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public Pedido getCarrinho(){
        return carrinho;
    }

    public void addHistorico(Pedido t1){
        this.historico.add(t1);
    }

    public void excHistorico(Pedido t1){
        this.historico.remove(t1);
    }

    public int sizeHistorico(){
        return this.historico.size();
    }

    public Pedido pedidoAt(int i){
        return this.historico.get(i);
    }

    public boolean autenticUser(Object obj) {
        if (this == obj)
            return true;
    
        if (obj == null || getClass() != obj.getClass())
            return false;
    
        Cliente aux = (Cliente) obj;
    
        if (!this.getLogin().equals(aux.getLogin()) || !this.getSenha().equals(aux.getSenha()))
            return false;
    
        return true;
    }

    public boolean valUser(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente aux = (Cliente) obj;
        if(this.getLogin() == aux.getLogin() || this.getEmail() == this.getEmail())
            return true;
        return false;
    }

    public void clearCart(){ //arrumar isto não pode simplesmente deixar nulo tem que zerar
        this.carrinho = null;
    }

    public void showPedidos(){
        int i;
        System.out.println("\n========================================");
        System.out.println("           Histórico de compras           ");
        System.out.println("========================================\n");
        for(i=0; i < this.sizeHistorico();i++){
                System.out.println("Número: " + this.pedidoAt(i).getNumero());
                System.out.println("- Situação: " + this.pedidoAt(i).getSituação());
                System.out.printf("- Data da compra: " + this.pedidoAt(i).getDataPedido());
                System.out.println("----------------------------------------");
        }
        System.out.println("\n");
    }
}
