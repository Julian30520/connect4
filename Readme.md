# Le puissance 4

## Decription du jeu :

Puissance 4 (appelé aussi connect 4 en anglais) est un jeu de stratégie combinatoire abstrait, commercialisé pour la première fois en 1974 par la Milton Bradley Company, plus connue sous le nom de MB et détenue depuis 1984 par la société Hasbro. *Source : Wikipedia*\
Il faut impérativement être deux joueurs pour pouvoir jouer au puissance 4, cependant dans le cadre de ce projet, il est possible de jouer seul contre l'ordinateur.
Le but du jeu est d'aligner quatre pions de la même couleur afin que l'un des deux joueurs remporte la partie.
Attention, une partie peut aussi se resulter par une égalité.

## Implémentation technique du jeu :
*Disclaimer : Le code a été entièrement rédiger en anglais par simple habitude de développement.*\
Le programme est divisé en 3 grande partie qui sont elles-mêmes divisées en plusieurs partie (fonction).

### 1. Mise en place du jeu
 * Initialisation du jeu
 * Renseigner les noms des joueurs
 * Créer le plateau de jeu
 * Qui commence en premier ?

### 2. Traitement de la partie
 * Jouer
 * Est-ce que la partie est fini ?
 * A qui de jouer ?
 * Verification si egalité
 * Mise à jour du plateau de jeu
 * Afficher dans la console le plateau du jeu

### 3. Relancer le jeu ?
 * Demande d'une nouvelle partie ou non

Dans la partie "main" de notre programme, une boucle répète les 3 grandes parties tant qu'un utilisateur demande de faire une nouvelle partie. Si un utilisateur demande de ne pas recommencer une partie, le programme se termine.

Voici le code du "main" :

```
public static void main(String[] args) {
		do {
			InitGame();
			Play();
			playAgain = ReloadGame();
		}while(playAgain);
		System.out.println("Thanks for playing ! Good bye !");
	}
```

## Notice d'utilisation :

## Exemple d'utilisation :
