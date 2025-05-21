package inter_face;

import equipements.Equipement;
import monstres.Monstre;
import personnages.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if(row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        return map[row][col].estVide();
    }

    public void addObstacle(int row, int col) {
        if(row >= 0 && row < rows && col >= 0 && col < cols) {
            map[row][col].setContenu(new Obstacle());
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

    public List<Equipement> recupererEquipementsAdjacents(int row, int col) {
        List<Equipement> equipementsTrouves = new ArrayList<>();


        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                ContenuCase contenu = map[newRow][newCol].getContenu();
                if (contenu != null && "Equipement".equals(map[newRow][newCol].getContenu().getTypeContenu())) {
                    equipementsTrouves.add((Equipement) contenu);
                }
            }
        }

        return equipementsTrouves;
    }

    public Equipement recupererEquipement(int row, int col) {
        List<Equipement> equipements = recupererEquipementsAdjacents(row, col);

        if (equipements.isEmpty()) {
            System.out.println("Aucun équipement à proximité.");
            return null;
        }

        System.out.println("\nÉquipements disponibles autour de vous:");
        for (int i = 0; i < equipements.size(); i++) {
            System.out.println((i + 1) + ". " + equipements.get(i).getNom());
        }

        System.out.print("Choisissez un équipement à ramasser (0 pour annuler): ");
        int choix = new Scanner(System.in).nextInt();

        if (choix > 0 && choix <= equipements.size()) {
            Equipement equipementChoisi = equipements.get(choix - 1);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ContenuCase contenu = map[i][j].getContenu();
                    if (contenu == equipementChoisi) {
                        map[i][j].setContenu(null);
                        return equipementChoisi;
                    }
                }
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
                int x = joueur.getPosX();
                int y = joueur.getPosY();

                if(x >= 0 && x < rows && y >= 0 && y < cols) {
                    map[x][y].setContenu(joueur);
                }
            } else if (obj instanceof Monstre monstre) {
                int x = monstre.getPosX();
                int y = monstre.getPosY();

                if(x >= 0 && x < rows && y >= 0 && y < cols) {
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
