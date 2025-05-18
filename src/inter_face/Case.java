package inter_face;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Joueur;

public class Case {
    private Object contenu;  // Contenu générique : peut être String, Equipement, Joueur, Monstre, etc.

    public Case() {
        this.contenu = null; // Case vide par défaut
    }

    public Object getContenu() {
        return contenu;
    }

    public void setContenu(Object contenu) {
        this.contenu = contenu;
    }

    public boolean estVide() {
        return contenu == null;
    }

    public String afficher() {
        if (contenu == null) return " . ";
        if (contenu instanceof Obstacle ) return "[ ]";
        if (contenu instanceof Equipement) return " * ";
        if (contenu instanceof Joueur joueur) return formatNom(joueur.getNom());
        if (contenu instanceof Monstre monstre) return formatNom(monstre.getEspece());
        return " ? ";
    }

    private String formatNom(String nom) {
        return nom.length() > 3 ? nom.substring(0, 3) : String.format("%-3s", nom);
    }

}
