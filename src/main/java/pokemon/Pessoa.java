package pokemon;

public abstract class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome obrigatorio!");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome obrigatorio!");
        }
        this.nome = nome;
    }
}
