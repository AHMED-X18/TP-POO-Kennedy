## Getting Started

Le projet présenté ici est une application qui matérialise une boutique de vente d'appareils électroniques. 
Pour un client donné, il doit être capable d'acheter un article qui lui est présenté, de vérifier s'il est volé et si c'est le cas, il doit avoir les informations du propriétaire et lui renseigner sur la localisation de son appareil.

## Folder Structure

Le dossier représentant ce projet contient :

- `src`: le dossier qui contient la source et le code principal (App.java)
- `lib`: le dossier qui maintient les dépendances (principalement le JDBC)
Pour l'interface graphique, c'est java SWing qui est utilisé

Il est aussi associé à ce projet, le fichier SQL qui représente la base de données liée au projet ainsi que les différentes tables qui contiennent les instances qui ont servi d'exemple pour l'implémentation.

Dans le fichier App.java, on a d'abord la classe BackgroundPanel qui represente la classe pour l'image en arrière-plan. Ensuite, la classe PhoneList qui represente la classe qui gère les téléphones. Elle a pour caractéristique les éléments nécessaires pour se connecter à la base de données. On a les méthodes :
- loadPhones() qui permet de charger la liste ds téléphones à partir de la BD; 
- addPhonePanel() qui ajoute un téléphone sur la fenetre;
- createPhonePanel() qui permet d'écrire les caractéristiques du téléphone sur la fenetre; 
- addButtons() qui permet d'ajouter les boutons sur la fenetre
- CheckifStolen() qui contient la logique qui se produit lorsque le téléphone a été volé ou non

De plus, on a la classe ComputerList qui represente la classe qui gère les ordinateurs. Elle possède les mêmes attributs et méthodes (i.e la même logique) que la classe précédente.

Enfin on a la classe Main qui est le centre d'exécution de l'application. Elle instancie d'abord une fenetre JFrame sur laquelle s'affichera l'application elle même. A premiere vue, nous aurons un texte de bienvenue généré par un code HTML, sur une image de fond et deux boutons : "Acheter un téléphone" et "Acheter un ordinateur" qui lorsqu'en cliquant sur l'un ou sur l'autre implémente la classe qui lui représente.

En ce qui concerne la base de données nommée POO_1; elle contient 04 tables:
- une table Ordinateur qui matérialise la classe des ordinateurs et ses attributs
- une table Téléphone qui matérialise la classe des téléphones et ses attributs
- une table Propriétaire qui contient les différents propriétaires d'appareils
- une table Voler qui contient les données sur un appareil qui a été signalé volé par un propriétaire