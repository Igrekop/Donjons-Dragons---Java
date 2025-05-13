package personnages;


import equipements.Equipement;

import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {
    public String nom;
    public int pointDeVie;
    public int force;
    public int dexterite;
    public int vitesse;
    public int initiative;
    private Equipement[] equipementEquipe = new Equipement[2];

    public Personnage (String nom, int pointDeVie, int force, int dexterite, int vitesse, int initiative) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.vitesse = vitesse;
        this.initiative = initiative;


    }

    public abstract void attaquer(Personnage cible);

    public void equiper(int slot, Equipement equipement) {
        if (slot >= 0 && slot < equipementEquipe.length) {
            equipementEquipe[slot] = equipement;
        }
    }

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

}


