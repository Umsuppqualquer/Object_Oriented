package T1;

public class Fornecedor {
    private String nome;
    private String descricao;
    private String telefone;
    private String email;
    private Endereco e1;

    public Fornecedor(){

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

    public void setE1(Endereco e1) { //Lembrar de atribuir na main o objeto antes de setar
        this.e1 = e1;
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
    
    public Endereco getE1() {
        return e1;
    }
}
