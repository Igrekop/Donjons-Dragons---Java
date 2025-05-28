package Sort;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Entité.entite;
import personnages.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmeMagique extends Sort{

    public ArmeMagique() {
        super("Arme Magique");
    }

    @Override
    public void utiliser(Joueur cible1, Joueur cible2) {
        ArrayList<Equipement> inventaire = cible2.getEquipements();
        ArrayList<Equipement> armesDisponibles = new ArrayList<>();

        for (Equipement e : inventaire)
        {
            int i = 1;
            if (e.getType().toLowerCase().startsWith("arme"))
            {
                System.out.println(i + " - " + e.getNom());
                armesDisponibles.add(e);
                i = i + 1;
            }
        }

        if (armesDisponibles.isEmpty()) {
            System.out.println(cible2.getNom() + " ne possède aucune arme.");
            return;
        }

        System.out.print("Choisissez le numéro de l'arme à améliorer : ");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        if (choix < 1 || choix > armesDisponibles.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Equipement armeChoisie = armesDisponibles.get(choix - 1);
        armeChoisie.setEnchante(armeChoisie.getEnchante() + 1);

        System.out.println("L'arme '" + armeChoisie.getNom() + "' a été améliorée !");
    }

    @Override
    public void utiliser(entite cible1, entite cible2) {

    }
}
