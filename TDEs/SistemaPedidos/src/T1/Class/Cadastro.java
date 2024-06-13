package T1.Class;
public class Cadastro {

    private String nome;
    private String telefone;
    private String email;
    private Endereco local;

    public Cadastro (){

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getLocal() {
        return local;
    }
    
}
