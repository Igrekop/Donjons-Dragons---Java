package personnages;

import classes.Classe;

public class Joueur extends Personnage{
    private Classe classe;

    public Joueur(String nom, Classe classe) {
        super(nom, classe.pvDeBase, 0, 0, 0, 0);
        this.classe = classe;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.nom + " avec : " + classe.getEquipement());
        cible.pointDeVie -= 4;
    }

    public String toString() {
        return "Nom :" + nom + ", Classe " + classe.nom + "\n PV : " + pointDeVie + ", Equipement : " + classe.getEquipement();
    }
}
