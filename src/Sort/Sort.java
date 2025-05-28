package Sort;

import interfacejeu.map_milieu;
import monstres.Monstre;
import personnages.Joueur;
import personnages.Personnage;
import personnages.Entité.entite;

abstract class Sort {
    protected String nom;

    public Sort(String nom)
    {
        this.nom = nom;
    }

    public abstract void utiliser(Joueur cible1, Joueur cible2);
    public abstract void utiliser(entite cible1, entite cible2);

    public String getNom()
    {
        return this.nom;
    }

}
