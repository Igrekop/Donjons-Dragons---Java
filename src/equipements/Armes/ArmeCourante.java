package equipements.Armes;

public class ArmeCourante extends Armes {
    public ArmeCourante(String nom, String degats) {
        super(nom, degats, 1, "Arme courante");
    }

    public String toString() {
        return "Arme Courante : " + nom + " [Déqâts : " + degats + "]";
    }

    @Override
    public int getClasseArmure() {
        return 0;
    }
}
