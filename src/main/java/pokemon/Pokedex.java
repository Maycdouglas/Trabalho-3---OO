package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private static List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
    private List<Pokemon> listaPokemonTreinador = new ArrayList<Pokemon>();

    public static void adicionarPokemon(Pokemon pokemon) {

        //verifica se o Pokémon já foi registrado, percorrendo a lista
        if(Pokedex.calcularPokemonExistentes() > 0 && Pokedex.verificarPokemonRegistrado(pokemon))
        {
            throw new IllegalArgumentException("Pokemon ja registrado na Pokedex");
        }

        listaPokemon.add(pokemon);
    }

    public void adicionarPokemonTreinador(Pokemon pokemon) {
        if(listaPokemonTreinador.contains(pokemon))
        {
            throw new IllegalArgumentException("Pokemon ja capturado!");
        }
        listaPokemonTreinador.add(pokemon);
    }

    public static int calcularPokemonExistentes() {
        return listaPokemon.size();
    }

    public int calcularPokemonCapturados() {
        return listaPokemonTreinador.size();
    }

    public static boolean verificarPokemonRegistrado(Pokemon pokemon)
    {
        int contador = 0;
        Pokemon pokemonAuxiliar;

        while(contador < listaPokemon.size())
        {
            pokemonAuxiliar = listaPokemon.get(contador);
            if(pokemon.getNome().equals(pokemonAuxiliar.getNome()))
            {
                return true;
            }
            contador++;
        }

        return false;
    }

    public static void zerarListaPokemon() {
        listaPokemon.clear();
    }
}
