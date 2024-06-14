package T1.Class;

import java.util.ArrayList;

public class Fornecedor extends Cadastro{
	private String descricao;
	private ArrayList<Produto> itens;

	public Fornecedor() {
		this.itens = new ArrayList<>();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int sizeProd(){
		return this.itens.size();
	}

	public Produto prodAt(int index){
		return this.itens.get(index);
	}

	public void addItem(Produto item){
		this.itens.add(item);
	}

	public void excItem(Produto item){
		this.itens.remove(item);
	}

	@Override //verifica se é igual
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor aux = (Fornecedor) obj;
		if (this.getNome().contains(aux.getNome()))
			return false;
		return true;
	}
}
