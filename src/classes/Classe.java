package classes;

import equipements.EquipementDeBase;

public abstract class Classe implements EquipementDeBase {
    public String nom;
    public int pvDeBase;
    public String equipement;

    public Classe(String nom, int pvDeBase) {
        this.nom = nom;
        this.pvDeBase = pvDeBase;
    }

    public String getEquipement() {
        return equipement;
    }

}
