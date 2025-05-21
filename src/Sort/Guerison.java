package Sort;

import classes.Classe;
import classes.Guerrier;
import monstres.Monstre;
import personnages.Joueur;
import personnages.Personnage;
import Des.*;

public class Guerison extends Sort{

    public Guerison() {
        super("Guérison");
    }

    @Override
    public void utiliser(Joueur cible1, Joueur cible2) {
        int des = Des.lancerDes("1d10");
        int pvmax = cible2.getPVdebase();
        if (cible2.getPointDeVie() + des < pvmax)
        {
            cible2.addPdV(des);
        }
    }

    @Override
    public void utiliser(Joueur cible1, Monstre cible2) {}

    @Override
    public void utiliser(Monstre cible1, Monstre cible2) {}
}
