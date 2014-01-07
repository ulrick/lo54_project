lo54_project
============

Procédure de déployement 

environnement TomEE (Tomcat + javaEE) web profile 


1- Dézipper le fichier "projet_lo54" sur votre bureau 

2- copier dans votre Racine C:/ le dossier "tomee" (environnement d'exécution)

3- importer le fichier gestform_db.sql dans une base de donnée MySQL démarrée

4- Dans éclipse, faite "importer un projet MAVEN" en spécifiant le dossier "webapp" du fichier dézziper   

5- lancer l'application en utilisant l'environnement "tomee" mis sur le C:/
	- faite clic droit sur le projet/run as->run on server. choisissez apache puis
	- spécifier le sous dossier "C:/tomee/apache-tomee-webprofile-1.5.2" 

6- Dans votre navigateur préféré, saisissez http://localhost:8080/webapp/accueil.jsp


