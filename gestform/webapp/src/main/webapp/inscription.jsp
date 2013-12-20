<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription à une formation</title>
        <link type="text/css" rel="stylesheet" href="css/inscription_style.css" />
    </head>
    <body>
        <div>
        	<%String sessionid= (String)request.getParameter("sessionId");%>
            <form method="post" action="Inscription">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nomClient"> Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" placeholder="Nom" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" placeholder="Prénom" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseClient">Adresse <span class="requis">*</span></label>
                    <input type="text" id="adresseClient" name="adresseClient" placeholder="Adresse" size="20" maxlength="20" />
                    <br />
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="tel" id="telephoneClient" name="telephoneClient" placeholder="Téléphone" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" placeholder="Mail" size="20" maxlength="60" />
                    <input type="hidden" name="sessionId" value="<%=sessionid%>"/>
                    <br />
                </fieldset>
                <input type="submit" value="S'inscrire"  />
                <input type="reset" value="Annuler" /> <br />
            </form>
        </div>
    </body>
</html>