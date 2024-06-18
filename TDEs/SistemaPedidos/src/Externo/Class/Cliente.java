package Externo.Class;

import java.util.List;

import Interno.Class.*;

public class Cliente extends Cadastro{
    private String login;
    private String senha;
    private String cartaoCredito;
    private List<Pedido> pedidos; //tem que ser armazenado os pedidos no qual este cliente fez

    public Cliente(){

    }

    public Cliente(String nome, String telefone, String email, Endereco local,String login, String senha, String cartaoCredito){
        super(nome, telefone, email, local); //da para chamar deste jeito o construtor da classe cadastro
        
        this.login = login;
        this.senha = senha;
        this.cartaoCredito = cartaoCredito;
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

    public void addPedido(Pedido t1){
        this.pedidos.add(t1);
    }

    public void excPedido(Pedido t1){
        this.pedidos.remove(t1);
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
}
