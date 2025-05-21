import classes.*;
import equipements.*;
import equipements.Armures.ArmureLegere;
import maitredujeux.Maitredujeux;
import monstres.Monstre;
import personnages.*;
import races.*;
import inter_face.*;
import Des.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Object> participants = new ArrayList<>();
        List<Joueur> joueurs = new ArrayList<>();
        Maitredujeux mj = new Maitredujeux();

        System.out.println("=== Création des personnages ===");

        int numeroJoueur = 1;
        while (true) {
            System.out.print("\nCréer un nouveau personnage ? (oui/non) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();
            if (reponse.equals("non")) break;

            Joueur joueur = creerPersonnage(scanner, numeroJoueur);
            joueurs.add(joueur);
            participants.add(joueur);
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
            if (reponse.equals("non")) break;

            Monstre monstre = mj.creerMonstre();
            participants.add(monstre);
            System.out.println("Monstre " + monstre.getEspece() + " créé !");
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

            Barre_haut barre = new Barre_haut();
            map_milieu map = new map_milieu(20, 20);
            System.out.println("\n=== Début du donjon ===");
            barre.Affichage(joueurs.get(0), 1, participants, 1);
            map.Print(participants);

            int index = 0;
            while (true) {
                Object p = participants.get(index);

                if (p instanceof Joueur joueur && !joueur.estMort()) {
                    System.out.println("\nC'est le tour de " + joueur.getNom() + " !");
                    int actionsRestantes = 3;
                    while (actionsRestantes > 0) {
                        System.out.println("Actions restantes : " + actionsRestantes);
                        System.out.println("1. Attaquer\n2. S'équiper\n3. Passer");
                        System.out.print("Choisissez une action : ");
                        String action = scanner.nextLine();

                        switch (action) {
                            case "1" -> {
                                System.out.println("Qui voulez-vous attaquer ?");
                                List<Monstre> cibles = participants.stream().filter(o -> o instanceof Monstre m && !m.estMort()).map(o -> (Monstre) o).toList();
                                for (int i = 0; i < cibles.size(); i++) {
                                    System.out.println((i + 1) + ". " + cibles.get(i).getEspece());
                                }
                                int mort = 0;
                                for (int i = 0; i < cibles.size(); i++) {
                                    if (!cibles.get(i).estMort()) {
                                        continue;
                                    }
                                    else {
                                        mort = 1;
                                    }
                                }

                                if (mort == 0) {
                                    System.out.println("\n=== Tous les monstres sont vaincus ! Victoire ! ===");
                                    for (Joueur j : joueurs) {
                                        j.soignerComplet();
                                    }
                                    System.out.println("Préparation du donjon suivant...\n");
                                    numeroDonjon++;
                                    // Ajouter de nouveaux monstres ici si désiré
                                    break;

                                }
                                int choix = Integer.parseInt(scanner.nextLine()) - 1;
                                if (choix >= 0 && choix < cibles.size()) {
                                    joueur.attaquer(cibles.get(choix));
                                    System.out.println("Commentaire ? ");
                                    System.out.println(scanner.nextLine());
                                    actionsRestantes--;
                                }
                            }
                            case "2" -> {
                                joueur.ajouterEquipement(new ArmureLegere("Armure d'écailles", 9));
                                if (!joueur.getEquipements().isEmpty()) {
                                    joueur.equiper(joueur.getEquipements().get(joueur.getEquipements().size() - 1), joueur.getEquiper());
                                    System.out.println("Commentaire ? ");
                                    System.out.println(scanner.nextLine());
                                    actionsRestantes--;
                                }
                            }
                            case "3" -> actionsRestantes = 0;
                            default -> System.out.println("Action invalide.");
                        }
                    }
                } else if (p instanceof Monstre monstre && !monstre.estMort()) {
                    System.out.println("\nTour de " + monstre.getEspece());
                    List<Joueur> cibles = joueurs.stream().filter(j -> !j.estMort()).toList();
                    if (!cibles.isEmpty()) {
                        Joueur cible = cibles.get(new Random().nextInt(cibles.size()));
                        monstre.attaquer(cible);
                        System.out.println(monstre.getEspece() + " attaque " + cible.getNom() + " !");
                        System.out.println("Commentaire du MJ ? ");
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
