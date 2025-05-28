import classes.*;
import equipements.Armures.ArmureLegere;
import equipements.Equipement;
import maitredujeux.Maitredujeux;
import monstres.Monstre;
import personnages.*;
import races.*;
import interfacejeu.*;
import Des.*;
import java.util.*;
import personnages.Entité.entite;

import static equipements.GestionEquipements.initialiserEquipements;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<entite> participants = new ArrayList<>();
        List<Object> participants2 = new ArrayList<>();
        List<Joueur> joueurs = new ArrayList<>();
        Maitredujeux mj = new Maitredujeux();

        map_milieu map = new map_milieu(20,20);

        System.out.println("=== Création des personnages ===");

        int numeroJoueur = 1;
        while (true) {
            System.out.print("\nCréer un nouveau personnage ? (oui/non) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();
            if (reponse.equals("non")) {break;};
            if (!reponse.equals("oui")) {
                System.out.println("Réponse invalide. Veuillez répondre par 'oui' ou 'non'.");
                continue;
            }


            Joueur joueur = creerPersonnage(scanner, numeroJoueur); // ou new Joueur("Joueur" + numeroJoueur), selon ton constructeur
            joueurs.add(joueur);
            participants.add(joueur);
            participants2.add(joueur);
            numeroJoueur++;

            //a refaire
            int x;
            int y;
            while(true) {
                System.out.println("Maître du jeu, placez le joueur sur la carte !");
                System.out.print("Entrez la coordonnée X (ligne) : ");
                x = scanner.nextInt();
                System.out.print("Entrez la coordonnée Y (colonne) : ");
                y = scanner.nextInt();
                scanner.nextLine();
                if (joueur.setPosXY(x, y, map)) {
                    break;
                }
                else {
                    System.out.println("Mauvaise coordonnées");
                }
            }

            System.out.println("Joueur placé en (" + x + ", " + y + ").");
            numeroJoueur++;
        }

        if (joueurs.isEmpty()) {
            System.out.println("Aucun joueur n'a été créé. Fin du programme.");
            return;
        }

        System.out.println("\n=== Création des monstres par le Maître du Jeu ===");
        while (true) {
            System.out.print("Créer un nouveau monstre ? (oui/non) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();
            if (reponse.equals("non")) {break;};
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
            while(true) {
                System.out.println("Maître du jeu, placez le monstre sur la carte !");
                System.out.print("Entrez la coordonnée X (ligne) : ");
                x = scanner.nextInt();
                System.out.print("Entrez la coordonnée Y (colonne) : ");
                y = scanner.nextInt();
                scanner.nextLine();
                if (monstre.setPosXY(x, y, map)) {
                    break;
                }
                else {
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
        int numeroDonjon = 1;

        while (partieEnCours) {
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


            barre.Affichage(joueurs.get(0), 1, participants, 1);
            map.Print(participants2);

            int index = 0;
            while (true) {
                Object p = participants.get(index);

                if (p instanceof Joueur joueur && !joueur.estMort()) {
                    System.out.println("\nC'est le tour de " + joueur.getNom() + " !");
                    int actionsRestantes = 3;
                    while (actionsRestantes > 0) {
                        System.out.println("Actions restantes : " + actionsRestantes);
                        System.out.println("1. Attaquer\n2. S'équiper\n3. Rammasser\n4. Se déplacer\n5. Passer");
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
                                    // Ajouter de nouveaux monstres ici si besoin
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
                                    // Ajouter de nouveaux monstres ici si besoin
                                }

                                // Vérifie si un joueur est mort après l’action
                                boolean joueurMort = joueurs.stream().anyMatch(Joueur::estMort);
                                if (joueurMort) {
                                    System.out.println("\n=== Un joueur est mort... Défaite ! ===");
                                    partieEnCours = false;
                                }
                            }
                        case "2" -> {
                                joueur.afficherInventaire();

                                if (!joueur.getEquipements().isEmpty()) {
                                    // Afficher les objets avec leur index
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
                                int cases = Integer.parseInt(scanner.nextLine());
                                joueur.seDeplacer(direction, map, cases);
                                actionsRestantes--;
                            }
                            case "5" -> actionsRestantes = 0;
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
                    break;
                }


                index = (index + 1) % participants.size();
            }
        }
    }

    public static Joueur creerPersonnage(Scanner scanner, int numeroJoueur) {
        System.out.println("\n--- Joueur " + numeroJoueur + " ---");

        System.out.print("Entrez le nom du personnage : ");
        String nom = scanner.nextLine();
        while(nom.length() < 3) {
            System.out.print("Entrez le nom du personnage (min. 3 caractères) : ");
            nom = scanner.nextLine();
        }

        Races race = null;
        while (race == null) {
            System.out.println("Choisissez une race :");
            System.out.println("1 - Humain\n2 - Elfe\n3 - Nain\n4 - Halfelin");
            String choix = scanner.nextLine();
            race = switch (choix) {
                case "1" -> new Humain();
                case "2" -> new Elfe();
                case "3" -> new Nain();
                case "4" -> new Halfelin();
                default -> {
                    System.out.println("Choix invalide.");
                    yield null;
                }
            };
        }

        Classe classe = null;
        while (classe == null) {
            System.out.println("Choisissez une classe :");
            System.out.println("1 - Guerrier\n2 - Roublard\n3 - Clerc\n4 - Magicien");
            String choix = scanner.nextLine();
            classe = switch (choix) {
                case "1" -> new Guerrier();
                case "2" -> new Roublard();
                case "3" -> new Clerc();
                case "4" -> new Magicien();
                default -> {
                    System.out.println("Choix invalide.");
                    yield null;
                }
            };
        }

        Joueur joueur = new Joueur(nom, classe, race);
        System.out.println("Personnage créé : " + joueur.getNom() +
                " (" + classe.getNom() + " " + race.getNom() + ")");
        return joueur;
    }
}