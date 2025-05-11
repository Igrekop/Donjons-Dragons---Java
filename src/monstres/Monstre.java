package monstres;

public abstract class Monstre {
    public String espece;
    public int numero;
    public int pointDeVie;
    public int force;
    public int dexterite;
    public int initiative;
    public int classeArmure;
    public String typeAttaque;
    public int portee;
    public String degats;

    public Monstre(String espece, int numero, int pointDeVie, int force, int dexterite, int initiative,
                   int classeArmure, String typeAttaque, int portee, String degats) {
        this.espece = espece;
        this.numero = numero;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.initiative = initiative;
        this.classeArmure = classeArmure;
        this.typeAttaque = typeAttaque;
        this.portee = portee;
        this.degats = degats;
    }

    public abstract void attaquer();

    public String toString() {
        return espece + " #" + numero + " [PV: " + pointDeVie + ", Attaque: " + typeAttaque +
                ", Dégâts: " + degats + ", Portée: " + portee + "]";
    }
}