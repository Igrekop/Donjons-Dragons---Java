package armures;

public class Legere extends Armure {
    public Legere(String nom, int classeArmure) {
        super(nom, classeArmure, false);  // false = pas lourde
    }

    // Pas d'effet de buff/débuff pour les armures légères
}
