package personnages;
import classes.Classe;
import equipements.Equipement;
import races.Races;

public class Joueur extends Personnage{
    private Classe classe;
    private Races race;

    public Joueur(String nom, Classe classe, Races race) {
        super(nom, classe.getPvDeBase(), 0, 0, 0, 0);
        this.classe = classe;
        this.race = race;

        race.appliquerBonus(this);
        for (Equipement equipement : classe.getEquipements()) {
            this.force += equipement.getModificateurForce();
            this.vitesse += equipement.getModificateurVitesse();
        }
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.nom);
        cible.pointDeVie -= 4;
    }
    //Pour après les équipements
    /*public void equiper(Equipement equipement) {
        if (this.equipement != null) {
            // Déséquiper l'ancien équipement (restauration des stats)
            this.force -= this.equipement.getModificateurForce();
            this.vitesse -= this.equipement.getModificateurVitesse();
        }

        this.equipement = equipement;

        // Appliquer les bonus de l'équipement
        this.force += equipement.getModificateurForce();
        this.vitesse += equipement.getModificateurVitesse();
    }*/


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom : ").append(nom).append("\n")
                .append("Race : ").append(race.getNom()).append("\n")
                .append("Classe : ").append(classe.getNom()).append("\n")
                .append("PV : ").append(pointDeVie).append("\n")
                .append("Force : ").append(force).append("\n")
                .append("Dextérité : ").append(dexterite).append("\n")
                .append("Vitesse : ").append(vitesse).append("\n")
                .append("Initiative : ").append(initiative).append("\n")
                .append("Équipements : \n");

        for (Equipement equipement : classe.getEquipements()) {
            sb.append(" - ").append(equipement).append("\n");
        }

        return sb.toString();
    }

    public Classe getClasse() {
        return classe;
    }

    public Races getRace() {
        return race;
    }
}