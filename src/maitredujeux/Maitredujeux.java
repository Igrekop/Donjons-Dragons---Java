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

    public Maitredujeux() {
        lignes = new ArrayList<>();
        compteurMonstres = new HashMap<>();
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
        System.out.print("Choisissez le type de monstre : ");

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1: return creerMonstreEspece("gobelin");
            case 2: return creerMonstreEspece("dragon");
            case 3: return creerMonstreEspece("squelette");
            case 4: return creemonstreperso();
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
            default: throw new IllegalArgumentException("Type de monstre inconnu : " + espece);
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

        if (portee > 1) {
            force = 0;
            System.out.println("Ce monstre attaque à distance donc sa force est de 0 !");
            dexterite = saisirEntierPositif("Dextérité : ");
        } else {
            dexterite = 0;
            System.out.println("Ce monstre attaque au corps à corps donc sa dextérité est de 0 !");
            force = saisirEntierPositif("Force : ");
        }

        int initiative = saisirEntierPositif("Initiative : ");
        int classeArmure = saisirEntierPositif("Classe d'armure : ");
        System.out.print("Type d'attaque : ");
        String typeAttaque = scanner.nextLine();

        System.out.print("Dégâts (ex: 1d6) : ");
        String degats = scanner.nextLine();

        System.out.println("Le " + espece + " a été créer avec succès !");
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
