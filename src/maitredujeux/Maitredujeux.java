package maitredujeux;

import java.util.ArrayList;
import java.util.Scanner;

import monstres.*;
import personnages.Joueur;

public class Maitredujeux {
    private ArrayList<String> lignes;

    public Maitredujeux() {
        lignes = new ArrayList<>();
    }

    public void ajouterLignes(String ligne) {
        lignes.add(ligne);
    }

    public void afficherligne() {
        for (String ligne : lignes) {
            System.out.println(ligne);
        }
    }

    public Monstre creemonstre(String espece, int numero) {
        switch (espece.toLowerCase()) {
            case "gobelin": return new Gobelin(numero);
            case "dragon": return new Dragon(numero);
            case "squelette": return new Squelette(numero);

            default: throw new IllegalArgumentException("Type de monstre inconnu : " + espece);
            }
        }

    public Monstreperso creemonstreperso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Création d'un monstre personnalisé ===");

        System.out.print("Espèce du monstre : ");
        String espece = scanner.nextLine();

        System.out.print("Numéro du monstre : ");
        int numero = scanner.nextInt();

        System.out.print("Points de vie : ");
        int pointDeVie = scanner.nextInt();

        System.out.print("Force : ");
        int force = scanner.nextInt();

        System.out.print("Dextérité : ");
        int dexterite = scanner.nextInt();

        System.out.print("Initiative : ");
        int initiative = scanner.nextInt();

        System.out.print("Classe d'armure : ");
        int classeArmure = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        System.out.print("Type d'attaque (ex: Morsure, Feu, Griffes) : ");
        String typeAttaque = scanner.nextLine();

        System.out.print("Portée de l'attaque : ");
        int portee = scanner.nextInt();
        scanner.nextLine(); // Encore pour consommer le retour à la ligne

        System.out.print("Dégâts (ex: 1d6+2) : ");
        String degats = scanner.nextLine();

        Monstreperso monstre = new Monstreperso(espece, numero, pointDeVie, force, dexterite, initiative,
                classeArmure, typeAttaque, portee, degats);

        System.out.println("\n✅ Monstre créé avec succès :\n" + monstre);

        return monstre;
        }
    }
