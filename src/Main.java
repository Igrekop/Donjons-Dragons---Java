import classes.*;
import equipements.*;
import personnages.*;
import races.*;

public class Main {
    public static void main(String args[]) {
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        Classe guerrier = new Guerrier();
        Joueur joueur1 = new Joueur("Thorgal", guerrier);
        System.out.println(joueur1);

        Classe magicien = new Magicien();
        Joueur joueur2 = new Joueur("Gandalf", magicien);
        System.out.println(joueur2);
        joueur2.attaquer(joueur1);
        System.out.println(joueur1);
    }
}