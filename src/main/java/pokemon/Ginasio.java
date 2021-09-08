package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Ginasio {

    private String insignia;
    private LiderGinasio lider;
    private Tipo especialidade;

    public Ginasio(String insignia, String nomeLider, Tipo especialidade) {
        if(insignia.equals(""))
        {
            throw new IllegalArgumentException("Nome da Insignia obrigatorio!");
        }
        if(nomeLider.equals(""))
        {
            throw new IllegalArgumentException("Nome do Lider de Ginasio obrigatorio!");
        }
        if(especialidade == null)
        {
            throw new IllegalArgumentException("Especialidade do Ginásio é obrigatória!");
        }
        this.insignia = insignia;
        this.especialidade = especialidade;
        this.especialidade.setGinasio(this);
        this.lider = new LiderGinasio(nomeLider, especialidade);
    }

    public LiderGinasio getLider() {
        return lider;
    }

    public String getInsignia() {
        return insignia;
    }

    public void setInsignia(String insignia) {
        if(insignia.equals(""))
        {
            throw new IllegalArgumentException("Nome da Insignia obrigatorio!");
        }
        this.insignia = insignia;
    }

    public String getNomeLiderGinasio() {
        return lider.getNome();
    }

    public void setNomeLiderGinasio(String nomeLider) {
        if(nomeLider.equals(""))
        {
            throw new IllegalArgumentException("Nome do Lider de Ginasio obrigatorio!");
        }
        lider.setNome(nomeLider);
    }

    public Tipo getEspecialidade() {
        return especialidade;
    }

    public int batalha(Pokemon pokemonTreinador) {

        if(this.lider.getPokemon() == null)
        {
            throw new NullPointerException("Lider de Ginasio sem Pokemon");
        }

        Pokemon pokemonLider = this.lider.getPokemon();

        return pokemonTreinador.getTipagem().compararTipos(pokemonLider.getTipagem());
    }

    public class LiderGinasio extends Pessoa {

        private Pokemon pokemon;
        private final Tipo especialidade;

        public LiderGinasio(String nome, Tipo especialidade) {
            super(nome);
            this.especialidade = especialidade;
        }

        public Tipo getEspecialidade() {
            return especialidade;
        }

        public Pokemon getPokemon() {
            if(this.pokemon == null)
            {
                throw new NullPointerException("Lider de Ginasio sem Pokemon");
            }
            return pokemon;
        }

        public void setPokemon(Pokemon pokemon) {
            if(pokemon.getTipagem() != especialidade)
            {
                throw new IllegalArgumentException("O tipo do Pokemon nao corresponde com a especialidade do Lider de Ginasio");
            }
            this.pokemon = pokemon;
        }
    }
}
