package personnages;
import classes.Classe;
import races.Races;

public class Joueur extends Personnage{
    private Classe classe;
    private Races race;

    public Joueur(String nom, Classe classe, Races race) {
        super(nom, classe.pvDeBase, 0, 0, 0, 0);
        this.classe = classe;
        this.race = race;

        race.appliquerBonus(this);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.nom + " avec : " + classe.getEquipement());
        cible.pointDeVie -= 4;
    }

    public String toString() {
        return "Nom : " + nom + ", Classe : " + classe.nom + ", Race : " + race.nom +
                "\nPV : " + pointDeVie + ", Equipement : " + classe.getEquipement();
    }
}
