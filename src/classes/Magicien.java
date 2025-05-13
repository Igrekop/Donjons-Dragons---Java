package classes;

import equipements.Equipement;
import equipements.GestionEquipements;

import java.util.List;

public class Magicien extends Classe {
    public Magicien() {
        super("Magicien", 12);
    }

    @Override
    public void genererEquipementDeBase() {
        getEquipements().clear();
        List<Equipement> equipementsDisponibles = GestionEquipements.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Bâton") ||
                    equipement.getNom().equals("Fronde")){
                getEquipements().add(equipement);
            }
        }

    }
}
