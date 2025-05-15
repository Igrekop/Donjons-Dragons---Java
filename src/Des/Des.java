package Des;
import java.io.IOException;
import java.util.Random;

public class Des {
    private static Random random = new Random();
    private static final String[] DICE_FACES = {
            " ----- \n|     |\n|  *  |\n|     |\n ----- ",  // 1
            " ----- \n| *   |\n|     |\n|   * |\n ----- ",  // 2
            " ----- \n| *   |\n|  *  |\n|   * |\n ----- ",  // 3
            " ----- \n| * * |\n|     |\n| * * |\n ----- ",  // 4
            " ----- \n| * * |\n|  *  |\n| * * |\n ----- ",  // 5
            " ----- \n| * * |\n| * * |\n| * * |\n ----- "   // 6
    };

    private static int lancerDes(int nombreFaces, int nombreDes) {
        int resultat = 0;
        for (int i = 0; i < nombreDes; i++) {
            int lance = random.nextInt(nombreFaces) + 1;
            resultat += lance;
            System.out.println("Dé n° " + (i + 1) + " (" + nombreFaces + " faces) : " + lance);
        }
        return resultat;
    }

    public static int lancerDes(String notation) {
        String[] parts = notation.split("d");
        int nombreDes = Integer.parseInt(parts[0]);
        int nombreFaces = Integer.parseInt(parts[1]);
        return lancerDes(nombreFaces, nombreDes);
    }

    public static void lancerDesAvecAnimation(String notation) throws InterruptedException {
        String[] parts = notation.split("d");
        int nombreDes = Integer.parseInt(parts[0]);
        int nombreFaces = Integer.parseInt(parts[1]);
        // Afficher "Rolling..." pendant 2 secondes
        System.out.print("Rolling");
        for (int i = 0; i < 3; i++) { // 10 itérations pour 2 secondes
            System.out.print("."); // Affiche un point à chaque itération
            Thread.sleep(500); // Pause de 500 ms
        }
        System.out.println(); // Nouvelle ligne après "Rolling..."
        // Générer les résultats des dés dans le terminal
        int total = 0;
        System.out.println("\n🎲 Résultat final de " + notation + " :");
        for (int i = 0; i < nombreDes; i++) {
            int face = random.nextInt(nombreFaces) + 1;
            total += face;
            System.out.println("Dé " + (i + 1) + " : " + face);
            printDiceFace(face, nombreFaces); // Affiche la vraie face si c’est un d6
        }
        System.out.println("➡️ Total : " + total);
    }

    // Méthode d'affichage du dé sous forme ASCII
    private static void printDiceFace(int num, int faces) {
        if (faces == 6 && num >= 1 && num <= 6) {
            System.out.println(DICE_FACES[num - 1]);
        } else {
            System.out.println("[ " + num + " ]"); // Pour les autres types de dés
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Exemple d'utilisation
        lancerDesAvecAnimation("3d6"); // Lancer 3 dés à 6 faces
    }
}