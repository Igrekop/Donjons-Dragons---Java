package races;

import personnages.*;
import Des.*;

public abstract class Races {
    public String nom;
    protected int bonusForce;
    protected int bonusDexterite;
    protected int bonusVitesse;
    protected int bonusPV;
    protected int bonusInitiative;

    public Races(String nom, int bonusForce, int bonusDexterite, int bonusVitesse, int bonusInitiative, int bonusPV) {
        this.nom = nom;
        this.bonusForce = bonusForce;
        this.bonusDexterite = bonusDexterite;
        this.bonusVitesse = bonusVitesse;
        this.bonusInitiative = bonusInitiative;
        this.bonusPV = bonusPV;
    }

    public void appliquerBonus(Personnage personnage) {
        personnage.addPdV(bonusPV);
        personnage.setInitiative(Des.lancerDes("4d4") + 3 + bonusInitiative);
        personnage.setForce(Des.lancerDes("4d4") + 3 + bonusForce);
        personnage.setDexterite(Des.lancerDes("4d4") + 3 + bonusDexterite);
        personnage.setVitesse(Des.lancerDes("4d4") + 3 + bonusVitesse);
    }

    public String getNom() {
        return nom;
    }

}
