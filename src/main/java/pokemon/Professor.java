package pokemon;

import java.util.List;

public class Professor extends Pessoa{

    public Professor(String nome) {
        super(nome);
    }

    public Pokemon entregarPokemonInicial(String nome, Tipo tipo)
    {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome do Pokemon é obrigatorio!");
        }
        if(tipo == null)
        {
            throw new IllegalArgumentException("Tipo do Pokemon é obrigatorio!");
        }
        return new Pokemon(nome,tipo);
    }

    public Pokedex entregarPokedex()
    {
        return new Pokedex();
    }

}
