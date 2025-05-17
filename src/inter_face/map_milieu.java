package inter_face;

import monstres.Monstre;
import personnages.Joueur;

import java.util.List;

public class map_milieu {
    private  String letters;
    private  String[][] map;
    private  int rows;
    private int cols;

    public map_milieu(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.map = new String[rows][cols];
        this.letters = generateLetters(cols);
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = ".";
            }
        }
    }

    private String generateLetters(int cols) {
        StringBuilder sb = new StringBuilder("      ");
        for (char c = 'A'; c < 'A' + cols; c++) {
            sb.append(" ").append(c).append(" ");
        }
        return sb.toString();
    }

    public void addObstacle(int row, int col) {
        if (isValidPosition(row, col)) {
            map[row][col] = "*"; // Obstacle
        }
    }

    public void addEquipment(int row, int col) {
        if (isValidPosition(row, col)) {
            map[row][col] = "[ ]"; // Équipement
        }
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && map[row][col].equals(".");
    }

    public void Affichage(List<Object> participants) {
        // Placement dynamique des participants
        int startRow = 13;
        int col = 12;
        for (Object obj : participants) {
            if (obj instanceof Joueur joueur) {
                String pseudo = joueur.getNom();
                if (pseudo.length() > 3) {
                    pseudo = pseudo.substring(0, 3);
                }

                if (startRow < rows) {
                    map[startRow][col] = pseudo;
                    startRow++;
                }
            } else if (obj instanceof Monstre monstre) {
                String pseudo = monstre.getEspece();
                if (pseudo.length() > 3) {
                    pseudo = pseudo.substring(0, 3);
                }

                if (startRow < rows) {
                    map[startRow][col + 2] = pseudo;
                    startRow++;
                }
            }
        }

        // Affichage de l'en-tête
        System.out.print(letters);
        System.out.println();

        // Ligne supérieure
        System.out.print("   *");
        for (int i = 0; i < cols * 3 + 1; i++) {
            System.out.print("-");
        }
        System.out.println("*");

        // Corps de la carte
        for (int i = 0; i < rows; i++) {
            // Gérer l'alignement des numéros de ligne
            System.out.print((i + 1 < 10 ? " " : "") + (i + 1) + " |");

            // Affichage des cases de la carte
            for (int j = 0; j < cols; j++) {
                if (map[i][j].length() == 3) {
                    System.out.print(map[i][j]);
                } else {
                    System.out.print(" " + map[i][j] + " ");
                }
            }
            System.out.println("|");
        }

        // Ligne inférieure
        System.out.print("   *");
        for (int i = 0; i < cols * 3 + 1; i++) {
            System.out.print("-");
        }
        System.out.println("*");

        // Légende
        System.out.println("    * Equipement   |   [ ] Obstacle  |");
    }
}
