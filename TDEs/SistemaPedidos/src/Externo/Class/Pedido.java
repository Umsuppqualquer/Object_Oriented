package Externo.Class;

import java.util.ArrayList;
import java.util.Date;

//A classe pedido não herda cliente, ela tem que ter um cliente

public class Pedido {
    private int numero;
    private static int cont = 0;
    private Date dataPedido;
    private Date dataEntrega;
    private String situação;
    private ArrayList<ItemPedido> carrinho;

    public Pedido(){
        this.numero = cont;
        cont++;
        dataPedido = new Date();
        carrinho = new ArrayList<>();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setSituação(String situação) {
        this.situação = situação;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public String getSituação() {
        return situação;
    }

    public void excItemCarrinho(int i){
        carrinho.remove(i);
    }

    public void addItemCarrinho(ItemPedido obj){
        carrinho.add(obj);
    }
    
}
