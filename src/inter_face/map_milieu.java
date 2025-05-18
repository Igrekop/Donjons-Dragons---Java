package inter_face;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Joueur;

import java.util.List;

public class map_milieu {
    private String letters;
    private Case[][] map;
    private int rows;
    private int cols;

    public map_milieu(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.map = new Case[rows][cols];
        this.letters = generateLetters(cols);
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = new Case();  // Chaque case est une instance Case vide
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
        if (isValidPositionAndFree(row - 1, col - 1)) {
            map[row - 1][col - 1].setContenu(new Obstacle());
        }
    }

    public void addEquipment(int row, int col) {
        if (isValidPositionAndFree(row, col)) {
            map[row-1][col-1].setContenu("*");
        }
    }

    public boolean isValidPositionAndFree(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && map[row][col].estVide();
    }



    public void UpdateCae(int row, int col, String contenu) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            map[row][col].setContenu(contenu);
        }
    }

    public void videCase(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            map[row][col].setContenu(".");
        }
    }

    public Equipement recupererEquipement(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            Object contenu = map[row][col].getContenu();
            if (contenu instanceof Equipement equipement) {
                map[row][col].setContenu(null); // Vide la case
                return equipement;  // Retourne l'objet Equipement récupéré
            }
        }
        return null; // Pas d'équipement ou position invalide
    }





    public void Print(List<Object> participants) {
        // Placement dynamique des participants
        int startRow = 13;
        int col = 12;
        for (Object obj : participants) {
            if (startRow >= rows) break;

            String pseudo = "";
            int offset = 0;

            if (obj instanceof Joueur joueur) {
                pseudo = joueur.getNom();
                offset = 0;
            } else if (obj instanceof Monstre monstre) {
                pseudo = monstre.getEspece();
                offset = 2;
            }

            if (pseudo.length() > 3) {
                pseudo = pseudo.substring(0, 3);
            }

            int targetCol = col + offset;
            if (targetCol < cols && map[startRow][targetCol].estVide()) {
                map[startRow][targetCol].setContenu(pseudo);
                startRow++;
            }
        }

        // Affichage de l'en-tête
        System.out.println(letters);

        // Ligne supérieure
        System.out.print("   *");
        for (int i = 0; i < cols * 3 + 1; i++) {
            System.out.print("-");
        }
        System.out.println("*");

        // Corps de la carte
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1 < 10 ? " " : "") + (i + 1) + " |");

            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j].afficher());
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
