<h3 align="center">DOOnjon&Dragon Project</h3>

<p align="center">
  Une application Java simplifiée inspirée du jeu de rôle Donjons & Dragons, où les joueurs affrontent des monstres dans plusieurs donjons successifs.
  <br />
</p>

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

<!-- CAPTURES D'ÉCRAN -->
## Captures d'écran

<!-- Ajoutez vos captures d'écran ici -->
<!-- Exemple : ![Capture d'écran du projet](./images/screenshot.png) -->
<img width="1879" height="972" alt="image" src="https://github.com/user-attachments/assets/fbdd7a31-7b29-44dc-9487-9a8be9bda080" />


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table des matières</summary>
  <ol>
    <li><a href="#à-propos-du-projet">À propos du projet</a></li>
    <li>
      <a href="#pour-commencer">Pour commencer</a>
      <ul>
        <li><a href="#prérequis">Prérequis</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#gameplay">Gameplay</a></li>
    <li><a href="#personnages">Personnages</a></li>
    <li><a href="#monstres">Monstres</a></li>
    <li><a href="#tours-de-donjon">Tours de donjon</a></li>
    <li><a href="#exemple-de-partie">Exemple de partie</a></li>
    <li><a href="#fin-de-partie">Fin de partie</a></li>
    <li><a href="#rendus-hebdomadaires">Rendus hebdomadaires</a></li>
    <li><a href="#licence">Licence</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## À propos du projet

DOOnjon&Dragon est un jeu de rôle en Java simplifié, jouable en tour par tour. Les joueurs incarnent des personnages de fantasy médiévale qui doivent éliminer des monstres dans plusieurs donjons successifs. Un joueur est désigné Maître du Jeu (MJ) et gère l'histoire, les monstres et le placement sur la carte.

Le projet se déroule en binôme et suit une méthodologie avec rendus hebdomadaires, diagrammes UML et code conforme aux P21 Guidelines.

### Construit avec

* [![Java](https://img.shields.io/badge/Language-Java-red.svg)](https://www.java.com/)
* [![PlantUML](https://img.shields.io/badge/Diagram-UML-blue.svg)](https://plantuml.com/)

<!-- GETTING STARTED -->
## Pour commencer

### Prérequis

* Java 17+ (ou version compatible)
* IDE Java (IntelliJ, Eclipse, NetBeans, etc.)
* Git pour le versionning et le fork

### Installation

1. Forkez le dépôt et clonez votre fork
   ```sh
   git clone https://github.com/<votre_groupe>/DOOnjonDragon.git
   ```

2. Ouvrez le projet dans votre IDE

3. Compilez le projet (`src/` contient `Main.java` et toutes les classes)

4. Lancez l'application depuis la classe `Main`

<!-- GAMEPLAY -->
## Gameplay

* Tour par tour, chaque joueur agit selon son initiative (1d20 + bonus)

* Les joueurs affrontent des monstres dans des donjons de 15 à 25 cases

* Actions possibles par tour :
  * S'équiper (arme ou armure)
  * Se déplacer
  * Attaquer
  * Ramasser un équipement

* Les obstacles et équipements sont disposés sur la carte par le MJ

* Un donjon se termine lorsqu'un joueur est tué (défaite) ou tous les monstres sont éliminés (victoire)

<!-- CHARACTERS -->
## Personnages

Chaque joueur choisit :

* **Nom**
* **Race** : Humain, Nain, Elfe, Halfelin
* **Classe** : Guerrier, Clerc, Magicien, Roublard

### Caractéristiques

* Points de vie
* Force
* Dextérité
* Vitesse
* Initiative
* Inventaire et équipements (1 arme, 1 armure équipées maximum)

Les races et classes influencent les caractéristiques et équipements de départ.

### Équipements

* **Armures légères** : armure d'écailles (9), demi-plate (10)
* **Armures lourdes** : cotte de mailles (11), harnois (12)
* **Armes corps-à-corps** : bâton, masse d'armes (1d6), épée longue, rapière (1d8)
* **Armes à distance** : arbalète légère (1d8, portée 16), fronde (1d4, portée 6), arc court (1d6, portée 16)

<!-- MONSTERS -->
## Monstres

* Espèce et numéro
* Points de vie, vitesse, force, dextérité, initiative
* Attaque (dégâts, portée)
* Classe d'armure
* Pas d'équipement

Le MJ contrôle les monstres et décide de leur placement et caractéristiques.

<!-- DUNGEON TURNS -->
## Tours de donjon

* Les tours sont joués selon l'initiative

* Actions par tour :
  * **S'équiper** : arme ou armure
  * **Se déplacer** : distance = vitesse ÷ 3
  * **Attaquer** : jet d'attaque (1d20 + force ou dextérité), dégâts si succès
  * **Ramasser équipement** : ajoute à l'inventaire si sur une case contenant un objet

Les joueurs peuvent commenter leurs actions ou laisser le MJ ajouter du roleplay.

<!-- EXAMPLE SESSION -->
## Exemple de partie

Voici un exemple de partie simplifiée en ASCII :

```
********************************************************************************
Donjon 1:
   Andry (Naine Clerc, 15/16)     Caelynn (Elfe Magicienne, 10/12)

   A  B  C  D  E  F  G  H  I  J
1  | .  .  .  .  .  .  .  .  .  |
2  | .  .  .  *  .  .  .  .  .  |
3  | .  .  X^ .  .  .  .  .  .  |
4  | .  [ ] .  .  .  .  .  .  .  |
5  | .  .  .  .  .  .  .  .  .  |

Legend:
* Obstacle
[ ] Equipement
X^ Monstre
```

Exemple d'action :

```
Caelynn il vous reste 2 actions, que souhaitez-vous faire ?
- attaquer (att <Case>)
- se déplacer (dep <Case>)
- s'équiper (equ <num>)
$ att C3
Lancer un dé de 20...
Vous avez fait 13 + 16 (Dextérité) = 29
L'attaque perce l'armure du Demogorgon (18)
Lancer un dé de 4 pour infliger des dégâts...
Le Demogorgon subit 3 dégâts, il lui reste 22 PV
```

<!-- END OF GAME -->
## Fin de partie

* **Victoire** : tous les monstres éliminés → points de vie restaurés, passage au donjon suivant

* **Défaite** : un joueur est tué → fin du jeu

<!-- WEEKLY SUBMISSIONS -->
## Rendus hebdomadaires

* Chaque groupe fork le dépôt principal sous le nom `<etudiant1>-<etudiant2>`

* Rendus hebdomadaires avant chaque dimanche minuit

* Chaque rendu contient :
  * Code compilable dans `src/`
  * Diagramme de classes UML `uml/semaine<numero>.puml`

* Rendu final : diagramme UML complet + code fonctionnel

**Structure du dépôt** :

```
.
├── README.md
├── .gitignore
├── src/
│   ├── Main.java
│   └── ...
├── uml/
│   ├── semaine1.puml
│   └── ...
```

<!-- LICENSE -->
## Licence

Distribué sous licence MIT. Voir `LICENSE.txt` pour plus de détails.

<!-- CONTACT -->
## Contact

Igrek - [yvann.du.soub@gmail.com](mailto:yvann.du.soub@gmail.com)

Project Link: [https://github.com/Igrekop/Donjons-Dragons---Java](https://github.com/Igrekop/Donjons-Dragons---Java)
