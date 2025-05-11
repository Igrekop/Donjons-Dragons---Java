import classes.*;
import equipements.*;
import personnages.*;
import races.*;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        Races elfe = new Elfe();  // Créer une instance de race Elfe
        Races nain = new Nain();  // Créer une instance de race Nain

        // Création des classes
        Classe guerrier = new Guerrier();  // Classe Guerrier
        Classe magicien = new Magicien();

        // Création des personnages avec leurs classes et races respectives
        Joueur joueur1 = new Joueur("Aragorn", guerrier, elfe);  // Un Guerrier Elfe
        Joueur joueur2 = new Joueur("Gimli", magicien, nain);  // Un Magicien Nain

        // Affichage des informations des personnages
        System.out.println(joueur1);
        System.out.println(joueur2);

        // Exemple d'attaque : joueur1 attaque joueur2
        joueur1.attaquer(joueur2);

        // Affichage des informations après l'attaque
        System.out.println("\nAprès l'attaque de " + joueur1.nom + " sur " + joueur2.nom);
        System.out.println(joueur2);  // Affiche les stats du joueur2 après l'attaque

        List<Equipement> equipement = GestionEquipements.initialiserEquipements();
        GestionEquipements.afficherEquipements(equipement);
    }
}