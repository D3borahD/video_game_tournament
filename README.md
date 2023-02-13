# video_game_tournament
TD CESI, web api and web site

# Site web Video game Tournement et son API WEB

## Run on: 
API : http://localhost:9000/  
SITE : http://localhost:9001/

## Model de données
https://dbdiagram.io/d/63ca8b50296d97641d7b00e1

## But :
Le site a pour but l'organisation d'évènements regroupant des compétitions de jeux vidéo et des conférences.

Les visiteurs peuvent 
- consulter les évènements, competitions, conférences
- consulter les participants aux compétitions
- consulter le ranking des competitions

Les utilisateurs peuvent 
- s'inscrire sur site
- se connecter 
- voir la liste d'évènement et leur détail
- s'inscrire à une compétition

Les admins peuvent
- modifier le rôle d'un utilisateur.
- supprimer un utilisateur
- ajouter / moddifier / supprimer un évènement
- ajouter / moddifier / supprimer une competition
- ajouter / moddifier / supprimer une conférence
- ajouter / moddifier / supprimer un jeux
- modifier le ranking d'une équipe

## Environnement : 
Java  
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-starter-validation
- mysql-connector-j
- Lombok
- spring-boot-starter-test
- Thymeleaf
- ByCrypt
 
Thymeleaf

### Pourquoi cet environnement :
Java est un langage compilé, permettant un code plus fiable.

## Organisation : 

### Site
- organisation MCV

### APIRest

#### Routes

- Competition
  - GET : /competitions/ 
  - GET : /competitions/{id}
  - DEL : /competitions/{id}
  - PUT : /competitions/{id}
  - POST : /competitions/
- Conference
  - GET : /conferences/
  - GET : /conferences/{id}
  - DEL : /conferences/{id}
  - PUT : /conferences/{id}
  - POST : /conferences/
- Event
  - GET : /events/
  - GET : /events/{id}
  - DEL : /events/{id}
  - PUT : /events/{id}
  - POST : /events/
- Role
    - GET : /roles/
    - GET : /roles/{id}
    - DEL : /roles/{id}
    - PUT : /roles/{id}
    - POST : /roles/
- Team
  - GET : /teams/
  - GET : /teams/{id}
  - DEL : /teams/{id}
  - PUT : /teams/{id}
  - POST : /teams/
- TeamUser
  - GET : /teamUsers/
  - GET : /teamUsers/{id}
  - DEL : /teamUsers/{id}
  - PUT : /teamUsers/{id}
  - POST : /teamUsers/
- User
   - GET : /users/
   - GET : /users/{id}
   - DEL : /users/{id}
   - PUT : /users/{id}
   - POST : /users/
- VideoGame
  - GET : /videoGames/
  - GET : /videoGames/{id}
  - DEL : /videoGames/{id}
  - PUT : /videoGames/{id}
  - POST : /videoGames/

## Améliorations

- finir la gestion des droits et autorizations
- état de connection des utilisateurs
- gestion des erreurs
- Finir les routes 
  - conférence // invités
  - joueur // équipe
  
- calcule du nombre d'équipe inscrite 
- calcule du nombre de place restantes
- test unitaire 
- harmoniser le front
- gestion d'un role "BAN"


