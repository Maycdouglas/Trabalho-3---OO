package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private String nome;
    private int pontosVida;
    private List<Golpe> listaGolpes = new ArrayList<Golpe>();
    private final Tipo tipagem;
    private TreinadorComum treinador;

    public Pokemon(String nome, Tipo tipagem) {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome obrigatorio!");
        }
        if(tipagem == null)
        {
            throw new IllegalArgumentException("Tipo do Pokemon é obrigatorio!");
        }
        this.nome = nome;
        this.tipagem = tipagem;
        this.pontosVida = 100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.equals(""))
        {
            throw new IllegalArgumentException("Nome obrigatorio!");
        }
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        if(pontosVida < 0)
        {
            throw new IllegalArgumentException("Valor negativo nao permitido!");
        }
        this.pontosVida = pontosVida;
    }

    public Tipo getTipagem() {
        return tipagem;
    }

    public List<Golpe> getListaGolpes() {
        return listaGolpes;
    }

    public TreinadorComum getTreinador() {
        return treinador;
    }

    public void setTreinador(TreinadorComum treinador) {
        this.treinador = treinador;
    }

    public void aprenderGolpe(Golpe golpe)
    {
        if(golpe.getTipagem() != this.tipagem)
        {
            throw new IllegalArgumentException("Insira um golpe com a mesma tipagem do Pokemon");
        }
        if(verificarGolpeAprendido(golpe))
        {
            throw new IllegalArgumentException("Golpe já foi aprendido!");
        }

        listaGolpes.add(golpe);
        golpe.adicionarPokemon(this);
    }

    public boolean verificarGolpeAprendido(Golpe golpe)
    {
        if(listaGolpes.size() > 0)
        {
            int contador = 0;
            while(contador < listaGolpes.size())
            {
                if(listaGolpes.get(contador) == golpe)
                {
                    return true;
                }
                contador++;
            }
        }
        return false;
    }

}
