package inter_face;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Joueur;

import java.util.List;

public class map_milieu {
    private Case[][] map;
    private int rows;
    private int cols;
    private String letters;

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
                map[i][j] = new Case();
            }
        }
    }

    private String generateLetters(int cols) {
        StringBuilder sb = new StringBuilder("    ");
        for (char c = 'A'; c < 'A' + cols; c++) {
            sb.append(" ").append(c).append(" ");
        }
        return sb.toString();
    }

    public boolean isValidPositionAndFree(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols
                && map[row][col].accessibleParJoueur();
    }

    public void addObstacle(int row, int col) {
        if (isValidPositionAndFree(row - 1, col - 1)) {
            map[row - 1][col - 1].setContenu(new Obstacle());
        }
    }

    public void addEquipment(int row, int col, Equipement equipement) {
        if (isValidPositionAndFree(row - 1, col - 1)) {
            map[row - 1][col - 1].setContenu(equipement);
        }
    }

    public void UpdateCase(int row, int col, ContenuCase contenu) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            map[row][col].setContenu(contenu);
        }
    }

    public void videCase(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            map[row][col].setContenu(null);
        }
    }

    public Equipement recupererEquipement(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            Object contenu = map[row][col].getContenu();
            if (contenu instanceof ContenuCase contenuCase &&
                    contenuCase.getTypeContenu().equals("Equipement")) {

                Equipement equipement = (Equipement) contenu;
                map[row][col].setContenu(null);
                return equipement;
            }
        }
        return null;
    }


    public void nettoyerParticipants() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Object contenu = map[i][j].getContenu();
                if (contenu instanceof Joueur || contenu instanceof Monstre) {
                    map[i][j].setContenu(null);
                }
            }
        }
    }


    public void Print(List<Object> participants) {
        nettoyerParticipants();
        for (Object obj : participants) {
            if (obj instanceof Joueur joueur) {
                int x = joueur.getPosX()-1;
                int y = joueur.getPosY()-1;

                if (isValidPositionAndFree(x, y)) {
                    map[x][y].setContenu(joueur);
                }
            } else if (obj instanceof Monstre monstre) {
                int x = monstre.getPosX();
                int y = monstre.getPosY();

               if (isValidPositionAndFree(x, y)) {
                    map[x][y].setContenu(monstre);
                }
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

        // Affichage du corps de la carte
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
        System.out.println("    * Equipement   |   [ ] Obstacle");
    }
}
