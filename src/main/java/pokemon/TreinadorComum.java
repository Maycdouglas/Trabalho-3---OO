package pokemon;

import java.util.ArrayList;
import java.util.List;

public class TreinadorComum extends Pessoa {

    private List<Pokemon> listaPokemon;
    private int qntdInsignias;
    private Pokedex pokedex;

    public TreinadorComum(String nome) {
        super(nome);
        this.listaPokemon = new ArrayList<Pokemon>();
        this.qntdInsignias = 0;
    }

    public List<Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    public void setListaPokemon(List<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    public int getQntdInsignias() {
        return qntdInsignias;
    }

    public void setQntdInsignias(int qntdInsignias) {
        this.qntdInsignias = qntdInsignias;
    }

    public Pokedex getPokedex() {
        if(this.pokedex == null)
        {
            throw new NullPointerException("Treinador sem Pokedex");
        }
        return pokedex;
    }

    public void capturarPokemon(Pokemon pokemon) {
        if(this.pokedex == null)
        {
            throw new IllegalArgumentException("Treinador deve receber a Pokedex antes!");
        }
        if(listaPokemon.size() < 1)
        {
            throw new IllegalArgumentException("Treinador deve escolher um inicial antes!");
        }
        if(pokemon.getTreinador() == this)
        {
            throw new IllegalArgumentException("Este Pokemon ja foi capturado por voce!");
        }
        if(pokemon.getTreinador() != null)
        {
            throw new IllegalArgumentException("Este Pokemon ja foi capturado por outro treinador!");
        }

        listaPokemon.add(pokemon);
        pokemon.setTreinador(this);
        if(!(Pokedex.verificarPokemonRegistrado(pokemon)))
        {
            registrarPokemon(pokemon);
        }
    }

    public void recuperarTime(Enfermeira enfermeira) {
        enfermeira.curarPokemon(listaPokemon);
    }

    public void ensinarGolpe(int indice, Golpe golpe)
    {
        if(indice < 0 || indice >= listaPokemon.size())
        {
            throw new IllegalArgumentException("Insira um numero de 0 ao total de Pokemon capturados");
        }

        Pokemon pokemon = listaPokemon.get(indice);
        pokemon.aprenderGolpe(golpe);
    }

    public void receberPokedex(Professor professor)
    {
        if(this.pokedex != null)
        {
            throw new IllegalArgumentException("Treinador já possui uma Pokedex");
        }
        this.pokedex = professor.entregarPokedex();
    }

    public void escolherPokemonInicial(Professor professor, String nome, Tipo tipo)
    {
        if(listaPokemon.size() > 0)
        {
            throw new IllegalArgumentException("Treinador já possui um Pokemon");
        }
        if(this.pokedex == null)
        {
            throw new IllegalArgumentException("Treinador deve receber a Pokedex antes!");
        }

        Pokemon pokemon = professor.entregarPokemonInicial(nome,tipo);
        listaPokemon.add(pokemon);

        if(!(Pokedex.verificarPokemonRegistrado(pokemon)))
        {
            registrarPokemon(pokemon);
        }
    }

    public void registrarPokemon(Pokemon pokemon) {
        Pokedex.adicionarPokemon(pokemon);
    }

    public void desafiarGinasio(Ginasio ginasio, int indicePokemon)
    {
        if(this.listaPokemon.size() == 0)
        {
            throw new IllegalArgumentException("Treinador não possui Pokémon");
        }
        if(indicePokemon < 0 || indicePokemon >= this.listaPokemon.size())
        {
            throw new IllegalArgumentException("Indice invalido!");
        }
        if(this.listaPokemon.get(indicePokemon).getPontosVida()  == 0)
        {
            throw new NullPointerException("Pokemon sem Pontos de Vida para batalhar. Leve-o até a enfermeira!");
        }

        int resultado = ginasio.batalha(this.listaPokemon.get(indicePokemon));

        if(resultado == 2)
        {
            setQntdInsignias(getQntdInsignias() + 1); //vitória
        } else if(resultado == 0) {
            this.listaPokemon.get(indicePokemon).setPontosVida(0); //derrota
        }
        else {
            this.listaPokemon.get(indicePokemon).setPontosVida(50); //empate
        }
    }
}
