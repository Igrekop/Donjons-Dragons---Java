package classes;

import equipements.Equipement;
import equipements.GestionEquipements;

import java.util.List;

public class Roublard extends Classe {
    public Roublard() {
        super("Roublard", 16);
    }

    @Override
    public void genererEquipementDeBase() {
        equipements.clear();
        List<Equipement> equipementsDisponibles = GestionEquipements.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Rapière") ||
                    equipement.getNom().equals("Arc court")) {
                equipements.add(equipement);
            }
        }
    }
}
