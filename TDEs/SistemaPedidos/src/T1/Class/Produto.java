package T1.Class;

public class Produto {
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

	public Produto(String nome, String desc, Fornecedor forneco) {
		this.nome = nome;
		this.descproduto = desc;
		this.forneco = forneco;
		this.id = cont;
		cont++;
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

	public Estoque getQuantidade() {
		return quantidade;
	}

	public int getId() {
		return id;
	}

}
