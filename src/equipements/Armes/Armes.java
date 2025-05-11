package equipements.Armes;
import equipements.*;

public abstract class Armes implements Equipement {
    protected String nom;
    protected String degats;
    protected int portee;
    protected String type;

    public Armes(String nom, String degats, int portee, String type) {
        this.nom = nom;
        this.degats = degats;
        this.portee = portee;
        this.type = type;
    }

    public String getDegats() {
        return degats;
    }

    public int getPortee() {
        return portee;
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
