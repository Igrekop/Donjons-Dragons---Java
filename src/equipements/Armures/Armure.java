package equipements.Armures;
import equipements.*;

public abstract class Armure implements Equipement {
    protected String nom;
    protected int classeArmure;
    protected String type;

    public Armure(String nom, int classeArmure, String type) {
        this.nom = nom;
        this.classeArmure = classeArmure;
        this.type = type;
    }

    public int getClasseArmure() {
        return classeArmure;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getModificateurVitesse() {
        return 0;
    }

    @Override
    public int getModificateurForce() {
        return 0;
    }
}
