package T2.Class;
import T1.Class.*;

import java.util.List;

public class Cliente extends Cadastro{
    private String cartaoCredito;
    private List<Pedido> p1; //tem que ser armazenado os pedidos no qual este cliente fez

    public Cliente(){

    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void addPedido(Pedido t1){
        this.p1.add(t1);
    }

    public void excPedido(Pedido t1){
        this.p1.remove(t1);
    }
}
