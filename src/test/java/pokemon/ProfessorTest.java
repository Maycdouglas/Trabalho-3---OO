package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    //Testes com o construtor da classe
    @Test
    void deveRetornarNomeProfessor()
    {
        Professor professor = new Professor("Carvalho");

        assertEquals("Carvalho",professor.getNome());
    }

    @Test
    void deveRetornarExcecaoNomeProfessorVazio()
    {
        try {
            Professor professor = new Professor("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    //Testes com entregarPokemonInicial
    @Test
    void deveRetornarPokemonEscolhido()
    {
        TipoAgua tipo = new TipoAgua();
        Professor professor = new Professor("Carvalho");
        Pokemon pokemon = professor.entregarPokemonInicial("Charmander",tipo);

        assertEquals("Charmander", pokemon.getNome());
        assertEquals(tipo, pokemon.getTipagem());
    }

    @Test
    void deveRetornarExececaoNomePokemonVazio()
    {
        try {
            TipoAgua tipo = new TipoAgua();
            Professor professor = new Professor("Carvalho");
            Pokemon pokemon = professor.entregarPokemonInicial("",tipo);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do Pokemon é obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoTipoPokemonNulo()
    {
        try {
            Professor professor = new Professor("Carvalho");
            professor.entregarPokemonInicial("Charmander",null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo do Pokemon é obrigatorio!", e.getMessage());
        }
    }

    //Testes com entregarPokedex
    @Test
    void deveRetornarPokedex()
    {
        Professor professor = new Professor("Carvalho");
        assertNotNull(professor.entregarPokedex());
    }
}