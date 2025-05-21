package inter_face;
import personnages.*;
import monstres.*;

import java.util.List;


public class Barre_haut {
    private static final String barre = "********************************************************************************"; // 1




    public void Affichage(Object J0, int donj, List<Object> participants, int tour) {
        System.out.println(barre);
        System.out.println("Donjon " + donj + ":");
        SAL(2);

        if (J0 instanceof Joueur joueur) {
            System.out.println(joueur.getNom() + " (" + joueur.getClasse().getNom() + " " + joueur.getRace().getNom() + ")");
        } else if (J0 instanceof Monstre monstre) {
            System.out.println(monstre.getEspece() + " (" + monstre.getPointDeVie() + " PV)");
        }

        SAL(2);
        System.out.println(barre);
        System.out.println("Tour " + tour +":");
        for (Object obj : participants) {
            String prefixe = (obj == J0) ? "-> " : "   ";
            if (obj instanceof Joueur ) {
                Joueur joueur = (Joueur) obj;
                String pseudo = joueur.getNom().substring(0, 3);
                System.out.println(prefixe  + pseudo + "   " +joueur.getNom() + " (" + joueur.getClasse().getNom() +" "+ joueur.getRace().getNom()  +", " + joueur.getPointDeVie() + "/" + joueur.getPVdebase() + " HP)");
            } else if (obj instanceof Monstre) {
                Monstre monstre = (Monstre) obj;
                System.out.println(prefixe + monstre.afficher() + "    " + monstre.getEspece() + " (" + monstre.getPointDeVie() + "/" + monstre.getPvDeBase() + " HP)");
            }
        }



    }

    public void SAL(int nb){
        for (int n = 0; n<nb;n++) {
            System.out.println();
        }
    }
}
