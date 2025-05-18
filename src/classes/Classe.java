package classes;

import equipements.Equipement;
import equipements.GestionEquipements;
import personnages.Joueur;

import java.util.ArrayList;
import java.util.List;

public abstract class Classe {
    private String m_nom;
    private int m_pvDeBase;

    public Classe(String nom, int pvDeBase) {
        this.m_nom = nom;
        this.m_pvDeBase = pvDeBase;
    }

    public abstract void genererEquipementDeBase(Joueur joueur);

    public String getNom() {
        return m_nom;
    }

    public int getPvDeBase() {
        return m_pvDeBase;
    }


    @Override
    public String toString() {
        return "Classe: " + m_nom + ", PV de base: " + m_pvDeBase;
    }
}
