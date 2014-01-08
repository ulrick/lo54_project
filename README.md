lo54_project
============

Il s'agit de gérer l'offre de formation d'une école privée.
L'école édite un catalogue en ligne (HTML) listant toutes les formations disponibles et
pour chaque formation, les dates des prochaines sessions prévues.
L'utilisateur doit être capable de :

- filtrer la liste des formations par un mot clé contenu dans le titre de la formation.
- filtrer la liste des formations par les sessions disponibles à une date donnée.
- filtrer la liste des formations en fonction du lieu de la session, ce lieu provenant d'une liste déroulante.

L'utilisateur doit pouvoir sélectionner une session et s'y pré-inscrire en indiquant ses
coordonnées personnelles (Nom, Prénom, Adresse, Téléphone, Email).
Pour ne pas compliquer le modèle, on considérera qu'une même personne s'inscrivant à
2 sessions est alors présente 2 fois dans la base.

Il n'est pas demandé de créer une interface d'administration pour gérer les données de la
base.


C'est un projet MAVEN réalisé avec l'API Eclipse. 
technologie : 
	JAVA EE 6 /JSR-330 utilisant le framework Google Guice pour l'injection des dépendances 
	TomEE (Tomcat + JavaEE) comme environnement d’exécution. 
	HIBERNATE pour la persistance des données
	MySQL comme base de données.


