package classes;

public class Clerc extends Classe{
    public Clerc() {
        super("Clerc", 16);
        genererEquipementDeBase();
    }

    @Override
    public void genererEquipementDeBase() {
        equipement = "Masse d'armes, armure d'écailles, arbalète légère";
    }
}
