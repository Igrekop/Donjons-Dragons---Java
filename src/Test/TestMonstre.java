package Test;

import monstres.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMonstre {

    @Test
    public void testInitialisationDragon() {
        Dragon dragon = new Dragon(1);

        assertEquals("Dragon", dragon.getEspece());
        assertEquals(1, dragon.getNumero());
        assertEquals(100, dragon.getPointDeVie());
        assertEquals(0, dragon.getForce());
        assertEquals(18, dragon.getDexterite());
        assertEquals(10, dragon.getInitiative());
        assertEquals(15, dragon.getClasseArmure());
        assertEquals("souffle de feu", dragon.getTypeAttaque());
        assertEquals(6, dragon.getPortee());
        assertEquals("2d10", dragon.getDegats());
        assertEquals(1, dragon.getVitesse());
        assertEquals(100, dragon.getPvDeBase());
        assertEquals("\uD83D\uDC09" + " ", dragon.afficher());
    }

    @Test
    public void testDragonEstVivantEtMort() {
        Dragon dragon = new Dragon(2);
        assertFalse(dragon.estMort());

        dragon.subirDegats(100);
        assertTrue(dragon.estMort());
    }

    @Test
    public void testInitialisationGobelin() {
        Gobelin gobelin = new Gobelin(1);

        assertEquals("Gobelin", gobelin.getEspece());
        assertEquals(1, gobelin.getNumero());
        assertEquals(10, gobelin.getPointDeVie());
        assertEquals(4, gobelin.getForce());
        assertEquals(0, gobelin.getDexterite());
        assertEquals(5, gobelin.getInitiative());
        assertEquals(9, gobelin.getClasseArmure());
        assertEquals("coup de dague", gobelin.getTypeAttaque());
        assertEquals(1, gobelin.getPortee());
        assertEquals("1d6", gobelin.getDegats());
        assertEquals(3, gobelin.getVitesse());
        assertEquals(10, gobelin.getPvDeBase());
        assertEquals("\uD83D\uDC7A" + " ", gobelin.afficher());
    }

    @Test
    public void testGobelinEstVivantEtMort() {
        Gobelin gobelin = new Gobelin(2);
        assertFalse(gobelin.estMort());

        gobelin.subirDegats(10);
        assertTrue(gobelin.estMort());
    }

    @Test
    public void testInitialisationSquelette() {
        Squelette squelette = new Squelette(1);

        assertEquals("Squelette", squelette.getEspece());
        assertEquals(1, squelette.getNumero());
        assertEquals(15, squelette.getPointDeVie());
        assertEquals(5, squelette.getForce());
        assertEquals(0, squelette.getDexterite());
        assertEquals(4, squelette.getInitiative());
        assertEquals(10, squelette.getClasseArmure());
        assertEquals("épée rouillée", squelette.getTypeAttaque());
        assertEquals(1, squelette.getPortee());
        assertEquals("1d8", squelette.getDegats());
        assertEquals(4, squelette.getVitesse());
        assertEquals(15, squelette.getPvDeBase());
        assertEquals("\uD83D\uDC80" + " ", squelette.afficher());
    }

    @Test
    public void testSqueletteEstVivantEtMort() {
        Squelette squelette = new Squelette(2);
        assertFalse(squelette.estMort());

        squelette.subirDegats(15);
        assertTrue(squelette.estMort());
    }
}
