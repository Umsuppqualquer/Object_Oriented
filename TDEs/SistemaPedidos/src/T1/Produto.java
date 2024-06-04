package T1;

public class Produto {
    private String nome;
    private String descproduto;
    private static int id;
    private Fornecedor suplyer;
    private Estoque qntd;

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

    public static int getId() {
        return id;
    }

    
}
