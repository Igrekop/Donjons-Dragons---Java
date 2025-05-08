package armures;

import personnages.Personnage;

public class Lourd extends Armure {
    public Lourd(String nom, int classeArmure) {
        super(nom, classeArmure, true);  // true = lourde
    }



    @Override
    public void Buff_Debuff(Personnage p) {

        p.debuff("vitesse", 4);
    }


}
