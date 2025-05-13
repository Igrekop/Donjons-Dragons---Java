package personnages;


import monstres.Monstre;

public abstract class Personnage {
    private String nom;
    private int pointDeVie;
    private int force;
    private int dexterite;
    private int vitesse;
    private int initiative;

    public Personnage (String nom, int pointDeVie, int force, int dexterite, int vitesse, int initiative) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.vitesse = vitesse;
        this.initiative = initiative;

    }

    public abstract void attaquer(Monstre cible);

    @Override
    public String toString() {
        return "Nom : " + nom +
                "\nPoints de vie : " + pointDeVie +
                "\nForce : " + force +
                "\nDextérité : " + dexterite +
                "\nVitesse : " + vitesse +
                "\nInitiative : " + initiative;
    }

    public String getNom() {
        return nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public int getForce() {
        return force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setNom(String nom_change) {
        nom = nom_change;
    }

    public void setPointDeVie(int pv) {
        pointDeVie = pv;
    }

    public void setForce(int force_change) {
        force = force_change;
    }

    public void setDexterite(int dexterite_change) {
        dexterite = dexterite_change;
    }

    public void setVitesse(int vitesse_change) {
        vitesse = vitesse_change;
    }

    public void setInitiative(int initiative_change) {
        initiative = initiative_change;
    }
}


