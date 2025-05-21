package monstres;

import Des.Des;
import personnages.Joueur;

public class Gobelin extends Monstre {
    public Gobelin(int numero) {
        super("Gobelin", numero, 10, 4, 0, 5,
                9, "coup de dague", 1, "1d6");
    }

    @Override
    public void attaquer(Joueur cible) {
        CombatResultat resultat = calculerAttaque(cible);
        afficherResultatAttaque(resultat, cible);
    }

    private CombatResultat calculerAttaque(Joueur cible) {
        int jetAttaque = Des.lancerDes("1d20");
        int modificateur;

        if (getPortee() == 1) {
            modificateur = getForce();
        } else {
            modificateur = getDexterite();
        }

        jetAttaque += modificateur;

        int classeArmureCible = cible.getClasseArmureActuelle();

        boolean succes = jetAttaque > classeArmureCible;
        int degatsInfliges = 0;

        if (succes) {
            degatsInfliges = Des.lancerDes(getDegats());
            cible.addPdV(-degatsInfliges);
        }

        return new CombatResultat(jetAttaque, modificateur, succes, degatsInfliges, classeArmureCible);
    }

    private void afficherResultatAttaque(CombatResultat resultat, Joueur cible) {
        System.out.println(getEspece() + " n°" + getNumero() + " attaque " + cible.getNom() + " avec " + getTypeAttaque() + " !");
        System.out.println("Jet d'attaque : " + resultat.jetAttaque + " (modificateur : " + resultat.modificateur + ")");
        if (getPortee() == 1) {
            System.out.println("Attaque corps à corps.");
        } else {
            System.out.println("Attaque à distance.");
        }
        if (resultat.succes) {
            System.out.println("Attaque réussie !");
            System.out.println("Dégâts infligés : " + resultat.degatsInfliges);
            System.out.println(cible.getNom() + " PV restants : " + cible.getPointDeVie());
        } else {
            System.out.println("Attaque échouée !");
        }
    }

    private static class CombatResultat {
        int jetAttaque;
        int modificateur;
        boolean succes;
        int degatsInfliges;
        int classeArmureCible;

        public CombatResultat(int jetAttaque, int modificateur, boolean succes, int degatsInfliges, int classeArmureCible) {
            this.jetAttaque = jetAttaque;
            this.modificateur = modificateur;
            this.succes = succes;
            this.degatsInfliges = degatsInfliges;
            this.classeArmureCible = classeArmureCible;
        }
    }

    public int getPvDeBase() {
        return 10;
    }

    @Override
    public String afficher() {
        return "\uD83D\uDC7A";
    }
}
