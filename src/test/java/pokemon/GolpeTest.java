package pokemon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GolpeTest {

    //Testes com o construtor da classe
    @Test
    void deveRetornarNomeGolpe()
    {
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);

        assertEquals("Jato de Agua",golpe.getNome());
    }

    @Test
    void deveRetornarExcecaoNomeGolpeVazio()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Golpe golpe = new Golpe("", agua);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do golpe é obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarTipoGolpe()
    {
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);

        assertEquals(agua,golpe.getTipagem());
    }

    @Test
    void deveRetornarExcecaoTipoNulo()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Golpe golpe = new Golpe("Jato de Agua", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo do golpe é obrigatorio!", e.getMessage());
        }
    }

    //Testes com o setNome
    @Test
    void deveRetornarNomeGolpeAlterado()
    {
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);
        golpe.setNome("Jato de Bolhas");

        assertEquals("Jato de Bolhas",golpe.getNome());
    }

    @Test
    void deveRetornarExcecaoNomeGolpeVazioAposAlteracao()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Golpe golpe = new Golpe("Jato de Agua", agua);
            golpe.setNome("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do golpe é obrigatorio!", e.getMessage());
        }
    }

    //Testes com o getListaPokemon
    @Test
    void deveRetornarListaPokemonComUmPokemon() {

        List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);
        Pokemon pokemon = new Pokemon ("Charmander", agua);
        golpe.adicionarPokemon(pokemon);

        listaPokemon = golpe.getListaPokemon();

        assertEquals(listaPokemon, golpe.getListaPokemon());;
    }

    @Test
    void deveRetornarListaPokemonComMuitosPokemon() {

        List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);
        Pokemon pokemon = new Pokemon ("Charmander", agua);
        Pokemon pokemon2 = new Pokemon ("Squirtle", agua);
        Pokemon pokemon3 = new Pokemon ("Bulbasaur", agua);

        golpe.adicionarPokemon(pokemon);
        golpe.adicionarPokemon(pokemon2);
        golpe.adicionarPokemon(pokemon3);

        listaPokemon = golpe.getListaPokemon();

        assertEquals(listaPokemon, golpe.getListaPokemon());;
    }

    @Test
    void deveRetornarExcecaoListaPokemonVazia() {
        try {
            List<Pokemon> listaPokemon = new ArrayList<Pokemon>();
            TipoAgua agua = new TipoAgua();
            Golpe golpe = new Golpe("Jato de Agua", agua);
            listaPokemon = golpe.getListaPokemon();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Lista de Pokémon que aprendem esse golpe é vazia!", e.getMessage());
        }
    }

    //Testes com o adicionarPokemon
    @Test
    void deveRetornarExcecaoPokemonNulo() {

        try {
            TipoAgua agua = new TipoAgua();
            Golpe golpe = new Golpe("Jato de Agua", agua);
            golpe.adicionarPokemon(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Um Pokémon válido é obrigatorio!", e.getMessage());
        }
    }
    @Test
    void deveRetornarExcecaoPokemonTipoDiferente() {

        try {
            TipoAgua agua = new TipoAgua();
            TipoFogo fogo = new TipoFogo();
            Golpe golpe = new Golpe("Jato de Agua", agua);
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            golpe.adicionarPokemon(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pokémon deve ter a mesma tipagem do golpe!", e.getMessage());
        }
    }

    @Test
    void deveRetornarPokemonAdicionado() {
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);
        Pokemon pokemon = new Pokemon("Charmander", agua);
        golpe.adicionarPokemon(pokemon);

        assertTrue(golpe.getListaPokemon().contains(pokemon));
    }

    //Teste com o bidirecionamento da relacao com tipo
    @Test
    void deveRetornarGolpeNaListaTipo() {
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);
        Pokemon pokemon = new Pokemon("Charmander", agua);
        golpe.adicionarPokemon(pokemon);

        assertTrue(agua.getListaGolpes().contains(golpe));
    }

}