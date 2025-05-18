package classes;

import equipements.Equipement;
import equipements.GestionEquipements;

import java.util.ArrayList;
import java.util.List;

public abstract class Classe {
    private String m_nom;
    private int m_pvDeBase;
    private List<Equipement> m_equipements;

    public Classe(String nom, int pvDeBase) {
        this.m_nom = nom;
        this.m_pvDeBase = pvDeBase;
        m_equipements = GestionEquipements.initialiserEquipements();
        genererEquipementDeBase();
    }

    protected abstract void genererEquipementDeBase();

    public String getNom() {
        return m_nom;
    }

    public int getPvDeBase() {
        return m_pvDeBase;
    }

    public List<Equipement> getEquipements() {
        return m_equipements;
    }

    @Override
    public String toString() {
        return "Classe: " + m_nom + ", PV de base: " + m_pvDeBase + ", Equipements: " + m_equipements;
    }
}
