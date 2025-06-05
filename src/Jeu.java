import classes.*;
import equipements.Armures.ArmureLegere;
import equipements.Equipement;
import maitredujeux.Maitredujeux;
import monstres.Monstre;
import personnages.*;
import races.*;
import interfacejeu.*;
import Des.*;

import java.awt.*;
import java.util.*;
import java.util.List;

import personnages.Entité.entite;
import Sort.*;

import javax.lang.model.util.ElementScanner6;
import javax.swing.text.html.parser.Entity;
import interfacejeu.map_milieu;

import static equipements.GestionEquipements.initialiserEquipements;
import static java.lang.System.in;

public class Jeu {
    public void demarrer(Scanner scanner, ArrayList<entite> participants, List<Object> participants2,List<Joueur> joueurs, Maitredujeux mj, int numeroDonjon, map_milieu map) {


        String art = """
                ▀██▀▀█▄                       ██                                      ▄      ▀██▀▀█▄                                                   
                 ██   ██    ▄▄▄   ▄▄ ▄▄▄     ▄▄▄   ▄▄▄   ▄▄ ▄▄▄    ▄▄▄▄       ▄▄▄▄  ▄██▄      ██   ██  ▄▄▄ ▄▄   ▄▄▄▄     ▄▄▄ ▄   ▄▄▄   ▄▄ ▄▄▄    ▄▄▄▄  
                 ██    ██ ▄█  ▀█▄  ██  ██     ██ ▄█  ▀█▄  ██  ██  ██▄ ▀     ▄█▄▄▄██  ██       ██    ██  ██▀ ▀▀ ▀▀ ▄██   ██ ██  ▄█  ▀█▄  ██  ██  ██▄ ▀  
                 ██    ██ ██   ██  ██  ██     ██ ██   ██  ██  ██  ▄ ▀█▄▄    ██       ██       ██    ██  ██     ▄█▀ ██    █▀▀   ██   ██  ██  ██  ▄ ▀█▄▄ 
                ▄██▄▄▄█▀   ▀█▄▄█▀ ▄██▄ ██▄    ██  ▀█▄▄█▀ ▄██▄ ██▄ █▀▄▄█▀     ▀█▄▄▄▀  ▀█▄▀    ▄██▄▄▄█▀  ▄██▄    ▀█▄▄▀█▀  ▀████▄  ▀█▄▄█▀ ▄██▄ ██▄ █▀▄▄█▀ 
                                           ▄▄ █▀                                                                       ▄█▄▄▄▄▀                         
                                            ▀▀                                                                                                         
                """;
        String credit = "Par SALMANE Yanis, DUBLANC--SOUBIGOU Yvann et SIHR Victor";

        System.out.println(art);
        System.out.println(credit);



        System.out.println("=== Création des personnages ===");

        int numeroJoueur = 1;
        while (true) {
            System.out.print("\nCréer un nouveau personnage ? (oui/non) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();
            if (reponse.equals("non")) {
                break;
            }
            ;
            if (!reponse.equals("oui")) {
                System.out.println("Réponse invalide. Veuillez répondre par 'oui' ou 'non'.");
                continue;
            }

            Joueur joueur = CreationPersonnage.creerPersonnage(scanner, numeroJoueur);
            joueurs.add(joueur);
            participants.add(joueur);
            participants2.add(joueur);
        }
    }

            public void partie(Scanner scanner, ArrayList<entite> participants, List<Object> participants2,List<Joueur> joueurs, Maitredujeux mj, int numeroDonjon, map_milieu map) {
                if (numeroDonjon <= 3) {
                    boolean partiegagné = false;
                    participants.removeIf(participant -> participant instanceof Monstre);
                    map = choisirNouvelleCarte(scanner);
                    for (entite participant : participants) {
                        if (participant instanceof Joueur joueur) {
                            joueur.soignerComplet();
                            int x;
                            int y;
                            while (true) {
                                System.out.println("Maître du jeu, placez le joueur " + joueur.getNom() + " sur la carte !");
                                System.out.print("Entrez la coordonnée X (ligne) : ");
                                x = scanner.nextInt();
                                System.out.print("Entrez la coordonnée Y (colonne) : ");
                                y = scanner.nextInt();
                                scanner.nextLine();
                                if (joueur.setPosXY(x, y, map)) {
                                    System.out.println("Joueur " + joueur.getNom() + " placé en (" + x + ", " + y + ").");
                                    break;
                                } else {
                                    System.out.println("Mauvaise coordonnées");
                                }
                            }
                        }
                    }

                    if (joueurs.isEmpty()) {
                        System.out.println("Aucun joueur n'a été créé. Fin du programme.");
                        return;
                    }

                    System.out.println("\n=== Création des monstres par le Maître du Jeu ===");
                    while (true) {
                        System.out.print("Créer un nouveau monstre ? (oui/non) : ");
                        String reponse = scanner.nextLine().trim().toLowerCase();
                        if (reponse.equals("non")) {
                            break;
                        }
                        ;
                        if (!reponse.equals("oui")) {
                            System.out.println("Réponse invalide. Veuillez répondre par 'oui' ou 'non'.");
                            continue;
                        }

                        Monstre monstre = mj.creerMonstre();
                        participants.add(monstre);
                        participants2.add(monstre);
                        System.out.println("Monstre " + monstre.getEspece() + " créé !");

                        int x;
                        int y;
                        while (true) {
                            System.out.println("Maître du jeu, placez le monstre sur la carte !");
                            System.out.print("Entrez la coordonnée X (ligne) : ");
                            x = scanner.nextInt();
                            System.out.print("Entrez la coordonnée Y (colonne) : ");
                            y = scanner.nextInt();
                            scanner.nextLine();
                            if (monstre.setPosXY(x, y, map)) {
                                break;
                            } else {
                                System.out.println("Mauvaise coordonnées");
                            }
                        }
                        System.out.println("Monstre placé en (" + x + ", " + y + ").");
                    }

                    if (participants.isEmpty()) {
                        System.out.println("Aucun participant. Fin du programme.");
                        return;
                    }

                    System.out.println("\n=== Introduction par le Maître du Jeu ===");
                    System.out.println("""
                                Vous vous trouvez à l'entrée d'un ancien donjon oublié, perdu au cœur de la forêt noire.
                                Une rumeur parle d'un artefact légendaire scellé dans ses profondeurs, mais nul n'en est jamais revenu...
                                Des monstres rôdent, tapis dans l'ombre, prêts à défendre leurs trésors.
                                Votre aventure commence maintenant...
                            """);

                    boolean partieEnCours = true;
                    while (partieEnCours && partiegagné == false) {
                        System.out.println("\n=== Donjon " + numeroDonjon + " ===");

                        // Réinitialisation des initiatives
                        Map<Object, Integer> initiativeMap = new HashMap<>();
                        for (Object p : participants) {
                            int mod = (p instanceof Joueur) ? ((Joueur) p).getInitiative() : ((Monstre) p).getInitiative();
                            int score = Des.lancerDes("1d20") + mod;
                            initiativeMap.put(p, score);
                            System.out.println(((p instanceof Joueur) ? ((Joueur) p).getNom() : ((Monstre) p).getEspece()) + " initiative : " + score);
                        }
                        participants.sort((a, b) -> Integer.compare(initiativeMap.get(b), initiativeMap.get(a)));

                        BarreHaut barre = new BarreHaut();
                        System.out.println("\n=== Début du donjon ===");

                        while (true) {
                            System.out.print("Souhaitez-vous ajouter un obstacle ? (oui/non) : ");
                            String reponse = scanner.nextLine().trim().toLowerCase();

                            if (!reponse.equals("oui")) {
                                break;
                            }

                            System.out.print("Entrez la coordonnée X de l'obstacle : ");
                            int x = scanner.nextInt();

                            System.out.print("Entrez la coordonnée Y de l'obstacle : ");
                            int y = scanner.nextInt();
                            scanner.nextLine();

                            map.addObstacle(x, y);
                            System.out.println("Obstacle ajouté en (" + x + ", " + y + ").");
                        }

                        System.out.println("Fin de l'ajout des obstacles.");

                        Scanner scanner2 = new Scanner(System.in);
                        List<Equipement> equipements = initialiserEquipements();
                        Random random = new Random();

                        while (true) {
                            System.out.print("Souhaitez-vous ajouter un équipement sur la carte ? (oui/non) : ");
                            String reponse = scanner.nextLine().trim().toLowerCase();

                            if (!reponse.equals("oui")) {
                                break;
                            }

                            System.out.print("Entrez la coordonnée X (ligne) : ");
                            int x = scanner.nextInt();
                            System.out.print("Entrez la coordonnée Y (colonne) : ");
                            int y = scanner.nextInt();
                            scanner.nextLine();

                            // Tirage aléatoire d'un équipement
                            Equipement equipementAleatoire = equipements.get(random.nextInt(equipements.size()));

                            // Placement de l'équipement
                            map.addEquipment(x, y, equipementAleatoire);

                            System.out.println("Équipement ajouté en (" + x + ", " + y + ") : " + equipementAleatoire.getNom());
                        }

                        System.out.println("Fin de l'ajout des équipements.");


                        barre.Affichage(joueurs.get(0), numeroDonjon, participants, 1);
                        map.Print(participants2);

                        int index = 0;
                        while (true) {
                            Object p = participants.get(index);

                            if (p instanceof Joueur joueur && !joueur.estMort()) {
                                System.out.println("\nC'est le tour de " + joueur.getNom() + " !");
                                int actionsRestantes = 3;
                                while (actionsRestantes > 0) {
                                    System.out.println("Actions restantes : " + actionsRestantes);
                                    System.out.println("1. Attaquer\n2. S'équiper\n3. Rammasser\n4. Se déplacer\n5. Sort\n6. Passer");

                                    System.out.print("Choisissez une action : ");
                                    String action = scanner.nextLine();

                                    switch (action) {
                                        case "1" -> {
                                            System.out.println("Qui voulez-vous attaquer ?");
                                            List<Monstre> cibles = participants.stream()
                                                    .filter(o -> o instanceof Monstre m && !m.estMort())
                                                    .map(o -> (Monstre) o)
                                                    .toList();

                                            if (cibles.isEmpty()) {
                                                System.out.println("\n=== Tous les monstres sont vaincus ! Victoire ! ===");
                                                for (Joueur j : joueurs) {
                                                    j.soignerComplet();
                                                }
                                                System.out.println("Préparation du donjon suivant...\n");
                                                numeroDonjon++;
                                                partieEnCours = false;
                                                partiegagné = true;
                                                partie(scanner, participants, participants2, joueurs, mj, numeroDonjon, map);
                                                break;
                                            }

                                            for (int i = 0; i < cibles.size(); i++) {
                                                System.out.println((i + 1) + ". " + cibles.get(i).getEspece());
                                            }

                                            int choix = Integer.parseInt(scanner.nextLine()) - 1;
                                            if (choix >= 0 && choix < cibles.size()) {
                                                joueur.attaquer(cibles.get(choix));
                                                mj.intervenir(participants, map);
                                                actionsRestantes--;
                                            }

                                            // Vérifie si tous les monstres sont morts après l'attaque
                                            boolean tousLesMonstresMorts = participants.stream()
                                                    .filter(o -> o instanceof Monstre)
                                                    .map(o -> (Monstre) o)
                                                    .allMatch(Monstre::estMort);

                                            if (tousLesMonstresMorts) {
                                                System.out.println("\n=== Tous les monstres sont vaincus ! Victoire ! ===");
                                                for (Joueur j : joueurs) {
                                                    j.soignerComplet();
                                                }
                                                System.out.println("Préparation du donjon suivant...\n");
                                                numeroDonjon++;
                                                partieEnCours = false;
                                                partiegagné = true;
                                                partie(scanner, participants, participants2, joueurs, mj, numeroDonjon, map);
                                                break;
                                            }

                                            // Vérifie si un joueur est mort après l’action
                                            boolean joueurMort = joueurs.stream().anyMatch(Joueur::estMort);
                                            if (joueurMort) {
                                                System.out.println("\n=== Un joueur est mort... Défaite ! ===");
                                                partieEnCours = false;
                                                partiegagné = false;
                                            }
                                        }
                                        case "2" -> {
                                            joueur.afficherInventaire();

                                            if (!joueur.getEquipements().isEmpty()) {
                                                System.out.println("Quel équipement souhaitez-vous équiper ? (entrez le numéro) :");
                                                for (int i = 0; i < joueur.getEquipements().size(); i++) {
                                                    Equipement eq = joueur.getEquipements().get(i);
                                                    System.out.println(i + " - " + eq.getNom());
                                                }

                                                int choix = -1;
                                                try {
                                                    choix = Integer.parseInt(scanner.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Entrée invalide.");
                                                }

                                                if (choix >= 0 && choix < joueur.getEquipements().size()) {
                                                    Equipement equipementChoisi = joueur.getEquipements().remove(choix);
                                                    joueur.equiper(equipementChoisi, null);

                                                    System.out.println("Commentaire ? ");
                                                    System.out.println(scanner.nextLine());

                                                    actionsRestantes--;
                                                } else {
                                                    System.out.println("Numéro invalide.");
                                                }
                                            } else {
                                                System.out.println("Vous n'avez aucun équipement dans votre inventaire.");
                                            }
                                        }
                                        case "3" -> {
                                            System.out.println("Rammasser un équipement");
                                            joueur.ramasserEquipement(map);
                                            actionsRestantes--;
                                        }
                                        case "4" -> {
                                            System.out.println("Vous avez choisi de vous déplacer !");
                                            System.out.println("Vers quelle direction souhaitez vous vous déplacez ? (haut/bas/droite/gauche)");
                                            String direction = scanner.nextLine().trim().toLowerCase();
                                            System.out.println("Le nombre de cases? ");
                                            int cases = Integer.parseInt(scanner.nextLine());
                                            joueur.seDeplacer(direction, map, cases);
                                            actionsRestantes--;
                                        }
                                        case "5" -> {
                                            if (joueur.getClasse() instanceof Clerc || joueur.getClasse() instanceof Magicien) {
                                                System.out.println("Sorts disponibles :");
                                                System.out.println("1. Guérison");
                                                if (joueur.getClasse() instanceof Magicien) {
                                                    System.out.println("2. Bougie-Woogie");
                                                    System.out.println("3. Enchanter une arme");
                                                }

                                                System.out.print("Choisissez un sort : ");
                                                String choixSort = scanner.nextLine();

                                                switch (choixSort) {
                                                    case "1" -> {
                                                        System.out.println("Cibles disponibles pour Guérison :");
                                                        ArrayList<entite> ciblesPossibles = new ArrayList<>();
                                                        for (entite e : participants) {
                                                            if (e instanceof Joueur) {
                                                                ciblesPossibles.add(e);
                                                            }
                                                        }
                                                        for (int i = 0; i < ciblesPossibles.size(); i++) {
                                                            entite e = ciblesPossibles.get(i);
                                                            System.out.println((i + 1) + " - " + e.getNom());
                                                        }
                                                        System.out.print("Entrez le numéro de la cible à soigner : ");
                                                        try {
                                                            int choix = Integer.parseInt(scanner.nextLine()) - 1;
                                                            if (choix >= 0 && choix < ciblesPossibles.size()) {
                                                                Joueur cible = (Joueur) ciblesPossibles.get(choix);
                                                                Guerison sort = new Guerison();
                                                                sort.utiliser(cible, cible);
                                                                System.out.println(cible.getNom() + " a été soigné !");
                                                                actionsRestantes--;
                                                            } else {
                                                                System.out.println("Numéro invalide.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Entrée invalide.");
                                                        }
                                                    }
                                                    case "2" -> {
                                                        if (joueur.getClasse() instanceof Magicien) {
                                                            System.out.println("Cibles disponibles pour Bougie-Woogie :");
                                                            ArrayList<entite> ciblesPossibles = participants;
                                                            for (int i = 0; i < ciblesPossibles.size(); i++) {
                                                                entite e = ciblesPossibles.get(i);
                                                                System.out.println((i + 1) + " - " + e.getNom());
                                                            }
                                                            System.out.print("Entrez le numéro de la premiere cible à echanger : ");
                                                            try {
                                                                int choix = Integer.parseInt(scanner.nextLine()) - 1;
                                                                if (choix >= 0 && choix < ciblesPossibles.size()) {
                                                                    entite cible1 = ciblesPossibles.get(choix);
                                                                    BougieWoogie sort = new BougieWoogie();
                                                                    System.out.println("Cibles disponibles pour Bougie-Woogie :");
                                                                    for (int i = 0; i < ciblesPossibles.size(); i++) {
                                                                        entite e = ciblesPossibles.get(i);
                                                                        System.out.println((i + 1) + " - " + e.getNom());
                                                                    }
                                                                    System.out.print("Entrez le numéro de la deuxième cible à échanger : ");
                                                                    try {
                                                                        int choix2 = Integer.parseInt(scanner.nextLine()) - 1;
                                                                        if (choix2 >= 0 && choix2 < ciblesPossibles.size()) {
                                                                            entite cible2 = ciblesPossibles.get(choix2);
                                                                            sort.utilisermap(cible1, cible2);
                                                                            actionsRestantes--;
                                                                        } else {
                                                                            System.out.println("Numéro invalide.");
                                                                        }
                                                                    } catch (NumberFormatException e) {
                                                                        System.out.println("Entrée invalide.");
                                                                    }
                                                                } else {
                                                                    System.out.println("Numéro invalide.");
                                                                }
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Entrée invalide.");
                                                            }
                                                        } else {
                                                            System.out.println("Ce sort est réservé aux magiciens.");
                                                        }
                                                    }
                                                    case "3" -> {
                                                        if (joueur.getClasse() instanceof Magicien) {
                                                            actionsRestantes--;
                                                        } else {
                                                            System.out.println("Ce sort est réservé aux magiciens.");
                                                        }
                                                    }
                                                    default -> System.out.println("Sort inconnu.");
                                                }
                                            } else {
                                                System.out.println("Vous ne possédez aucun sort, cette action est donc impossible pour vous.");
                                            }
                                        }
                                        case "6" -> actionsRestantes = 0;
                                        default -> System.out.println("Action invalide.");
                                    }
                                    map.Print(participants2);
                                }
                            } else if (p instanceof Monstre monstre && !monstre.estMort()) {
                                System.out.println("\nTour de " + monstre.getEspece());
                                List<Joueur> cibles = joueurs.stream().filter(j -> !j.estMort()).toList();
                                if (!cibles.isEmpty()) {
                                    Joueur cible = cibles.get(new Random().nextInt(cibles.size()));
                                    monstre.attaquer(cible);
                                    System.out.println(monstre.getEspece() + " attaque " + cible.getNom() + " !");
                                    mj.intervenir(participants, map);
                                    System.out.println(scanner.nextLine());
                                }
                            }

                            boolean joueurMort = joueurs.stream().anyMatch(Joueur::estMort);

                            if (joueurMort) {
                                System.out.println("\n=== Un joueur est mort... Défaite ! ===");
                                partieEnCours = false;
                                partiegagné = false;
                                break;
                            }

                            // Vérification globale à la fin de chaque tour - si tous les monstres sont morts, fin de la partie
                            boolean tousLesMonstresMortsFinal = participants.stream()
                                    .filter(o -> o instanceof Monstre)
                                    .map(o -> (Monstre) o)
                                    .allMatch(Monstre::estMort);
                            if (tousLesMonstresMortsFinal) {
                                System.out.println("\n=== Tous les monstres sont vaincus ! Victoire ! ===");
                                for (Joueur j : joueurs) {
                                    j.soignerComplet();
                                }
                                System.out.println("Préparation du donjon suivant...\n");
                                numeroDonjon++;
                                partieEnCours = false;
                                partiegagné = true;
                                partie(scanner, participants, participants2, joueurs, mj, numeroDonjon, map);
                                break;
                            }

                            index = (index + 1) % participants.size();
                        }
                    }
                }

                else { System.out.println("Bravo vous avez fini");}

        }
        


    private map_milieu choisirNouvelleCarte(Scanner scanner) {
        map_milieu map = null;
        boolean verif = false;
        while (!verif) {
            System.out.println("\nChoisir la nouvelle map :");
            System.out.println("1. Forêt D'Yvann");
            System.out.println("2. Labyrinthe D'Yvann");
            System.out.println("3. Les 3 voies de l'Homme Gazées");
            String reponse = scanner.nextLine().trim().toLowerCase();
            switch (reponse) {
                case "1":
                    map = map_milieu.map1();
                    verif = true;
                    break;
                case "2":
                    map = map_milieu.map2();
                    verif = true;
                    break;
                case "3":
                    map = map_milieu.map3();
                    verif = true;
                    break;
                default:
                    System.out.println("Réponse invalide. Veuillez entrer 1, 2 ou 3.");
            }
        }
        map.PrintVide();
        return map;
    }

    public static void VraiJeux() {
        Jeu jeu = new Jeu();
        Scanner scanner = new Scanner(in);
        ArrayList<entite> participants = new ArrayList<>();
        List<Object> participants2 = new ArrayList<>();
        List<Joueur> joueurs = new ArrayList<>();
        Maitredujeux mj = new Maitredujeux();
        int numeroDonjon = 1;
        map_milieu map = null;


        // Démarrer le jeu
        jeu.demarrer(scanner, participants, participants2, joueurs, mj, numeroDonjon, map);



        // Lancer la partie
        jeu.partie(scanner, participants, participants2, joueurs, mj, numeroDonjon, map);

        // Fermer le scanner
        scanner.close();
    }

}


