package monstres;

import personnages.Joueur;

public class Squelette extends Monstre {
    public Squelette(int numero) {
        super("Squelette", numero, 15, 5, 0, 4,
                10, "épée rouillée", 1, "1d8");
    }

    @Override
    public void attaquer(Joueur cible) {

    }
}
