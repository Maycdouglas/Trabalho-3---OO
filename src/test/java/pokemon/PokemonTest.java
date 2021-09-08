package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    //Testes com o construtor da classe
    @Test
    void deveRetornarNomePokemon()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        assertEquals("Charmander",pokemon.getNome());
    }

    @Test
    void deveRetornarExcecaoNomePokemonVazio()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("", fogo);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoTipagemPokemonNula()
    {
        try {
            Pokemon pokemon = new Pokemon("Charmander", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo do Pokemon é obrigatorio!", e.getMessage());
        }
    }

    //Testes com setNome
    @Test
    void deveRetornarNomePokemonAlterado()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        pokemon.setNome("Charmeleon");

        assertEquals("Charmeleon", pokemon.getNome());
    }

    @Test
    void deveRetornarExcecaoNomePokemonAlteradoVazio()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            pokemon.setNome("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    //Testes com getTreinador
    @Test
    void deveRetornarTreinadorPokemon()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        TreinadorComum treinador = new TreinadorComum("Ash");

        pokemon.setTreinador(treinador);

        assertEquals(treinador, pokemon.getTreinador());
    }

    //Testes com aprenderGolpe
    @Test
    void deveRetornarGolpeAprendido() //esse teste também serve para o verificarGolpeAprendido retornando True
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Golpe golpe = new Golpe("Lança Chamas", fogo);
        pokemon.aprenderGolpe(golpe);

        assertTrue(pokemon.verificarGolpeAprendido(golpe));
    }

    @Test
    void deveRetornarExcecaoGolpeTipoDiferente()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            TipoAgua agua = new TipoAgua();
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            Golpe golpe = new Golpe("Jato de Agua", agua);
            pokemon.aprenderGolpe(golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Insira um golpe com a mesma tipagem do Pokemon", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoGolpeAprendido()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            Golpe golpe = new Golpe("Brasas", fogo);
            pokemon.aprenderGolpe(golpe);
            pokemon.aprenderGolpe(golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Golpe já foi aprendido!", e.getMessage());
        }
    }

    //Teste com o bidirecionamento da relação com Golpe
    @Test
    void deveRetornarPokemonNaListaGolpe()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Golpe golpe = new Golpe("Lança Chamas", fogo);
        pokemon.aprenderGolpe(golpe);

        assertTrue(golpe.getListaPokemon().contains(pokemon));
    }

    //Teste com verificarGolpeAprendido retornando False
    @Test
    void deveRetornarGolpeAprendidoFalse()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Golpe golpe = new Golpe("Brasas", fogo);

        assertFalse(pokemon.verificarGolpeAprendido(golpe));
    }

}