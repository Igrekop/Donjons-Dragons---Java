package Sort;

import monstres.Monstre;
import personnages.Entité.entite;
import personnages.Joueur;
import interfacejeu.*;

public class BougieWoogie extends Sort{

    public BougieWoogie() {
        super("Bougie-Woogie");
    }

    public void utilisermap(entite cible1, entite cible2) {
        int cible1PosX = cible1.getPosX();
        int cible1PosY = cible1.getPosY();

        echangerPositions(cible1, cible2);

    }

    @Override
    public void utiliser(Joueur cible1, Joueur cible2) {

    }

    @Override
    public void utiliser(entite cible1, entite cible2) {

    }
}
