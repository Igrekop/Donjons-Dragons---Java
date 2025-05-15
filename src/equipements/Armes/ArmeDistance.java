package equipements.Armes;

public class ArmeDistance extends Armes {
    public ArmeDistance(String nom, String degats, int portee) {
        super(nom, degats, portee, "Arme à distance");
    }

    public String toString() {
        return "Arme à distance : " + nom + " [Déqâts : " + degats +  ", Portée : " + portee + "]";
    }

    @Override
    public int getClasseArmure() {
        return 0;
    }
}
