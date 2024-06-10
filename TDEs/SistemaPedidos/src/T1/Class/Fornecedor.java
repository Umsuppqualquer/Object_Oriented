package T1.Class;

//lista de produto, com os produtos

public class Fornecedor {
	private String nome;
	private String descricao;
	private String telefone;
	private String email;
	private Endereco e1;

	public Fornecedor(String nome, String descricao, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.e1 = endereco;
	}

	public Fornecedor() {
		this.e1 = new Endereco();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnd(Endereco end) {
		this.e1 = end;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public Endereco getEnd() {
		return e1;
	}

	@Override
	public String toString() {
		return "Fornecedor{" + "nome='" + nome + '\'' + ", descricao='" + descricao + '\'' + ", telefone='" + telefone
				+ '\'' + ", email='" + email + '\'' + '}';
	}
}
