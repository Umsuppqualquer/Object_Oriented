package Externo.Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//A classe pedido não herda cliente, ela tem que ter um cliente

public class Pedido implements Serializable{
    private int numero;
    private static int cont = 0;
    private Date dataPedido;
    private Date dataEntrega;
    private String situação;
    private List<ItemPedido> carrinho;

    public Pedido(){
        this.numero = cont;
        cont++;
        carrinho = new ArrayList<>();
    }

    public void endPedido(){
        dataPedido = new Date();
        this.situação = "Em aberto";
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

    public void excItemCarrinho(ItemPedido i){
        carrinho.remove(i);
    }

    public void addItemCarrinho(ItemPedido obj){
        carrinho.add(obj);
    }

    public ItemPedido produtoAT(int i){
        return this.carrinho.get(i);
    }

    public int produtoSize(){
        return this.carrinho.size();
    }    

    public void showItens(){
        int i;
        System.out.println("\n========================================");
        System.out.println("           Carrinho de compras            ");
        System.out.println("========================================\n");
        for(i=0; i < this.produtoSize();i++){
                System.out.println("Descrição: " + this.produtoAT(i).getNome());
                System.out.println("- Qntd: " + this.produtoAT(i).getQuantidade() + " unidade(s)");
                System.out.printf("- Valor total: R$ %.2f\n", this.produtoAT(i).getPreco());
                System.out.println("\n----------------------------------------");
        }
        System.out.println("\n");
    }
        
}