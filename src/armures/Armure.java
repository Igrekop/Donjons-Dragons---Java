package armures;

import personnages.Personnage;

public class Armure {
    public String nom;
    public int classeArmure;
    public boolean estLourde;

    public Armure(String nom, int classeArmure, boolean estLourde) {
        this.nom = nom;
        this.classeArmure = classeArmure;
        this.estLourde = estLourde;
    }

    @Override
    public String toString() {
        return nom + " [Classe Armure: " + classeArmure + ", Type: " + estLourde + "]";
    }

    public void Buff_Debuff(Personnage per){}
}