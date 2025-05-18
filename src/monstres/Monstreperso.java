package monstres;

import Des.Des;
import personnages.Joueur;

public class Monstreperso extends Monstre {

    public Monstreperso(String espece, int numero, int pointDeVie, int force, int dexterite, int initiative,
                        int classeArmure, String typeAttaque, int portee, String degats) {
        super(espece, numero, pointDeVie, force, dexterite, initiative, classeArmure, typeAttaque, portee, degats);
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
}
