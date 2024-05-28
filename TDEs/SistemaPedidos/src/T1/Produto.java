package T1;

public class Produto {
    private String nome;
    private String descproduto;
    private Fornecedor suplyer;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescproduto(String descproduto) {
        this.descproduto = descproduto;
    }

    public void setSuplyer(Fornecedor suplyer) {
        this.suplyer = suplyer;
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
    

    
}
