package classes;

import equipements.Equipement;
import equipements.GestionEquipements;

import java.util.List;

public class Clerc extends Classe {
    public Clerc() {
        super("Clerc", 16);
    }

    @Override
    public void genererEquipementDeBase() {
        getEquipements().clear();
        List<Equipement> equipementsDisponibles = GestionEquipements.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Masse d'armes") ||
                    equipement.getNom().equals("Armure d'écailles") ||
                    equipement.getNom().equals("Arbalète légère")) {
                getEquipements().add(equipement);
            }
        }


    }
}
