package monstres;

import Des.Des;
import personnages.Joueur;

import javax.swing.*;

public class Monstreperso extends Monstre {

    private String icone;
    private final int m_PvDeBase;

    public Monstreperso(String espece, int numero, int pointDeVie, int force, int dexterite, int initiative,
                        int classeArmure, String typeAttaque, int portee, String degats, String icone) {
        super(espece, numero, pointDeVie, force, dexterite, initiative, classeArmure, typeAttaque, portee, degats);
        this.icone = icone;
        this.m_PvDeBase = pointDeVie;
    }

    @Override
    public void attaquer(Joueur cible) {
        // Calcul de la distance entre le monstre et le joueur
        int distance = Math.abs(getPosX() - cible.getPosX()) + Math.abs(getPosY() - cible.getPosY());

        if (distance > getPortee()) {
            System.out.println(getEspece() + " n°" + getNumero() + " est trop loin pour attaquer " + cible.getNom() + " !");
            System.out.println("Distance : " + distance + " / Portée : " + getPortee());
            return;
        }

        CombatResultat resultat = calculerAttaque(cible);
        afficherResultatAttaque(resultat, cible);
    }

    private CombatResultat calculerAttaque(Joueur cible) {
        int jetAttaque = Des.lancerDes("1d20");

        int modificateur = (getPortee() == 1) ? getForce() : getDexterite();
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

    public void setIcone(String ico) {
        icone = ico;
    }

    public String getIcone() {
        return icone;
    }



    @Override
    public String afficher() {
        return getIcone();
    }

    public int getPvDeBase() {
        return m_PvDeBase;
    }




}
