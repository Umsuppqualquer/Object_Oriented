package Interno.Class;

import java.io.Serializable;

public class Produto implements Serializable{
	private String nome;
	private String descproduto;
	private static int cont = 0;
	private int id;
	private Fornecedor forneco;
	private Estoque quantidade;

	public Produto() {
		this.id = cont;
		cont++;
	}

	public Produto(String nome, String descproduto, Fornecedor forneco, Estoque quantidade) {
        this.nome = nome;
        this.descproduto = descproduto;
        this.forneco = forneco;
		this.quantidade = quantidade;
        this.id = ++cont;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescproduto(String descproduto) {
		this.descproduto = descproduto;
	}

	public void setFornecedor(Fornecedor suplyer) {
		this.forneco = suplyer;
	}

	public void setQuantidade(Estoque qntd) {
		this.quantidade = qntd;
	}

	public String getNome() {
		return nome;
	}

	public String getDescproduto() {
		return descproduto;
	}

	public Fornecedor getFornecedor() {
		return forneco;
	}

	public Estoque getEstoque() {
		return quantidade;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto aux = (Produto) obj;
		if (this.getNome().contains(aux.getNome()))
			return false;
		return true;
	}
}
