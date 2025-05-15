package monstres;

import Des.Des;
import equipements.Equipement;
import personnages.Joueur;

public class Dragon extends Monstre {
    public Dragon(int numero) {
        super("Dragon", numero, 100, 0, 18, 10,
                15, "souffle de feu", 6, "2d10");
    }

    public void attaquer(Joueur cible) {
        System.out.println(getEspece() + " n° " + getNumero() + " attaque " + cible.getNom() + " avec " + getTypeAttaque() + " !");

        int jetAttaque = Des.lancerDes("1d20");
        int modificateur = 0;
        int degats = 0;

        if (getPortee() == 1) {
            modificateur = getForce();
            System.out.println("L'attaque est corps à corps !");
        } else {
            modificateur = getPortee();
            System.out.println("L'attaque est à distance !");
        }

        jetAttaque += modificateur;
        System.out.println("Jet d'attaque : " + jetAttaque);


        if (jetAttaque > cible.getEquiper().getLast().getClasseArmure()) {
            System.out.println("Attaque réussie!");
            degats = Des.lancerDes(getDegats());
            System.out.println("Dégâts infligés : " + degats);
            cible.addPdV(-degats);
            System.out.println(cible.getNom() + " PV restants : " + cible.getPointDeVie());
        } else {
            System.out.println("Attaque échouée!");
        }
    }
}