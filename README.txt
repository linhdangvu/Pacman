Projet de Conception et Programmation objet

*****PACMAN*****

< DANG Vu My Linh - u21611949 >

Dans ce projet, je crée un labyrinthe avec grille 2D en utilisant un tableau à deux dimensions.

Fonctions de Pacman :
- Manger des pacgommes et gagner des points et des pouvoirs de chaque pacgommes
- Jouer peut controller ce pacman en utiliser des keyboards flèches.
- Le personnage peut emprunter des passages situés de chaque côté de l’écran, produisant un effet de wraparound, le faisant réapparaître de l’autre côté du labyrinthe. 


Fonctions des pacgommes :
- Pacgommes bleus : 100 points
- Pacgommes violets : 300 points
	-> Pacman devient invisible pour les fantômes. 
	-> La couleur de Pacman devient jaune pale.
- Pacgommes Orange : 500 points
	-> Pacman devient superpacman.
	-> Pacman devient orange.
	-> Les fantômes deviennent bleus.
- Pacgommes Vert : 1000 points
	-> Modifier la structure du labyrinthe.

Fonctions des fantômes :
- Il y a 4 fantômes.
- Il se déplacent aléatoirement.
- Si ce pacman touche ces fantômes. Il va perdre une vie.

Règles pour ce jeu :
- Initialement il a trois vies.
— Si le joueur dépasse les 5000 points, il obtient une vie supplémentaire.
— Chaque fantôme se déplace dans une direction jusqu’à ce qu’il atteigne un mur, puis choisit une nouvelle
direction aléatoirement.
— Quand le pacman est invisible et le pacman pourra traverser les fantômes sans perdre de vie.
— Quand le pacman est un superpacman, les fantômes deviennent vulnérables. Dans ce cas, ils se déplacent
deux fois plus lentement et ils reviennent au centre du labyrinthe si ils sont touchés par le pacman.
— Le jeu se termine quand il n’y a plus de pacgommes et la partie est gagnée ou quand le pacman a perdu toutes ses vies et la partie est perdue.










