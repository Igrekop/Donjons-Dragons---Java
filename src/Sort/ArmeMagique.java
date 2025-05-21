package Sort;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Joueur;

import java.util.ArrayList;

public class ArmeMagique extends Sort{

    public ArmeMagique() {
        super("Arme Magique");
    }

    @Override
    public void utiliser(Joueur cible1, Joueur cible2) {
        ArrayList<Equipement> inventaire = cible2.getEquipements();

        for (Equipement e : inventaire) {
            if (e.getType() == )
            System.out.println(e);
        }
    }

    @Override
    public void utiliser(Joueur cible1, Monstre cible2) {}

    @Override
    public void utiliser(Monstre cible1, Monstre cible2) {}
}
