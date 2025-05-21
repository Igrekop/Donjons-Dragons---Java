package Sort;

import monstres.Monstre;
import personnages.Joueur;

public class BougieWoogie extends Sort{

    public BougieWoogie() {
        super("Bougie-Woogie");
    }

    @Override
    public void utiliser(Joueur cible1, Joueur cible2) {
        int cible1PosX = cible1.getPosX();
        int cible1PosY = cible1.getPosY();

        cible1.SetPosX(cible2.getPosX());
        cible1.SetPosY(cible2.getPosY());

        cible2.SetPosX(cible1PosX);
        cible2.SetPosY(cible1PosY);
    }

    @Override
    public void utiliser(Joueur cible1, Monstre cible2) {
        int lanceurPosX = cible1.getPosX();
        int lanceurPosY = cible1.getPosY();

    }

    @Override
    public void utiliser(Monstre cible1, Monstre cible2) {

    }
}
