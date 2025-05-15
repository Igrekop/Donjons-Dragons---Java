package inter_face;
import java.util.ArrayList;
import java.util.List;
import classes.Classe;
import classes.Guerrier;
import classes.Roublard;
import maitredujeux.Maitredujeux;
import personnages.Joueur;
import races.Elfe;
import races.Humain;
import races.Races;
import monstres.*;

public class Inter_manag {
    public static void main(String[] args) {
        Barre_haut barreHaut = new Barre_haut();
        Races humain = new Humain();
        Races elfe = new Elfe();
        Classe guerrier = new Guerrier();
        Classe roublard = new Roublard();
        Maitredujeux mj = new Maitredujeux();

        // Création des joueurs
        Joueur joueur1 = new Joueur("Arthur", guerrier, humain);
        Joueur joueur2 = new Joueur("Luna", guerrier, elfe);
        Joueur joueur3 = new Joueur("Yanis", roublard, humain);

        List<Object> participants = new ArrayList<>();
        participants.add(joueur1);
        participants.add(joueur2);
        participants.add(joueur3);

        barreHaut.Affichage(joueur1, 1, participants,2);


    }

}
