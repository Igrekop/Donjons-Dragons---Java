package equipements.Armures;

public class ArmureLourde extends Armure {
    public ArmureLourde(String nom, int classeArmure) {
        super(nom, classeArmure, "Armure lourde");
    }

    @Override
    public int getModificateurVitesse() {
        return -4;  // Réduction de la vitesse
    }

    @Override
    public int getPortee() {
        return 0;
    }

    @Override
    public String getDegats() {
        return "";
    }

    @Override
    public String toString() {
        return "Armure lourde : " + nom + " [Classe d'armure : " + classeArmure + "]";
    }

    @Override
    public int getClasseArmure() {
        return classeArmure;
    }

}
