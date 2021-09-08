package pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoGramaTest {

    //Testes adicionarGolpe
    @Test
    void deveRetornarGolpeAdicionado()
    {
        TipoGrama grama = new TipoGrama();
        Golpe golpe = new Golpe("Jato de Fogo", grama);
        grama.adicionarGolpe(golpe);

        assertTrue(grama.getListaGolpes().contains(golpe));
    }

    @Test
    void deveRetornarExcecaoGolpeTipoDiferente()
    {
        try {
            TipoAgua agua = new TipoAgua();
            TipoGrama grama = new TipoGrama();
            Golpe golpe = new Golpe("Jato de Fogo", agua);
            grama.adicionarGolpe(golpe);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O golpe deve ter este tipo!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoSemGinasio()
    {
        try {
            TipoGrama grama = new TipoGrama();
            grama.getGinasio();
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
            TipoGrama grama = new TipoGrama();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", agua);
            grama.setGinasio(ginasio);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O ginasio deve ter especialidade igual este tipo!", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoGinasioNaoPodeSerTrocado()
    {
        try {
            TipoGrama grama = new TipoGrama();
            Ginasio ginasio = new Ginasio("Insignia da Cascata", "Misty", grama);
            Ginasio ginasio2 = new Ginasio("Insignia da Cascata", "Misty", grama);
            grama.setGinasio(ginasio);
            grama.setGinasio(ginasio2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nao é possível alterar o ginasio do tipo!", e.getMessage());
        }
    }


    //Testes com compararTipos
    @Test
    void deveRetornarVitoria() {
        TipoGrama grama = new TipoGrama();
        TipoAgua agua = new TipoAgua();


        assertEquals(2, grama.compararTipos(agua));
    }
    @Test
    void deveRetornarDerrota() {
        TipoGrama grama = new TipoGrama();
        TipoFogo fogo = new TipoFogo();

        assertEquals(0, grama.compararTipos(fogo));
    }
    @Test
    void deveRetornarEmpate() {
        TipoGrama grama = new TipoGrama();

        assertEquals(1, grama.compararTipos(grama));

    }

}