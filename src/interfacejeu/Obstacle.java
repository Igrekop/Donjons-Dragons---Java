package interfacejeu;

public class Obstacle implements ContenuCase {

    @Override
    public String getTypeContenu() {
        return "Obstacle";
    }

    @Override
    public String afficher() {
        return "[ ]";
    }
}
