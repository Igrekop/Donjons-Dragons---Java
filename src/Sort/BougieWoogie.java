package Sort;

import monstres.Monstre;
import personnages.Joueur;
import interfacejeu.*;

public class BougieWoogie extends Sort{

    public BougieWoogie() {
        super("Bougie-Woogie");
    }

    public void utiliser(Joueur cible1, Joueur cible2, map_milieu map) {
        int cible1PosX = cible1.getPosX();
        int cible1PosY = cible1.getPosY();

        cible1.setPosXY(cible2.getPosX(), cible2.getPosY(), map);
        cible2.setPosXY(cible1PosX, cible1PosY, map);
    }

    public void utiliser(Joueur cible1, Monstre cible2, map_milieu map) {
        int cible1PosX = cible1.getPosX();
        int cible1PosY = cible1.getPosY();

        cible1.setPosXY(cible2.getPosX(), cible2.getPosY(), map);
        cible2.setPosXY(cible1PosX, cible1PosY, map);

    }
    public void utiliser(Monstre cible1, Monstre cible2, map_milieu map) {
        int cible1PosX = cible1.getPosX();
        int cible1PosY = cible1.getPosY();

        cible1.setPosXY(cible2.getPosX(), cible2.getPosY(), map);
        cible2.setPosXY(cible1PosX, cible1PosY, map);
    }

    @Override
    public void utiliser(Joueur cible1, Joueur cible2) {

    }

    @Override
    public void utiliser(Joueur cible1, Monstre cible2) {

    }

    @Override
    public void utiliser(Monstre cible1, Monstre cible2) {

    }
}
