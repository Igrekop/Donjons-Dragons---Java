package classes;

import equipements.Equipement;
import equipements.GestionEquipements;

import java.util.ArrayList;
import java.util.List;

public abstract class Classe {
    private String nom;
    private int pvDeBase;
    private List<Equipement> equipements;
    private Equipement[] equipementEquipe = new Equipement[2];

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


}
