package equipements;
import equipements.Armes.*;
import equipements.Armures.*;

import java.util.ArrayList;
import java.util.List;

public class GestionEquipements {
    public static List<Equipement> initialiserEquipements() {
        List<Equipement> equipements = new ArrayList<>();

        // Armures légères
        equipements.add(new ArmureLegere("Armure d'écailles", 9));
        equipements.add(new ArmureLegere("Demi-plate", 10));

        // Armures lourdes
        equipements.add(new ArmureLourde("Cotte de mailles", 11));
        equipements.add(new ArmureLourde("Harnois", 12));

        // Armes courantes
        equipements.add(new ArmeCourante("Bâton", "1d6"));
        equipements.add(new ArmeCourante("Masse d'armes", "1d6"));

        // Armes de guerre
        equipements.add(new ArmeDeGuerre("Épée longue", "1d8"));
        equipements.add(new ArmeDeGuerre("Rapière", "1d8"));

        // Armes à distance
        equipements.add(new ArmeDistance("Arbalète légère", "1d8", 16));
        equipements.add(new ArmeDistance("Fronde", "1d4", 6));
        equipements.add(new ArmeDistance("Arc court", "1d6", 16));

        return equipements;
    }

    public static void afficherEquipements(List<Equipement> equipements) {
        System.out.println("Liste des équipements disponibles :\n");
        for (Equipement equipement : equipements) {
            System.out.println(equipement);
        }
    }

}
