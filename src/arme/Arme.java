package arme;

import personnages.Personnage;

public abstract class Arme {
    public String nom;
    public String dégats;
    public int portee;

    public Arme(String nom, String degats, int portee) {
        this.nom = nom;
        this.dégats = degats;
        this.portee = portee;
    }

    public void Buff_Debuff(Personnage per){}


}
