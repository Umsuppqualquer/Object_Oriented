package T1.Class;

public class Produto {
	private String nome;
	private String descproduto;
	private static int cont = 0;
	private int id;
	private Fornecedor suplyer;
	private Estoque qntd;

	public Produto() {
		this.id = cont;
		cont++;
	}

	public Produto(String nome, String desc, Fornecedor suplyer) {
		this.nome = nome;
		this.descproduto = desc;
		this.suplyer = suplyer;
		this.id = cont;
		cont++;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescproduto(String descproduto) {
		this.descproduto = descproduto;
	}

	public void setSuplyer(Fornecedor suplyer) {
		this.suplyer = suplyer;
	}

	public void setQntd(Estoque qntd) {
		this.qntd = qntd;
	}

	public String getNome() {
		return nome;
	}

	public String getDescproduto() {
		return descproduto;
	}

	public Fornecedor getSuplyer() {
		return suplyer;
	}

	public Estoque getQntd() {
		return qntd;
	}

	public int getId() {
		return id;
	}

}
