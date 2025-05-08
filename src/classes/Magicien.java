package classes;

public class Magicien extends Classe{
    public Magicien() {
        super("Magicien", 12);
        genererEquipementDeBase();
    }

    @Override
    public void genererEquipementDeBase() {
        equipement = "Bâton, fronde";
    }
}
