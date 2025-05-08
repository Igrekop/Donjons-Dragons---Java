package classes;

public class Guerrier extends Classe{
    public Guerrier() {
        super("Guerrier", 20);
        genererEquipementDeBase();
    }

    @Override
    public void genererEquipementDeBase() {
        equipement = "Cotte de mailles, épée longue, arbalète légère";
    }
}
