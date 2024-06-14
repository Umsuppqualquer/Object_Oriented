package Geral;

//Ajustar o get para que retorne somente um objeto só, não a lista de objetos;

import java.util.*;

import T1.Class.*;

public class Shop {

    private List<Fornecedor> supplyer;
    private List<Produto> product;

    public Shop(){
        this.supplyer = new ArrayList<>();
        this.product = new ArrayList<>();
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

    public int sizeForne(){
        return this.supplyer.size();
    }

    public int sizeProd(){
        return this.product.size();
    }

    public Fornecedor forneAt(int index){
        return this.supplyer.get(index);
    }

    public Produto prodAt(int index){
        return this.product.get(index);
    }
}
