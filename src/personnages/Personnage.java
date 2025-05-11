package personnages;


public abstract class Personnage {
    public String nom;
    public int pointDeVie;
    public int force;
    public int dexterite;
    public int vitesse;
    public int initiative;

    public Personnage (String nom, int pointDeVie, int force, int dexterite, int vitesse, int initiative) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.vitesse = vitesse;
        this.initiative = initiative;

    }

    public abstract void attaquer(Personnage cible);

    @Override
    public String toString() {
        return "Nom : " + nom +
                "\nPoints de vie : " + pointDeVie +
                "\nForce : " + force +
                "\nDextérité : " + dexterite +
                "\nVitesse : " + vitesse +
                "\nInitiative : " + initiative;
    }

}


