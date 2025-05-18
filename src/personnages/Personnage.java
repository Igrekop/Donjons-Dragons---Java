package personnages;
import equipements.Equipement;
import monstres.Monstre;
import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {
    private String nom;
    private int pointDeVie;
    private int force;
    private int dexterite;
    private int vitesse;
    private int initiative;
    Equipement[] equipementEquipe = new Equipement[2];

    public Personnage (String nom, int pointDeVie, int force, int dexterite, int vitesse, int initiative) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.vitesse = vitesse;
        this.initiative = initiative;

    }

    public abstract void attaquer(Monstre cible);

    public List<Equipement> getEquiper() {
        List<Equipement> equipe = new ArrayList<>();
        for (Equipement e : equipementEquipe) {
            if (e != null) equipe.add(e);
        }
        return equipe;
    }


    public abstract void equiper(Equipement equipement, Object equipe);

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

    public void addPdV(int pv) {
        pointDeVie += pv;
    }

    public void setForce(int force_change) {
        force = force_change;
    }

    public void setVitesse_change(int vitesse_change) {
        vitesse += vitesse_change;
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

    public boolean estMort() {
        if (this.pointDeVie <= 0) {
            return true;
        }
        else {return false;}
    }
}


