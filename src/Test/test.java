package Test;

import org.junit.jupiter.api.BeforeEach;
import personnages.*;
import classes.*;
import races.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class test {

    private Joueur joueur;
    private Archetype mockArchetype;
    private Races mockRace;

    @BeforeEach
    public void setUp() {
        mockArchetype = new Guerrier();
        mockRace = new Humain();
        joueur = new Joueur("Alex", mockArchetype, mockRace);
    }

    @Test
    public void testInitialisationJoueur()
    {
        assertEquals("Alex", joueur.getNom());
        assertEquals("Guerrier", joueur.getClasse().getNom());
        assertEquals("Humain", joueur.getRace().getNom());
        assertTrue(joueur.getPointDeVie() > 0);
        assertNotNull(joueur.getEquipements());
    }
}
