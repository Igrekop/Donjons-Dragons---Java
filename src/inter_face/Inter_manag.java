package inter_face;
import java.util.ArrayList;
import java.util.List;
import classes.Classe;
import classes.Guerrier;
import classes.Roublard;
import equipements.Armes.ArmeCourante;
import equipements.Armes.Armes;
import equipements.Equipement;
import maitredujeux.Maitredujeux;
import personnages.Joueur;
import races.Elfe;
import races.Humain;
import races.Races;

public class Inter_manag {
    public static void main(String[] args) {
        Barre_haut barreHaut = new Barre_haut();
        Races humain = new Humain();
        Races elfe = new Elfe();
        Classe guerrier = new Guerrier();
        Classe roublard = new Roublard();
        Maitredujeux mj = new Maitredujeux();
        map_milieu map = new map_milieu(20,20); // création d'une instance

        // Création des joueurs
        Joueur joueur1 = new Joueur("Arthur", guerrier, humain);
        Joueur joueur2 = new Joueur("Luna", guerrier, elfe);
        Joueur joueur3 = new Joueur("Sonic", roublard, humain);

        List<Object> participants = new ArrayList<>();
        participants.add(joueur1);
        participants.add(joueur2);
        participants.add(joueur3);

        ArmeCourante d = new ArmeCourante("Bâton", "1d6");

        barreHaut.Affichage(joueur1, 1, participants,2);

        joueur1.setPosXY(14,9);
        joueur2.setPosXY(15,11);
        joueur3.setPosXY(13,7);

        map.addObstacle(15,12);
        map.addObstacle(15,14);
        map.addEquipment(14,11,d);

        joueur1.seDeplacer("droite",map,2);
        joueur2.seDeplacer("droite",map, 1);
        //joueur3.seDeplacer("haut",map,1);




        map.Print(participants);


    }

}
