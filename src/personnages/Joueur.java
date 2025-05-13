package personnages;
import classes.Classe;
import equipements.Equipement;
import monstres.*;
import races.Races;

public class Joueur extends Personnage{
    private Classe classe;
    private Races race;

    public Joueur(String nom, Classe classe, Races race) {
        super(nom, classe.getPvDeBase(), 0, 0, 0, 0);
        this.classe = classe;
        this.race = race;

        race.appliquerBonus(this);
    }

    @Override
    public void attaquer(Monstre cible) {
        System.out.println(getNom() + " attaque " + cible.getEspece());
        cible.setPointdeVie(4);
        System.out.println(cible.getEspece() + " : " + cible.getPointdeVie());
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
        sb.append("Nom : ").append(getNom()).append("\n")
                .append("Race : ").append(race.getNom()).append("\n")
                .append("Classe : ").append(classe.getNom()).append("\n")
                .append("PV : ").append(getPointDeVie()).append("\n")
                .append("Force : ").append(getForce()).append("\n")
                .append("Dextérité : ").append(getDexterite()).append("\n")
                .append("Vitesse : ").append(getVitesse()).append("\n")
                .append("Initiative : ").append(getInitiative()).append("\n")
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