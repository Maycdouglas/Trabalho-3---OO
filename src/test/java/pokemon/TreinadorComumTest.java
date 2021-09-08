package pokemon;

import org.junit.jupiter.api.Test;

import java.beans.PropertyDescriptor;

import static org.junit.jupiter.api.Assertions.*;

class TreinadorComumTest {

    //Testes com o construtor da classe
    @Test
    void deveRetornarNomeTreinadorComum()
    {
        TreinadorComum treinador = new TreinadorComum("Ash");

        assertEquals("Ash",treinador.getNome());
    }

    @Test
    void deveRetornarExcecaoNomeTreinadorComumVazio()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome obrigatorio!", e.getMessage());
        }
    }

    //Teste com a operacao recuperarTime
    @Test
    void deveRetornarVidaPokemonCheia()
    {
        Enfermeira enfermeira = new Enfermeira("Joy");
        TipoFogo fogo = new TipoFogo();
        TreinadorComum treinador = new TreinadorComum("Ash");

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        treinador.getListaPokemon().get(0).setPontosVida(50);

        treinador.recuperarTime(enfermeira);

        assertEquals(100, treinador.getListaPokemon().get(0).getPontosVida());
    }

    //Testes com a operacao capturar Pokemon
    @Test
    void deveRetornarPokemonCapturado()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        TreinadorComum treinador = new TreinadorComum("Ash");

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        treinador.capturarPokemon(pokemon);

        assertTrue(treinador.getListaPokemon().contains(pokemon));
    }

    @Test
    void deveRetornarExcecaoPokemonCapturadoPeloTreinador()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);

            TreinadorComum treinador = new TreinadorComum("Ash");

            Professor professor = new Professor("Carvalho");
            treinador.receberPokedex(professor);
            treinador.escolherPokemonInicial(professor,"Charmander",fogo);

            treinador.capturarPokemon(pokemon);
            treinador.capturarPokemon(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Este Pokemon ja foi capturado por voce!", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoPokemonCapturadoPorOutroTreinador()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);

            TreinadorComum treinador = new TreinadorComum("Ash");
            TreinadorComum treinador2 = new TreinadorComum("Gary");

            Professor professor = new Professor("Carvalho");
            treinador.receberPokedex(professor);
            treinador.escolherPokemonInicial(professor,"Charmander",fogo);
            treinador2.receberPokedex(professor);
            treinador2.escolherPokemonInicial(professor,"Charmander",fogo);

            treinador2.capturarPokemon(pokemon);
            treinador.capturarPokemon(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Este Pokemon ja foi capturado por outro treinador!", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoTreinadorSemPokemonInicial()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);

            TreinadorComum treinador = new TreinadorComum("Ash");
            Professor professor = new Professor("Carvalho");
            treinador.receberPokedex(professor);
            treinador.capturarPokemon(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Treinador deve escolher um inicial antes!", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoTreinadorSemPokedex()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);

            TreinadorComum treinador = new TreinadorComum("Ash");
            treinador.capturarPokemon(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Treinador deve receber a Pokedex antes!", e.getMessage());
        }

    }

    @Test
    void deveRetornarPokemonCapturadoFoiRegistradoPokedex()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        TreinadorComum treinador = new TreinadorComum("Ash");

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        treinador.capturarPokemon(pokemon);

        assertTrue(Pokedex.verificarPokemonRegistrado(pokemon));
    }

    //Testes com operacao ensinarGolpe
    @Test
    void deveRetornarGolpeEnsinado()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Golpe golpe = new Golpe("Lança Chamas", fogo);

        TreinadorComum treinador = new TreinadorComum("Ash");
        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);
        treinador.capturarPokemon(pokemon);

        treinador.ensinarGolpe(0,golpe);

        assertTrue(treinador.getListaPokemon().get(0).getListaGolpes().contains(golpe));
    }

    @Test
    void deveRetornarExcecaoIndiceMenorQueZero()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            Golpe golpe = new Golpe("Lança Chamas", fogo);

            TreinadorComum treinador = new TreinadorComum("Ash");
            treinador.ensinarGolpe(-1,golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Insira um numero de 0 ao total de Pokemon capturados", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoIndiceMaiorQueTotalCapturados()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            Golpe golpe = new Golpe("Lança Chamas", fogo);

            TreinadorComum treinador = new TreinadorComum("Ash");

            treinador.ensinarGolpe(0,golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Insira um numero de 0 ao total de Pokemon capturados", e.getMessage());
        }
    }

    //Teste com operacao getPokedex

    @Test
    void deveRetornarExcecaoPokedexNula()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("Ash");
            treinador.getPokedex();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Treinador sem Pokedex", e.getMessage());
        }
    }

    //Testes com operacao receberPokedex
    @Test
    void deveRetornarPokedexRecebida() //este teste serve para o getPokedex tambem
    {
        TreinadorComum treinador = new TreinadorComum("Ash");
        Professor professor = new Professor("Carvalho");

        treinador.receberPokedex(professor);

        assertNotNull(treinador.getPokedex());
    }

    @Test
    void deveRetornarExcecaoPokedexJaRecebida()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("Ash");
            Professor professor = new Professor("Carvalho");

            treinador.receberPokedex(professor);
            treinador.receberPokedex(professor);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Treinador já possui uma Pokedex", e.getMessage());
        }
    }

    //Testes com operacao escolherPokemonInicial
    @Test
    void deveRetornarPokemonInicialEscolhido()
    {
        TipoFogo fogo = new TipoFogo();

        TreinadorComum treinador = new TreinadorComum("Ash");

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        assertEquals(1, treinador.getListaPokemon().size());
    }

    @Test
    void deveRetornarPokemonInicialRegistradoPokedex()
    {
        TipoFogo fogo = new TipoFogo();
        Pokedex.zerarListaPokemon();

        TreinadorComum treinador = new TreinadorComum("Ash");

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        Pokemon pokemon = treinador.getListaPokemon().get(0);

        assertTrue(Pokedex.verificarPokemonRegistrado(pokemon));
    }

    //Teste com operacao registrarPokemon
    @Test
    void deveRetornarPokemonRegistrado()
    {
        Pokedex.zerarListaPokemon();
        TipoFogo fogo = new TipoFogo();
        TreinadorComum treinador = new TreinadorComum("Ash");
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        treinador.registrarPokemon(pokemon);

        assertTrue(Pokedex.verificarPokemonRegistrado(pokemon));
    }

    //Teste com desafiarGinasio
    @Test
    void deveRetornarVitoria()
    {
        TipoFogo fogo = new TipoFogo();
        TipoGrama grama = new TipoGrama();
        Pokemon pokemon = new Pokemon("Bulbasaur",grama);
        TreinadorComum treinador = new TreinadorComum("Ash");

        Ginasio ginasio = new Ginasio("Insignia da Grama", "Grass", grama);

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        ginasio.getLider().setPokemon(pokemon);

        treinador.desafiarGinasio(ginasio,0);

        assertEquals(1, treinador.getQntdInsignias());

    }
    @Test
    void deveRetornarEmpate()
    {
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander",fogo);
        TreinadorComum treinador = new TreinadorComum("Ash");

        Ginasio ginasio = new Ginasio("Insignia da Grama", "Grass", fogo);

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        ginasio.getLider().setPokemon(pokemon);

        treinador.desafiarGinasio(ginasio,0);

        assertEquals(50, treinador.getListaPokemon().get(0).getPontosVida());
    }
    @Test
    void deveRetornarDerrota()
    {
        TipoFogo fogo = new TipoFogo();
        TipoAgua agua = new TipoAgua();
        Pokemon pokemon = new Pokemon("Squirtle", agua);
        TreinadorComum treinador = new TreinadorComum("Ash");

        Ginasio ginasio = new Ginasio("Insignia da Grama", "Grass", agua);

        Professor professor = new Professor("Carvalho");
        treinador.receberPokedex(professor);
        treinador.escolherPokemonInicial(professor,"Charmander",fogo);

        ginasio.getLider().setPokemon(pokemon);

        treinador.desafiarGinasio(ginasio,0);

        assertEquals(0, treinador.getListaPokemon().get(0).getPontosVida());
    }
    @Test
    void deveRetornarExcecaoTreinadorSemPokemon()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("Ash");
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insiginia do Fogo", "Blame", fogo);
            treinador.desafiarGinasio(ginasio,0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Treinador não possui Pokémon", e.getMessage());
        }
    }
    @Test
    void deveRetornarExcecaoIndiceInvalido()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("Ash");
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insiginia do Fogo", "Blame", fogo);
            Professor professor = new Professor("Carvalho");
            treinador.receberPokedex(professor);
            treinador.escolherPokemonInicial(professor,"Charmander",fogo);
            treinador.desafiarGinasio(ginasio,1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Indice invalido!", e.getMessage());
        }
    }
    @Test
    void deveRetornarExcecaoIndiceInvalidoNegativo()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("Ash");
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insiginia do Fogo", "Blame", fogo);
            Professor professor = new Professor("Carvalho");
            treinador.receberPokedex(professor);
            treinador.escolherPokemonInicial(professor,"Charmander",fogo);
            treinador.desafiarGinasio(ginasio,-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Indice invalido!", e.getMessage());
        }
    }
    @Test
    void deveRetornarExcecaoPokemonSemPontosVida()
    {
        try {
            TreinadorComum treinador = new TreinadorComum("Ash");
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insiginia do Fogo", "Blame", fogo);
            Professor professor = new Professor("Carvalho");
            treinador.receberPokedex(professor);
            treinador.escolherPokemonInicial(professor,"Charmander",fogo);

            treinador.getListaPokemon().get(0).setPontosVida(0);

            treinador.desafiarGinasio(ginasio,0);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Pokemon sem Pontos de Vida para batalhar. Leve-o até a enfermeira!", e.getMessage());
        }
    }
}