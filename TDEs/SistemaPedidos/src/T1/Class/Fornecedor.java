package T1.Class;

import java.util.ArrayList;

public class Fornecedor {
	private String nome;
	private String descricao;
	private String telefone;
	private String email;
	private Endereco endereco;
	private ArrayList<Produto> itens;


	public Fornecedor(String nome, String descricao, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.itens = new ArrayList<>();
	}

	public Fornecedor() {
		this.endereco = new Endereco();
		this.itens = new ArrayList<>();
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
		this.endereco = end;
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
		return endereco;
	}

	public ArrayList<Produto> getItens(){
		return itens;
	}

	public void addItem(Produto item){
		itens.add(item);
	}

	public void excItem(Produto item){
		int esc = -1;
		for(int i = 0; i < this.itens.size();i++){
			if (item == this.itens.get(i)){
				esc = i;
				break;
			}
		}
		if (esc < 0){
			System.out.println("Item não esta presente neste fornecedor");
		}
		else{
			this.itens.remove(esc);
		}
	}
}
