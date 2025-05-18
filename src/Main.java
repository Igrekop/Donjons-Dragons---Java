import classes.*;
import equipements.*;
import maitredujeux.Maitredujeux;
import monstres.Dragon;
import monstres.Gobelin;
import monstres.Monstre;
import monstres.Squelette;
import personnages.*;
import races.*;
import Des.*;
import inter_face.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        // 1. Création des races et classes
        Races humain = new Humain();
        Races elfe = new Elfe();
        Classe guerrier = new Guerrier();
        Classe roublard = new Roublard();

        // 2. Création des joueurs
        Joueur joueur1 = new Joueur("Arthur", guerrier, humain);
        Joueur joueur2 = new Joueur("Luna", guerrier, elfe);
        Joueur joueur3 = new Joueur("Sonic", roublard, humain);

        // 3. Application des bonus raciaux
        humain.appliquerBonus(joueur1);
        elfe.appliquerBonus(joueur2);
        humain.appliquerBonus(joueur3);

        // 4. Création des monstres
        Maitredujeux mj = new Maitredujeux();


        // 5. Liste des participants
        List<Object> participants = new ArrayList<>();
        participants.add(joueur1);
        participants.add(joueur2);
        participants.add(joueur3);
        participants.add(mj.creerMonstre());
        participants.add(mj.creerMonstre());

        // 6. Initialisation des modules d'affichage
        Barre_haut barreHaut = new Barre_haut();
        map_milieu map = new map_milieu(20, 20);

        // 7. Affichage initial
        int numeroDonjon = 1;
        int tourActuel = 1;
        Joueur joueurActif = joueur1;

        barreHaut.Affichage(joueurActif, numeroDonjon, participants, tourActuel);
        map.Affichage(participants);

        // 8. Tour par tour (simulation de 3 tours ici)
        for (int tour = 1; tour <= 3; tour++) {
            System.out.println("\n======= TOUR " + tour + " =======");
            for (Object obj : participants) {
                if (obj instanceof Joueur joueur) {
                    System.out.println(joueur.getNom() + " joue son tour !");
                    // Ici, on pourrait appeler une méthode du joueur (déplacement, attaque, etc.)
                } else if (obj instanceof Monstre monstre) {
                    System.out.println("Le " + monstre.getEspece() + " agit !");
                    // Action du monstre
                }
            }

            // Affichage mis à jour à la fin du tour
            barreHaut.Affichage(joueurActif, numeroDonjon, participants, tour + 1);
            map.Affichage(participants);
        }

        System.out.println("\nPartie terminée !");

    }
}