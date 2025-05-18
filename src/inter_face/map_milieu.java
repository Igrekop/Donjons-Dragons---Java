package inter_face;

import monstres.Monstre;
import personnages.Joueur;

import java.util.List;

public class map_milieu {
    private static final String letters = "      A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W";
    private final String[][] map = new String[20][20]; // map[row][col]

    public void Affichage( List<Object> participants) {
        // Initialisation de la carte
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = ".";
            }
        }

        // Exemple de placement d'objets
        map[4][10] = "*";     // Obstacle
        map[8][10] = "[ ]";   // Équipement
        // Placement dynamique des participants
        int startRow = 13;
        int col = 12;
        for (Object obj : participants) {
            if (obj instanceof Joueur joueur) {
                String pseudo = joueur.getNom();
                if (pseudo.length() > 3) {
                    pseudo = pseudo.substring(0, 3);
                }

                if (startRow < 18) {
                    map[startRow][col] = pseudo;
                    startRow++;
                }
            }

            // Si tu veux gérer aussi les monstres, ajoute ici :

        else if (obj instanceof Monstre monstre) {
            String pseudo = monstre.getEspece();
            if (pseudo.length() > 3) {
                pseudo = pseudo.substring(0, 3);
            }

            if (startRow < 18) {
                map[startRow][col + 2] = pseudo;
                startRow++;
            }
        }

        }


        // Affichage de l'en-tête (lettres A à W)
        System.out.print("      ");
        for (char c = 'A'; c <= 'W'; c++) {
            System.out.print(" " + c + " ");
        }
        System.out.println();

        // Ligne supérieure
        System.out.print("   *");
        for (int i = 0; i < 71; i++) {
            System.out.print("-");
        }
        System.out.println("*");

        // Corps de la carte
        for (int i = 0; i < 18; i++) {
            // Gérer l'alignement des numéros de ligne
            if (i + 1 < 10) {
                System.out.print(" " + (i + 1) + " |"); // Pour les numéros de ligne de 1 à 9
            } else {
                System.out.print((i + 1) + " |");         // Pour les numéros de ligne de 10 à 18
            }

            // Affichage des cases de la carte
            for (int j = 0; j < 23; j++) {
                if (map[i][j].length() ==3) { System.out.print( map[i][j] );}
                else {System.out.print(" " + map[i][j] + " ");}
            }
            System.out.println("|");
        }

        // Ligne inférieure
        System.out.print("   *");
        for (int i = 0; i < 71; i++) {
            System.out.print("-");
        }
        System.out.println("*");

        // Légende
        System.out.println("    * Equipement   |   [ ] Obstacle  |");
    }

}
