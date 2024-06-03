package T1;

public class Estoque {
    private int quantidade;
    private double preço;

    public Estoque(){

    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreço() {
        return preço;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
}
