package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Golpe {
    private String nome;
    private final Tipo tipagem;
    private List<Pokemon> listaPokemon; //nessa lista ficam os Pokémon que podem aprender tal golpe

    public Golpe(String nome, Tipo tipo) {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome do golpe é obrigatorio!");
        }
        if(tipo == null)
        {
            throw new IllegalArgumentException("Tipo do golpe é obrigatorio!");
        }
        this.nome = nome;
        this.tipagem = tipo;
        tipo.adicionarGolpe(this);
        listaPokemon = new ArrayList<Pokemon>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome do golpe é obrigatorio!");
        }
        this.nome = nome;
    }

    public Tipo getTipagem() {
        return tipagem;
    }

    public List<Pokemon> getListaPokemon() {
        if(listaPokemon.size() < 1)
        {
            throw new NullPointerException("Lista de Pokémon que aprendem esse golpe é vazia!");
        }
        return listaPokemon;
    }

    public void adicionarPokemon(Pokemon pokemon) {
        if(pokemon == null)
        {
            throw new IllegalArgumentException("Um Pokémon válido é obrigatorio!");
        }
        if(pokemon.getTipagem() != this.tipagem)
        {
            throw new IllegalArgumentException("Pokémon deve ter a mesma tipagem do golpe!");
        }
        this.listaPokemon.add(pokemon);
        if( !(pokemon.verificarGolpeAprendido(this)) ) {
            pokemon.aprenderGolpe(this);
        }
    }

}
