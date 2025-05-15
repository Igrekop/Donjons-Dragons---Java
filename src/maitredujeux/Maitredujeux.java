package maitredujeux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import monstres.*;
import personnages.Joueur;

public class Maitredujeux {
    private ArrayList<String> lignes;
    private Map<String, Integer> compteurMonstres;
    private ArrayList<String> especesPerso;

    public Maitredujeux() {
        lignes = new ArrayList<>();
        compteurMonstres = new HashMap<>();
        especesPerso = new ArrayList<>();
    }

    public void ajouterLignes(String ligne) {
        lignes.add(ligne);
    }

    public void afficherligne() {
        for (String ligne : lignes) {
            System.out.println(ligne);
        }
    }

    public Monstre creemonstre() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Création d'un monstre ===");
        System.out.println("1. Gobelin");
        System.out.println("2. Dragon");
        System.out.println("3. Squelette");
        System.out.println("4. Monstre personnalisé");

        // Afficher les espèces personnalisées si disponibles
        int index = 5;
        for (String espece : especesPerso) {
            System.out.println(index + ". " + espece);
            index++;
        }

        System.out.print("Choisissez le type de monstre : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 4) {
            Monstreperso monstre = creemonstreperso();
            especesPerso.add(monstre.getEspece());
            return monstre;
        } else if (choix >= 5 && choix < index) {
            String especePerso = especesPerso.get(choix - 5);
            return creerMonstreEspece(especePerso);
        }

        switch (choix) {
            case 1: return creerMonstreEspece("gobelin");
            case 2: return creerMonstreEspece("dragon");
            case 3: return creerMonstreEspece("squelette");
            default: throw new IllegalArgumentException("Choix invalide.");
        }
    }

    private Monstre creerMonstreEspece(String espece) {
        compteurMonstres.putIfAbsent(espece, 0);
        int numero = compteurMonstres.get(espece) + 1;
        compteurMonstres.put(espece, numero);

        switch (espece) {
            case "gobelin": return new Gobelin(numero);
            case "dragon": return new Dragon(numero);
            case "squelette": return new Squelette(numero);
            default: return new Monstreperso(espece, numero, 50, 10, 10, 10, 10, "attaque basique", 1, "1d6");
        }
    }

    public Monstreperso creemonstreperso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Création d'un monstre personnalisé ===");

        String espece;
        do {
            System.out.print("Espèce du monstre : ");
            espece = scanner.nextLine().trim();
        } while (espece.isEmpty());

        int pointDeVie = saisirEntierPositif("Points de vie : ");
        int portee = saisirEntierMin("Portée de l'attaque (>=1) : ", 1);
        int force = 0;
        int dexterite = 0;

        if (portee == 1) {
            dexterite = 0;
            System.out.println("Ce monstre attaque au corps à corps donc sa dextérité est de 0 !");
            force = saisirEntierPositif("Force : ");
        } else {
            force = 0;
            System.out.println("Ce monstre attaque à distance donc sa force est de 0 !");
            dexterite = saisirEntierPositif("Dextérité : ");
        }

        int initiative = saisirEntierPositif("Initiative : ");
        int classeArmure = saisirEntierPositif("Classe d'armure : ");
        System.out.print("Type d'attaque : ");
        String typeAttaque = scanner.nextLine();

        System.out.print("Dégâts (ex: 1d6) : ");
        String degats = scanner.nextLine();

        return new Monstreperso(espece, 1, pointDeVie, force, dexterite, initiative, classeArmure, typeAttaque, portee, degats);
    }

    private int saisirEntierPositif(String message) {
        Scanner scanner = new Scanner(System.in);
        int valeur;
        do {
            System.out.print(message);
            valeur = scanner.nextInt();
        } while (valeur < 0);
        return valeur;
    }

    private int saisirEntierMin(String message, int min) {
        Scanner scanner = new Scanner(System.in);
        int valeur;
        do {
            System.out.print(message);
            valeur = scanner.nextInt();
        } while (valeur < min);
        return valeur;
    }
}
