package equipements.Armes;

public class ArmeCourante extends Armes {


    public ArmeCourante(String nom, String degats) {
        super(nom, degats, 1, "Arme courante");
    }

    @Override
    public String toString() {
        return "Arme Courante : " + getNom() + " [Dégâts : " + getDegats() + "]";
    }

    @Override
    public int getClasseArmure() {
        return 0;
    }
}
