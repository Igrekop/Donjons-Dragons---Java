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

public class Joueur extends Personnage {
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
        afficherAttaque(getNom(), cible.getEspece(), getEquiper().getFirst().getNom());

        int jetAttaque = Des.lancerDes("1d20");
        int modificateur = 0;
        int degats = 0;

        Equipement arme = equipementEquipe[0];
        if (arme != null) {
            if (arme.getType().contains("Arme à distance")) {
                modificateur = getDexterite();
            } else if (arme.getType().contains("Arme de guerre") || arme.getType().contains("Arme courante")) {
                modificateur = getForce();
            }
        }

        jetAttaque += modificateur;
        afficherJetAttaque(jetAttaque);

        if (arme != null && arme.getPortee() < 2) {
            afficherPortee(1);
        }

        if (jetAttaque > cible.getClasseArmure()) {
            afficherAttaqueReussie();
            if (arme != null) {
                degats = Des.lancerDes(arme.getDegats());
            }
            afficherDegats(degats);
            cible.subirDegats(degats);
            afficherPvRestants(cible.getEspece(), cible.getPointDeVie());
        } else {
            afficherAttaqueEchouee();
        }
    }

    public void equiper(Equipement equipement, Object equipe) {
        int forceAvant = getForce();
        int vitesseAvant = getVitesse();

        // Vérifier si l'équipement est déjà équipé et le retirer si nécessaire
        if (equipement.estArme()) {
            if (equipementEquipe[0] != null) {
                setForce(getForce() - equipementEquipe[0].getModificateurForce());
                setVitesse(getVitesse() - equipementEquipe[0].getModificateurVitesse());
                classe.getEquipements().add(equipementEquipe[0]);
            }
            equipementEquipe[0] = equipement;
        } else if (equipement.estArmure()) {
            if (equipementEquipe[1] != null) {
                setVitesse(getVitesse() - equipementEquipe[1].getModificateurVitesse());
                classe.getEquipements().add(equipementEquipe[1]);
            }
            equipementEquipe[1] = equipement;
        }

        setForce(getForce() + equipement.getModificateurForce());
        setVitesse(getVitesse() + equipement.getModificateurVitesse());

        afficherEquipement(getNom(), equipement.getNom(), forceAvant, getForce(), vitesseAvant, getVitesse());
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

    private Equipement getDernierEquipement() {
        return getEquiper().getLast();
    }

    public int getClasseArmureActuelle() {
        Equipement equipement = getDernierEquipement();
        return equipement != null ? equipement.getClasseArmure() : 0;
    }

    private void afficherAttaque(String nomAttaquant, String especeCible, String nomArme) {
        System.out.println(nomAttaquant + " attaque " + especeCible + " avec " + nomArme + " !");
    }

    private void afficherJetAttaque(int jet) {
        System.out.println("Jet d'attaque : " + jet);
    }

    private void afficherAttaqueReussie() {
        System.out.println("Attaque réussie!");
    }

    private void afficherDegats(int degats) {
        System.out.println("Dégâts infligés : " + degats);
    }

    private void afficherPortee(int portee) {
        System.out.println("Portée de : " + portee);
    }

    private void afficherPvRestants(String cible, int pv) {
        System.out.println(cible + " PV restants : " + pv);
    }

    private void afficherAttaqueEchouee() {
        System.out.println("Attaque échouée!");
    }

    private void afficherEquipement(String nom, String equipement, int forceAvant, int forceApres, int vitesseAvant, int vitesseApres) {
        System.out.println("[ÉQUIPEMENT] " + nom + " équipe : " + equipement);
        System.out.println("Force avant : " + forceAvant + ", Force après : " + forceApres);
        System.out.println("Vitesse avant : " + vitesseAvant + ", Vitesse après : " + vitesseApres);
    }
}
