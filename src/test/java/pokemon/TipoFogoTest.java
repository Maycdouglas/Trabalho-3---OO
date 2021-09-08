package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoFogoTest {


    //Testes adicionarGolpe
    @Test
    void deveRetornarGolpeAdicionado()
    {
        TipoFogo fogo = new TipoFogo();
        Golpe golpe = new Golpe("Jato de Fogo", fogo);
        fogo.adicionarGolpe(golpe);

        assertTrue(fogo.getListaGolpes().contains(golpe));
    }

    @Test
    void deveRetornarExcecaoGolpeTipoDiferente()
    {
        try {
            TipoAgua agua = new TipoAgua();
            TipoFogo fogo = new TipoFogo();
            Golpe golpe = new Golpe("Jato de Fogo", agua);
            fogo.adicionarGolpe(golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O golpe deve ter este tipo!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoSemGinasio()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            fogo.getGinasio();
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
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
            fogo.setGinasio(ginasio);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O ginasio deve ter especialidade igual este tipo!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoGinasioNaoPodeSerTrocado()
    {
        try {
            TipoFogo fogo = new TipoFogo();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", fogo);
            Ginasio ginasio2 = new Ginasio("Insignia da Cascata", "Misty", fogo);
            fogo.setGinasio(ginasio);
            fogo.setGinasio(ginasio2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nao é possível alterar o ginasio do tipo!", e.getMessage());
        }
    }

    //Testes com compararTipos
    @Test
    void deveRetornarVitoria() {
        TipoFogo fogo = new TipoFogo();
        TipoGrama grama = new TipoGrama();

        assertEquals(2, fogo.compararTipos(grama));
    }
    @Test
    void deveRetornarDerrota() {
        TipoFogo fogo = new TipoFogo();
        TipoAgua agua = new TipoAgua();


        assertEquals(0, fogo.compararTipos(agua));
    }
    @Test
    void deveRetornarEmpate() {
        TipoFogo fogo = new TipoFogo();

        assertEquals(1, fogo.compararTipos(fogo));

    }

}