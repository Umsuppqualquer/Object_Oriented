package Externo.Class;

public class ItemPedido {
    private String nome;
    private int quantidade;
    private float preco;
    
    
    public ItemPedido(){

    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
