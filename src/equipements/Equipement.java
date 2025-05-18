package equipements;

public interface Equipement {
    String getNom();
    String getType();
    int getModificateurVitesse();
    int getModificateurForce();
    int getPortee();
    String getDegats();
    int getClasseArmure();
    boolean estArme();
    boolean estArmure();

}
