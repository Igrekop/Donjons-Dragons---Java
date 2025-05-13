import classes.*;
import equipements.*;
import monstres.Dragon;
import monstres.Monstre;
import personnages.*;
import races.*;
import Des.*;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        Races humain = new Humain();
        Races elfe = new Elfe();
        Classe guerrier = new Guerrier();

        // Création des joueurs
        Joueur joueur1 = new Joueur("Arthur", guerrier, humain);
        Joueur joueur2 = new Joueur("Luna", guerrier, elfe);

        // Affichage des joueurs
        System.out.println("==== Joueurs ====");
        System.out.println(joueur1);
        System.out.println();
        System.out.println(joueur2);

        joueur2.attaquer(joueur1);



        System.out.println(joueur1.getClasse().getEquipements());

        Monstre smolder = new Dragon(1);
        System.out.println(smolder);

        GestionEquipements.equiperPremiereArmeEtArmure(joueur1, guerrier.getEquipements());

        // Affichage des infos joueur
        System.out.println("==== Infos du joueur après équipement ====");
        System.out.println(joueur1);

        // Affichage des équipements réellement équipés
        System.out.println("==== Équipements équipés par Arthur ====");
        List<Equipement> equipe = joueur1.getEquiper();
        for (Equipement eq : equipe) {
            System.out.println(" - " + eq.getNom() + " | Force: " + eq.getModificateurForce() + ", Vitesse: " + eq.getModificateurVitesse());
        }

        // Affichage
        System.out.println("==== Équipement de Arthur ====");
        for (Equipement eq : joueur1.getClasse().getEquipements()) {
            System.out.println(eq);
        }

        System.out.println("Lancer 2d6 : " + Des.lancerDes("2d6"));
        System.out.println("Lancer 1d8 : " + Des.lancerDes("1d8"));
        System.out.println("Lancer 3d4 : " + Des.lancerDes("3d4"));
    }
}