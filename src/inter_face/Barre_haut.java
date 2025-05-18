package inter_face;
import personnages.*;
import monstres.*;

import java.util.List;


public class Barre_haut {
    private static final String barre = "********************************************************************************"; // 1




    public void Affichage(Joueur J0, int donj, List<Object> participants, int tour) {
        System.out.println(barre);
        System.out.println("Donjon " + donj + ":");
        SAL(2);
        System.out.println(J0.getNom() +" ("+ J0.getClasse().getNom() + J0.getRace().getNom()+")");
        SAL(2);
        System.out.println(barre);
        System.out.println("Tour " + tour +":");
        for (Object obj : participants) {
            if (obj instanceof Joueur ) {
                Joueur joueur = (Joueur) obj;
                String prefixe = (joueur == J0) ? "-> " : "   ";
                String pseudo = joueur.getNom().substring(0, 3);
                System.out.println(prefixe  + pseudo + "   " +joueur.getNom() + " (" + joueur.getClasse().getNom() +" "+ joueur.getRace().getNom()  +", " + joueur.getPointDeVie() + ")");
            } else if (obj instanceof Monstre) {
                Monstre monstre = (Monstre) obj;
                System.out.println("Monstre: " + monstre.getEspece() + ", " + monstre.getPointDeVie());
            }
        }



    }

    public void SAL(int nb){
        for (int n = 0; n<nb;n++) {
            System.out.println();
        }
    }
}
