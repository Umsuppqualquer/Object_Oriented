package Externo.Class;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Geral.Contador;

//A classe pedido não herda cliente, ela tem que ter um cliente

public class Pedido implements Serializable{
    private int numero;
    private static int inicio = 1000;
    private Date dataPedido;
    private Date dataEntrega;
    private String situação;
    private List<ItemPedido> carrinho;

    public Pedido(){
        carrinho = new ArrayList<>();
    }

    public Pedido(Contador cont){
        cont.incrementar();
        carrinho = new ArrayList<>();
    }

    public void endPedido(Contador cont){
        this.numero = inicio + cont.getValor();
        dataPedido = new Date();
        this.situação = "Em aberto";
        cont.salvarContador();
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

    public void fullOrder(SimpleDateFormat simple){
        System.out.println("========================================");
        System.out.println("Id: " + this.getNumero());
        System.out.println("- Data do pedido: " + simple.format(this.getDataPedido()));
        System.out.printf("- Situação: " + this.getSituação());
		System.out.println("\n========================================");
		for(int i = 0; i < this.produtoSize(); i++){
            System.out.println("Nome: " + this.produtoAT(i).getNome());
            System.out.println("Qntd: " + this.produtoAT(i).getQuantidade() + "un  / Valor: R$" + this.produtoAT(i).getPreco());
            if(i < this.produtoSize()-1){
                System.out.println("\n----------------------------------------\n");
            } 
		}
        System.out.println("========================================\n");
	}
}