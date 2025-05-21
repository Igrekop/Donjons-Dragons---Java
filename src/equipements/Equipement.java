package equipements;

import inter_face.ContenuCase;

public interface Equipement  extends ContenuCase {
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
