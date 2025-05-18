package maitredujeux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import monstres.*;
import personnages.Joueur;

public class Maitredujeux {
    private ArrayList<String> m_lignes;
    private Map<String, Integer> m_compteurMonstres;
    private ArrayList<String> m_especesPerso;
    private final Scanner m_scanner;

    public Maitredujeux() {
        m_lignes = new ArrayList<>();
        m_compteurMonstres = new HashMap<>();
        m_especesPerso = new ArrayList<>();
        m_scanner = new Scanner(System.in);
    }

    public void ajouterLignes(String ligne) {
        m_lignes.add(ligne);
    }

    public void afficherLignes() {
        for (String ligne : m_lignes) {
            System.out.println(ligne);
        }
    }

    public Monstre creerMonstre() {
        System.out.println("=== Création d'un monstre ===");
        System.out.println("1. Gobelin");
        System.out.println("2. Dragon");
        System.out.println("3. Squelette");
        System.out.println("4. Monstre personnalisé");

        int index = 5;
        for (String espece : m_especesPerso) {
            System.out.println(index + ". " + espece);
            index++;
        }

        int choix = -1;
        do {
            System.out.print("Choisissez le type de monstre : ");
            if(m_scanner.hasNextInt()) {
                choix = m_scanner.nextInt();
                m_scanner.nextLine();
            } else {
                m_scanner.nextLine(); // vider entrée non-int
            }
        } while (choix < 1 || choix >= index);

        if (choix == 4) {
            Monstreperso monstre = creerMonstrePerso();
            if(!m_especesPerso.contains(monstre.getEspece())) {
                m_especesPerso.add(monstre.getEspece());
            }
            return monstre;
        } else if (choix >= 5 && choix < index) {
            String especePerso = m_especesPerso.get(choix - 5);
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
        m_compteurMonstres.putIfAbsent(espece, 0);
        int numero = m_compteurMonstres.get(espece) + 1;
        m_compteurMonstres.put(espece, numero);

        switch (espece) {
            case "gobelin": return new Gobelin(numero);
            case "dragon": return new Dragon(numero);
            case "squelette": return new Squelette(numero);
            default: return new Monstreperso(espece, numero, 50, 10, 10, 10, 10, "attaque basique", 1, "1d6");
        }
    }

    public Monstreperso creerMonstrePerso() {
        System.out.println("=== Création d'un monstre personnalisé ===");

        String espece;
        do {
            System.out.print("Espèce du monstre : ");
            espece = m_scanner.nextLine().trim();
        } while (espece.isEmpty());

        m_compteurMonstres.putIfAbsent(espece, 0);
        int numero = m_compteurMonstres.get(espece) + 1;
        m_compteurMonstres.put(espece, numero);

        int pointDeVie = saisirEntierPositif("Points de vie : ");
        int portee = saisirEntierMin("Portée de l'attaque (>=1) : ", 1);
        int force;
        int dexterite;

        if (portee == 1) {
            System.out.println("Ce monstre attaque au corps à corps donc sa dextérité est de 0 !");
            force = saisirEntierPositif("Force : ");
            dexterite = 0;
        } else {
            System.out.println("Ce monstre attaque à distance donc sa force est de 0 !");
            dexterite = saisirEntierPositif("Dextérité : ");
            force = 0;
        }

        int initiative = saisirEntierPositif("Initiative : ");
        int classeArmure = saisirEntierPositif("Classe d'armure : ");
        System.out.print("Type d'attaque : ");
        String typeAttaque = m_scanner.nextLine();

        System.out.print("Dégâts (ex: 1d6) : ");
        String degats = m_scanner.nextLine();

        return new Monstreperso(espece, numero, pointDeVie, force, dexterite, initiative, classeArmure, typeAttaque, portee, degats);
    }

    private int saisirEntierPositif(String message) {
        int valeur;
        do {
            System.out.print(message);
            while (!m_scanner.hasNextInt()) {
                m_scanner.nextLine();
                System.out.print(message);
            }
            valeur = m_scanner.nextInt();
            m_scanner.nextLine();
        } while (valeur < 0);
        return valeur;
    }

    private int saisirEntierMin(String message, int min) {
        int valeur;
        do {
            System.out.print(message);
            while (!m_scanner.hasNextInt()) {
                m_scanner.nextLine();
                System.out.print(message);
            }
            valeur = m_scanner.nextInt();
            m_scanner.nextLine();
        } while (valeur < min);
        return valeur;
    }
}
