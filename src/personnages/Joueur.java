package personnages;
import classes.Classe;
import equipements.Equipement;
import equipements.GestionEquipements;
import monstres.*;
import races.Races;
import equipements.Armes.Armes;
import equipements.Armures.Armure;
import Des.*;

import java.util.List;

public class Joueur extends Personnage{
    private Classe classe;
    private Races race;


    public Joueur(String nom, Classe classe, Races race) {
        super(nom, classe.getPvDeBase(), 0, 0, 0, 0);
        this.classe = classe;
        this.race = race;

        race.appliquerBonus(this);

        GestionEquipements.equiperPremiereArmeEtArmure(this, classe.getEquipements());
    }

    public void attaquer(Monstre cible) {
        System.out.println(getNom() + " attaque " + cible.getEspece());

        int jetAttaque = Des.lancerDes("1d20");
        int modificateur = 0;
        int degats = 0;

        // Vérification du type d'arme
        Equipement arme = equipementEquipe[0];
        if (arme != null) {
            if (arme.getType().contains("Arme à distance")) {
                modificateur = getDexterite();
            } else if (arme.getType().contains("Arme de guerre") || arme.getType().contains("Arme courante")) {
                modificateur = getForce();
            }
        }

        jetAttaque += modificateur;
        System.out.println("Jet d'attaque : " + jetAttaque);

        // Vérification de la portée
        if (arme != null && arme.getPortee() < 2) {
            System.out.println("L'arme est de corps-à-corps, portée : 1 case");
        }

        if (jetAttaque > cible.getClasseArmure()) {
            System.out.println("Attaque réussie!");
            if (arme != null) {
                degats = Des.lancerDes(arme.getDegats());
            }
            System.out.println("Dégâts infligés : " + degats);
            cible.setPointdeVie(degats);
            System.out.println(cible.getEspece() + " PV restants : " + cible.getPointdeVie());
        } else {
            System.out.println("Attaque échouée!");
        }
    }


    public void equiper(Equipement equipement, Object equipe) {
        int forceAvant = getForce();
        int vitesseAvant = getVitesse();

        // Vérifier si l'équipement est déjà équipé et le retirer si nécessaire
        if (equipement instanceof Armes) {
            if (equipementEquipe[0] != null) {
                setForce(getForce() - equipementEquipe[0].getModificateurForce());
                setVitesse(getVitesse() - equipementEquipe[0].getModificateurVitesse());
                classe.getEquipements().add(equipementEquipe[0]);
            }
            equipementEquipe[0] = equipement;
        } else if (equipement instanceof Armure) {
            if (equipementEquipe[1] != null) {
                setVitesse(getVitesse() - equipementEquipe[1].getModificateurVitesse());
                classe.getEquipements().add(equipementEquipe[1]);
            }
            equipementEquipe[1] = equipement;
        }

        // Appliquer les bonus/malus de l'équipement équipé
        setForce(getForce() + equipement.getModificateurForce());
        setVitesse(getVitesse() + equipement.getModificateurVitesse());

        System.out.println("[ÉQUIPEMENT] " + getNom() + " équipe : " + equipement.getNom());
        System.out.println("Force avant : " + forceAvant + ", Force après : " + getForce());
        System.out.println("Vitesse avant : " + vitesseAvant + ", Vitesse après : " + getVitesse());
    }


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