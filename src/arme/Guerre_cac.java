package arme;

import personnages.Personnage;

public class Guerre_cac extends Arme {

    public Guerre_cac(String nom, String degats) {
        super(nom, degats, 1);
    }

    @Override
    public void Buff_Debuff(Personnage per) {
        per.buff("force", 4);
        per.debuff("vitesse", 2);
    }
}