package monstres;

public class Gobelin extends Monstre {
    public Gobelin(int numero) {
        super("Gobelin", numero, 10, 4, 6, 5,
                9, "coup de dague", 1, "1d6");
    }

    @Override
    public void attaquer() {

    }
}


