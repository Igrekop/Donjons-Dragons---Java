package interfacejeu;
import personnages.*;
import monstres.*;
import personnages.Affichable.affichable;

import java.util.List;


public class BarreHaut {
    private static final String barre = "********************************************************************************"; // 1




    public void Affichage(affichable joueurActif, int donj, List<affichable> participants, int tour) {
        System.out.println(barre);
        System.out.println("Donjon " + donj + ":");
        SAL(2);

        System.out.println(joueurActif.getAffichageLong());

        SAL(2);
        System.out.println(barre);
        System.out.println("Tour " + tour + ":");

        for (affichable obj : participants) {
            String prefixe = (obj == joueurActif) ? "-> " : "   ";
            System.out.println(prefixe + obj.getAffichageCourt() + "   " + obj.getAffichageLong());
        }



    }

    public void SAL(int nb){
        for (int n = 0; n<nb;n++) {
            System.out.println();
        }
    }
}
