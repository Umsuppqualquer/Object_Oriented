package Geral;

//Ajustar o get para que retorne somente um objeto só, não a lista de objetos;

import java.util.*;

import Interno.Class.*;
import Externo.Class.*;

public class Shop {

    private List<Fornecedor> supplyer;
    private List<Produto> product;
    private List<Cliente> users;

    public Shop(){
        this.supplyer = new ArrayList<>();
        this.product = new ArrayList<>();
        this.users = new ArrayList<>();
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

    public void addUser(Cliente u1){
        this.users.add(u1);
    }

    public void excUser(Cliente u1){
        this.users.remove(u1);
    }

    public int sizeForne(){
        return this.supplyer.size();
    }

    public int sizeProd(){
        return this.product.size();
    }

    public int sizeUser(){
        return this.users.size();
    }

    public Fornecedor forneAt(int index){
        return this.supplyer.get(index);
    }

    public Produto prodAt(int index){
        return this.product.get(index);
    }

    public Cliente userAt(int index){
        return this.users.get(index);
    }

    public void prodSimp() {
		char a = '\n';
		System.out.println("\n----------------------------------------");
		for (int i = 0; i < this.product.size(); i++) {
			if (this.product.get(i).getNome().charAt(0) == a) {
				System.out.println(i + "° - " + product.get(i).getNome()+"\n");
			} else {
				System.out.println(product.get(i).getNome().charAt(0));
				System.out.println(i + "° - " + product.get(i).getNome()+"\n");
				System.out.println("\n----------------------------------------");
			}
		}
		System.out.println("\n");
	}

    public void fornSimp() {
		char a = '\n';
		System.out.println("\n----------------------------------------");
		for (int i = 0; i < this.supplyer.size(); i++) {
			if (this.supplyer.get(i).getNome().charAt(0) == a) {
				System.out.println(i + "° - " + this.supplyer.get(i).getNome()+"\n");
			} else {
				System.out.println(this.supplyer.get(i).getNome().charAt(0));
				System.out.println(i + "° - " + this.supplyer.get(i).getNome()+"\n");
				System.out.println("\n----------------------------------------");
			}
		}
		System.out.println("\n");
	}

    public boolean recSenha(String key){
        for(int i = 0; i < this.users.size(); i++){
            if(this.users.get(i).getNome().equalsIgnoreCase(key) || this.users.get(i).getEmail().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }
}
