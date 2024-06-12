package T2.Class;
import T1.Class.*;

public class Cliente {
    private String name;
    private String telefone;
    private String email;
    private String cartaoCredito;
    private Endereco end;
    private ArrayList<Pedido> p1; //tem que ser armazenado os pedidos no qual este cliente fez

    public Cliente(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }
    
    public Endereco getEnd() {
        return end;
    }
}
