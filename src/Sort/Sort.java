package Sort;

import monstres.Monstre;
import personnages.Joueur;
import personnages.Personnage;

abstract class Sort {
    protected String nom;

    public Sort(String nom)
    {
        this.nom = nom;
    }

    public abstract void utiliser(Joueur cible1, Joueur cible2);
    public abstract void utiliser(Joueur cible1, Monstre cible2);
    public abstract void utiliser(Monstre cible1, Monstre cible2);

    public String getNom()
    {
        return this.nom;
    }
}
