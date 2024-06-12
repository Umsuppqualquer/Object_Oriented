package T1;

import java.util.*;

import T1.Class.*;

public class Shop {

    private ArrayList<Fornecedor> l1;
    private ArrayList<Produto> p1;

    public Shop(){
        this.l1 = new ArrayList<>();
        this.p1 = new ArrayList<>();
    }

    public ArrayList<Fornecedor> getListForne() {
        return l1;
    }

    public ArrayList<Produto> getListProd() {
        return p1;
    }

    public void addForne(Fornecedor f1){
        l1.add(f1);
    }

    public void excForne(Fornecedor f1){
        l1.remove(f1);
    }
}
