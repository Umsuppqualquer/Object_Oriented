package Interno.Class;

import java.io.Serializable;

public class Estoque implements Serializable {
	private int quantidade;
	private double preco;

	public Estoque() {

	}

	public Estoque(int quantidade, double preco){
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

}
