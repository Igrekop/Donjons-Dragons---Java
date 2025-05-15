package monstres;

import personnages.Joueur;

public abstract class Monstre {
    private String espece;
    private int numero;
    private int pointDeVie;
    private int force;
    private int dexterite;
    private int initiative;
    private int classeArmure;
    private String typeAttaque;
    private int portee;
    private String degats;

    public Monstre(String espece, int numero, int pointDeVie, int force, int dexterite, int initiative,
                   int classeArmure, String typeAttaque, int portee, String degats) {
        this.espece = espece;
        this.numero = numero;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.initiative = initiative;
        this.classeArmure = classeArmure;
        this.typeAttaque = typeAttaque;
        this.portee = portee;
        this.degats = degats;
    }

    public abstract void attaquer(Joueur cible);

    public String toString() {
        return espece + " #" + numero + " [PV: " + pointDeVie + ", Attaque: " + typeAttaque +
                ", Dégâts: " + degats + ", Portée: " + portee + "]";
    }

    public int getPointdeVie() {
        return pointDeVie;
    }

    public String getEspece() {
        return espece;
    }

    public int getNumero() {
        return numero;
    }

    public int setPointdeVie(int pv) {
        return pointDeVie -= pv;
    }

    public int getClasseArmure() {
        return this.classeArmure;
    }
}