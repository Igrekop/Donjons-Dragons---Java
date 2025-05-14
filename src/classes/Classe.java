package classes;

import equipements.Equipement;
import equipements.GestionEquipements;

import java.util.ArrayList;
import java.util.List;

public abstract class Classe {
    private String nom;
    private int pvDeBase;
    private List<Equipement> equipements;

    public Classe(String nom, int pvDeBase) {
        this.nom = nom;
        this.pvDeBase = pvDeBase;
        equipements = GestionEquipements.initialiserEquipements();
        genererEquipementDeBase();
    }

    protected abstract void genererEquipementDeBase();

    public String getNom() {
        return nom;
    }

    public int getPvDeBase() {
        return pvDeBase;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }
}