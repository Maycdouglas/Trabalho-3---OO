package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokedexTest {

    //Testes com o adicionarPokemon e calcularPokemonExistentes
    @Test
    void deveRetornarListaPokemonVazia() {
        Pokedex pokedex = new Pokedex();
        Pokedex.zerarListaPokemon();

        assertEquals(0, Pokedex.calcularPokemonExistentes());
    }

    @Test
    void deveRetornarListaPokemonComUmPokemon() {
        Pokedex pokedex = new Pokedex();
        Pokedex.zerarListaPokemon();

        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Pokedex.adicionarPokemon(pokemon);

        assertEquals(1, Pokedex.calcularPokemonExistentes());
    }

    @Test
    void deveRetornarListaPokemonComMuitosPokemon() {
        Pokedex pokedex = new Pokedex();
        Pokedex.zerarListaPokemon();
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Pokemon pokemon2 = new Pokemon("Squirtle", fogo);
        Pokedex.adicionarPokemon(pokemon);
        Pokedex.adicionarPokemon(pokemon2);

        assertEquals(2, Pokedex.calcularPokemonExistentes());
    }

    @Test
    void deveRetornarExcecaoPokemonJaRegistrado() {
        try {
            Pokedex pokedex = new Pokedex();
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);

            Pokedex.adicionarPokemon(pokemon);
            Pokedex.adicionarPokemon(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pokemon ja registrado na Pokedex", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoPokemonComMesmoNomeJaRegistrado() {
        try {
            Pokedex pokedex = new Pokedex();
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);
            Pokemon pokemon2 = new Pokemon("Charmander", fogo);

            Pokedex.adicionarPokemon(pokemon);
            Pokedex.adicionarPokemon(pokemon2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pokemon ja registrado na Pokedex", e.getMessage());
        }
    }

    //Testes com o adicionarPokemonTreinador e calcularPokemonCapturados
    @Test
    void deveRetornarListaPokemonTreinadorVazia() {
        Pokedex pokedex = new Pokedex();

        assertEquals(0, pokedex.calcularPokemonCapturados());
    }

    @Test
    void deveRetornarListaPokemonTreinadorComUmPokemon() {
        Pokedex pokedex = new Pokedex();

        TipoFogo fogo = new TipoFogo();

        Pokemon pokemon = new Pokemon("Charmander", fogo);
        pokedex.adicionarPokemonTreinador(pokemon);

        assertEquals(1, pokedex.calcularPokemonCapturados());
    }

    @Test
    void deveRetornarListaPokemonTreinadorComMuitosPokemon() {
        Pokedex pokedex = new Pokedex();
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Pokemon pokemon2 = new Pokemon("Squirtle", fogo);
        pokedex.adicionarPokemonTreinador(pokemon);
        pokedex.adicionarPokemonTreinador(pokemon2);

        assertEquals(2, pokedex.calcularPokemonCapturados());
    }

    @Test
    void deveRetornarExcecaoPokemonJaCapturado() {
        try {
            Pokedex pokedex = new Pokedex();
            TipoFogo fogo = new TipoFogo();
            Pokemon pokemon = new Pokemon("Charmander", fogo);

            pokedex.adicionarPokemonTreinador(pokemon);
            pokedex.adicionarPokemonTreinador(pokemon);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pokemon ja capturado!", e.getMessage());
        }
    }

    //Teste do atributo Static
    @Test
    void deveRetornarTamanhoListaPokemonEstatica() {
        Pokedex pokedex = new Pokedex();
        Pokedex pokedex2 = new Pokedex();

        Pokedex.zerarListaPokemon();
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);
        Pokemon pokemon2 = new Pokemon("Squirtle", fogo);

        Pokedex.adicionarPokemon(pokemon);
        Pokedex.adicionarPokemon(pokemon2);

        assertEquals(2, Pokedex.calcularPokemonExistentes());
    }

    //Teste da operação verificarPokemonRegistrado
    @Test
    void deveRetornarPokemonRegistradoTrue() {
        Pokedex pokedex = new Pokedex();
        Pokedex.zerarListaPokemon();

        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        Pokedex.adicionarPokemon(pokemon);

        assertTrue(Pokedex.verificarPokemonRegistrado(pokemon));
    }

    @Test
    void deveRetornarPokemonRegistradoFalse() {
        Pokedex pokedex = new Pokedex();
        Pokedex.zerarListaPokemon();

        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        assertFalse(Pokedex.verificarPokemonRegistrado(pokemon));
    }

    //Teste da operação zerarListaPokemon
    @Test
    void deveRetornarListaVazia() {
        Pokedex pokedex = new Pokedex();
        Pokedex.zerarListaPokemon();
        TipoFogo fogo = new TipoFogo();
        Pokemon pokemon = new Pokemon("Charmander", fogo);

        Pokedex.adicionarPokemon(pokemon);

        Pokedex.zerarListaPokemon();

        assertEquals(0, Pokedex.calcularPokemonExistentes());
    }

}