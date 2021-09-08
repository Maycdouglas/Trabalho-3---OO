package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GinasioTest {

    //Testes com o construtor da classe
    @Test
    void deveRetornarNomeInsignia()
    {
        TipoFogo fogo = new TipoFogo();
        Ginasio ginasio = new Ginasio("Insignia da Cascata","Misty", fogo);

        assertEquals("Insignia da Cascata",ginasio.getInsignia());
    }

    @Test
    void deveRetornarExcecaoNomeInsigniaObrigatorio()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Ginasio ginasio = new Ginasio("","Misty", agua);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome da Insignia obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeLiderGinasio()
    {
        TipoAgua agua = new TipoAgua();
        Ginasio ginasio = new Ginasio("Insignia da Cascata","Misty", agua);

        assertEquals("Misty", ginasio.getNomeLiderGinasio());
    }

    @Test
    void deveRetornarExcecaoNomeLiderObrigatorio()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Ginasio ginasio = new Ginasio("Insignia da Cascata","", agua);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do Lider de Ginasio obrigatorio!", e.getMessage());
        }
    }

    @Test
    void deveRetornarEspecialidade()
    {
        TipoFogo fogo = new TipoFogo();
        Ginasio ginasio = new Ginasio("Insignia da Cascata","Misty", fogo);
        assertEquals(fogo, ginasio.getEspecialidade());
    }

    @Test
    void deveRetornarExcecaoEspecialidadeObrigatorio()
    {
        try {
            Ginasio ginasio = new Ginasio("Insignia da Cascata","Misty", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Especialidade do Ginásio é obrigatória!", e.getMessage());
        }
    }

    //Testes com a operacao setNomeLiderGinasio
    @Test
    void deveRetornarNovoNomeLiderGinasio()
    {
        TipoAgua agua = new TipoAgua();
        Ginasio ginasio = new Ginasio("Insignia da Cascata","Misty", agua);
        ginasio.setNomeLiderGinasio("Brock");

        assertEquals("Brock",ginasio.getNomeLiderGinasio());
    }

    @Test
    void deveRetornarExcecaoNomeLiderGinasioObrigatorio()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Ginasio ginasio = new Ginasio("Insignia da Cascata","Misty", agua);
            ginasio.setNomeLiderGinasio("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do Lider de Ginasio obrigatorio!", e.getMessage());
        }
    }

    //Testes com batalha
    @Test
    void deveRetornarVitoria()
    {
        TipoAgua agua = new TipoAgua();
        TipoGrama grama = new TipoGrama();
        Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
        Pokemon pokemon = new Pokemon("Squirtle", agua);
        Pokemon pokemon2 = new Pokemon("Bulbasaur", grama);
        ginasio.getLider().setPokemon(pokemon);

        assertEquals(2, ginasio.batalha(pokemon2));
    }

    @Test
    void deveRetornarDerrota()
    {
        TipoAgua agua = new TipoAgua();
        TipoFogo fogo = new TipoFogo();
        Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
        Pokemon pokemon = new Pokemon("Squirtle", agua);
        Pokemon pokemon2 = new Pokemon("Bulbasaur", fogo);
        ginasio.getLider().setPokemon(pokemon);

        assertEquals(0, ginasio.batalha(pokemon2));
    }

    @Test
    void deveRetornarEmpate()
    {
        TipoAgua agua = new TipoAgua();
        Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
        Pokemon pokemon = new Pokemon("Squirtle", agua);
        Pokemon pokemon2 = new Pokemon("Squirtle", agua);
        ginasio.getLider().setPokemon(pokemon);

        assertEquals(1, ginasio.batalha(pokemon2));
    }

    @Test
    void deveRetornarLiderGinasioSemPokemonParaBatalha()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
            Pokemon pokemon = new Pokemon("Squirtle", agua);
            ginasio.batalha(pokemon);
        } catch (NullPointerException e){
            assertEquals("Lider de Ginasio sem Pokemon", e.getMessage());
        }
    }

    //Testes com getPokemon
    @Test
    void deveRetornarPokemonLiderGinasio()
    {
        TipoAgua agua = new TipoAgua();
        Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
        Pokemon pokemon = new Pokemon("Squirtle", agua);
        ginasio.getLider().setPokemon(pokemon);

        assertEquals(pokemon, ginasio.getLider().getPokemon());
    }

    @Test
    void deveRetornarExcecaoLiderGinasioSemPokemon()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
        } catch (NullPointerException e){
            assertEquals("Lider de Ginasio sem Pokemon", e.getMessage());
        }
    }

    //Testes com setPokemon
    @Test
    void deveRetornarExcecaoPokemonTipoDiferenteEspecialidade()
    {
        try {
            TipoAgua agua = new TipoAgua();
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
            Pokemon pokemon = new Pokemon("Squirtle", fogo);
            ginasio.getLider().setPokemon(pokemon);
        } catch (IllegalArgumentException e){
            assertEquals("O tipo do Pokemon nao corresponde com a especialidade do Lider de Ginasio", e.getMessage());
        }
    }
}