package pokemon;

import java.util.ArrayList;
import java.util.List;

public class TipoFogo implements Tipo{

    private Ginasio ginasio;
    private List<Golpe> listaGolpes;

    public TipoFogo() {
        this.listaGolpes = new ArrayList<Golpe>();
        this.ginasio = null;
    }

    public Ginasio getGinasio() {
        if(ginasio == null)
        {
            throw new NullPointerException("Este tipo ainda nao possui um ginasio");
        }
        return ginasio;
    }

    public void setGinasio(Ginasio ginasio) {
        if(ginasio.getEspecialidade() != this)
        {
            throw new IllegalArgumentException("O ginasio deve ter especialidade igual este tipo!");
        }
        if(this.ginasio != null)
        {
            throw new IllegalArgumentException("Nao é possível alterar o ginasio do tipo!");
        }
        this.ginasio = ginasio;
    }

    public List<Golpe> getListaGolpes() {
        return listaGolpes;
    }

    public void adicionarGolpe(Golpe golpe) {
        if(golpe.getTipagem() != this)
        {
            throw new IllegalArgumentException("O golpe deve ter este tipo!");
        }
        this.listaGolpes.add(golpe);
    }

    public int compararTipos(Tipo tipo)
    {
        if(tipo instanceof TipoGrama) {
            return 2; //venceu
        }
        else if(tipo instanceof TipoAgua)
        {
            return 0; //perdeu
        }
        return 1; //empatou
    }
}
