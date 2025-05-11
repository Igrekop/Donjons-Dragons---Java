package equipements.Armures;

public class ArmureLourde extends Armure {
    public ArmureLourde(String nom, int classeArmure) {
        super(nom, classeArmure, "Armure lourde");
    }

    @Override
    public int getModificateurVitesse() {
        return -4;  // Réduction de la vitesse
    }
}
