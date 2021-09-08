package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoAguaTest {

    //Testes adicionarGolpe
    @Test
    void deveRetornarGolpeAdicionado()
    {
        TipoAgua agua = new TipoAgua();
        Golpe golpe = new Golpe("Jato de Agua", agua);
        agua.adicionarGolpe(golpe);

        assertTrue(agua.getListaGolpes().contains(golpe));
    }

    @Test
    void deveRetornarExcecaoGolpeTipoDiferente()
    {
        try {
            TipoAgua agua = new TipoAgua();
            TipoFogo fogo = new TipoFogo();
            Golpe golpe = new Golpe("Jato de Agua", fogo);
            agua.adicionarGolpe(golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O golpe deve ter este tipo!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoSemGinasio()
    {
        try {
            TipoAgua agua = new TipoAgua();
            agua.getGinasio();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Este tipo ainda nao possui um ginasio", e.getMessage());
        }
    }

    //Testes setGinasio
    @Test
    void deveRetornarExcecaoGinasioOutroTipo()
    {
        try {
            TipoAgua agua = new TipoAgua();
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", fogo);
            agua.setGinasio(ginasio);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O ginasio deve ter especialidade igual este tipo!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoGinasioNaoPodeSerTrocado()
    {
        try {
            TipoAgua agua = new TipoAgua();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
            Ginasio ginasio2 = new Ginasio("Insignia da Cascata", "Misty", agua);
            agua.setGinasio(ginasio);
            agua.setGinasio(ginasio2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nao é possível alterar o ginasio do tipo!", e.getMessage());
        }
    }


    //Testes com compararTipos
    @Test
    void deveRetornarVitoria() {
        TipoAgua agua = new TipoAgua();
        TipoFogo fogo = new TipoFogo();

        assertEquals(2, agua.compararTipos(fogo));
    }
    @Test
    void deveRetornarDerrota() {
        TipoAgua agua = new TipoAgua();
        TipoGrama grama = new TipoGrama();

        assertEquals(0, agua.compararTipos(grama));
    }
    @Test
    void deveRetornarEmpate() {
        TipoAgua agua = new TipoAgua();

        assertEquals(1, agua.compararTipos(agua));

    }
}