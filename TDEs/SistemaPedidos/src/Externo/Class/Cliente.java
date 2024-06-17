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
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente aux = (Cliente) obj;
        if(this.getLogin() != aux.getLogin() || this.getSenha() != aux.getSenha()){
            return false;
        }
        return true;
    }
}
