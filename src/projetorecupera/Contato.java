package projetorecupera;

public class Contato {
    //Declarando Atributos da classe Contato
    private String email;
    private int telefone;
    private int ddd;

    //Construtor vazio
    public Contato() {
    }

    //Criação gets da classe Contato
    public String getEmail() {
        return email;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getDdd() {
        return ddd;
    }

    //Criação Sets da classe Contato
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

}
