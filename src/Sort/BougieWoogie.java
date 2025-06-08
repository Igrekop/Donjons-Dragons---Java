package Sort;

import personnages.entite.entite;
import personnages.Joueur;

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
