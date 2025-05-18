package classes;

import equipements.Equipement;
import equipements.GestionEquipements;
import java.util.List;

public class Guerrier extends Classe {
    public Guerrier() {
        super("Guerrier", 20);
    }

    @Override
    public void genererEquipementDeBase() {
        getEquipements().clear();
        List<Equipement> equipementsDisponibles = GestionEquipements.initialiserEquipements();
        for (Equipement equipement : equipementsDisponibles) {
            if (equipement.getNom().equals("Cotte de mailles") ||
                    equipement.getNom().equals("Épée longue") ||
                    equipement.getNom().equals("Arbalète légère")) {
                getEquipements().add(equipement);
            }
        }
    }
    @Override
    public String toString() {
        return "Classe Guerrier: " + super.toString();
    }
}
