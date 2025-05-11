package monstres;

public class Dragon extends Monstre {
    public Dragon(int numero) {
        super("Dragon", numero, 100, 10, 0, 10,
                15, "souffle de feu", 6, "3d10");
    }

    @Override
    public void attaquer() {

    }
}