package projetorecupera;

//PessoaJuridica classe filha da Pessoa
import Classe_Pessoa.Pessoa;

public class PessoaJuridica extends Pessoa {

    //Declarando atributos Pessoa juridica
    private int cnpj;
    private String tipo;

    //Construtor vazio
    public PessoaJuridica() {
    }

    //Criação Gets da classe PessoaJuridica
    public int getCnpj() {
        return cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    //Criação Sets da classe PessoaJuridica
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
