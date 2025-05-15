package equipements.Armures;

public class ArmureLegere extends Armure {
    public ArmureLegere(String nom, int classeArmure) {
        super(nom, classeArmure, "Armure légère");
    }

    @Override
    public String toString() {
        return "Armure légère : " + nom + " [Classe d'armure : " + classeArmure + "]";
    }

    @Override
    public int getPortee() {
        return 0;
    }

    @Override
    public String getDegats() {
        return "";
    }
}