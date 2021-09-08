package pokemon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnfermeiraTest {

    //Testes com o construtor da classe
    @Test
    void deveRetornarNomeEnfermeira()
    {
        Enfermeira enfermeira = new Enfermeira("Joy");

        assertEquals("Joy",enfermeira.getNome());
    }

    @Test
    void deveRetornarExcecaoNomeEnfermeiraVazio()
    {
        try {
            Enfermeira enfermeira = new Enfermeira("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    //Testes com operação CurarPokemon
    @Test
    void deveRetornarExcecaoListaPokemonVazia()
    {
        try {
            Enfermeira enfermeira = new Enfermeira("Joy");
            List<Pokemon>  listaPokemon = new ArrayList<Pokemon>();
            enfermeira.curarPokemon(listaPokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Lista de Pokemon vazia, insira ao menos um Pokemon!", e.getMessage());
        }

    }

    @Test
    void deveRecuperarPontosVidaUmPokemon()
    {
        TipoFogo fogo = new TipoFogo();
        Enfermeira enfermeira = new Enfermeira("Joy");
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        List<Pokemon>  listaPokemon = new ArrayList<Pokemon>();
        listaPokemon.add(pokemon);

        pokemon.setPontosVida(0);

        enfermeira.curarPokemon(listaPokemon);

        assertEquals(100, pokemon.getPontosVida());
    }

    @Test
    void deveRecuperarPontosVidaMuitosPokemon()
    {
        TipoFogo fogo = new TipoFogo();
        Enfermeira enfermeira = new Enfermeira("Joy");
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Pokemon pokemon2 = new Pokemon("Squirtle", fogo);
        Pokemon pokemon3 = new Pokemon("Bulbasaur", fogo);

        List<Pokemon>  listaPokemon = new ArrayList<Pokemon>();
        listaPokemon.add(pokemon);
        listaPokemon.add(pokemon2);
        listaPokemon.add(pokemon3);

        pokemon.setPontosVida(0);
        pokemon2.setPontosVida(0);
        pokemon3.setPontosVida(0);

        enfermeira.curarPokemon(listaPokemon);

        assertEquals(100, pokemon.getPontosVida());
        assertEquals(100, pokemon2.getPontosVida());
        assertEquals(100, pokemon3.getPontosVida());
    }

}