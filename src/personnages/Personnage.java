package personnages;

public abstract class Personnage {
    public String nom;
    public int pointDeVie;
    public int force;
    public int dexterite;
    public int vitesse;
    public int initiative;

    public Personnage (String nom, int pointDeVie, int force, int dexterite, int vitesse, int initiative) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.force = force;
        this.dexterite = dexterite;
        this.vitesse = vitesse;
        this.initiative = initiative;
    }

    public abstract void attaquer(Personnage cible);

    public void buff(String stat, int valeur) {
        switch (stat.toLowerCase()) {
            case "force":
                this.force += valeur;
                break;
            case "vitesse":
                this.vitesse += valeur;
                break;
            case "dexterite":
                this.dexterite += valeur;
                break;
            case "pointDeVie":
                this.pointDeVie += valeur;
                break;
            case "initiative":
                this.initiative += valeur;
                break;
            default:
                System.out.println("Stat inconnue : " + stat);
        }
    }

    public void debuff(String stat, int valeur) {
        buff(stat, -valeur);
    }


}


