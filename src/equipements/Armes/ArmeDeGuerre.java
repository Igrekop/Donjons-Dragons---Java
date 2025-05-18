package equipements.Armes;

public class ArmeDeGuerre extends Armes {

    public ArmeDeGuerre(String nom, String degats) {
        super(nom, degats, 1, "Arme de guerre");
    }

    @Override
    public int getModificateurVitesse() {
        return -2;  // Réduction de la vitesse
    }

    @Override
    public int getModificateurForce() {
        return 4;   // Augmentation de la force
    }

    @Override
    public int getClasseArmure() {
        return 0;
    }

    @Override
    public String toString() {
        return "Arme de guerre : " + getNom() + " [Dégâts : " + getDegats() + "]";
    }
}
