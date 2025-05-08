package classes;

public class Roublard extends Classe{
    public Roublard() {
        super("Roublard", 16);
        genererEquipementDeBase();
    }

    @Override
    public void genererEquipementDeBase() {
        equipement = "Rapière, arc court";
    }
}
