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
        getEquipements().clear();
        List<Equipement> equipementsDisponibles = GestionEquipements.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Rapière") ||
                    equipement.getNom().equals("Arc court")) {
                getEquipements().add(equipement);
            }
        }
    }
}
