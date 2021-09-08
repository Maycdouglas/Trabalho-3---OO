package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Enfermeira extends Pessoa{

    public Enfermeira(String nome) {
        super(nome);
    }

    public void curarPokemon(List<Pokemon> listaPokemon) {

        if(listaPokemon.size() < 1) {
            throw new IllegalArgumentException("Lista de Pokemon vazia, insira ao menos um Pokemon!");
        }

        int i = 0;
        while(i != listaPokemon.size()) {
            listaPokemon.get(i).setPontosVida(100);
            i++;
        }

    }
}
