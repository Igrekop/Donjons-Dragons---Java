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
        equipements.clear();
        List<Equipement> equipementsDisponibles = GestionEquipements.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Bâton") ||
                    equipement.getNom().equals("Fronde")){
                equipements.add(equipement);
            }
        }
    }
}
