package races;

import personnages.*;

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
        personnage.setInitiative(bonusInitiative);
        personnage.setForce(bonusForce);
        personnage.setDexterite(bonusDexterite);
        personnage.setVitesse(bonusVitesse);
    }

    public String getNom() {
        return nom;
    }

}
