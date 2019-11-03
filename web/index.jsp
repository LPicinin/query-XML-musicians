<%-- 
    Document   : index
    Created on : 03/11/2019, 14:59:35
    Author     : luish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XML Consulta</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="conFormUser">
            <form action="Consulta" onsubmit="evtEnviaForm()" name="formulario" id="formulario">
                <label>Nome</label>
                <input type="text" placeholder="Nome do Artista" name="nomeArt" required><br>
                <input type="submit" value="Buscar"/>
            </form>
        </div>

        <br>
        <div id="tabela">

        </div>
        <br>
        <br>
        <br>

        <script src="js/jquery-3.4.1.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/myScripts.js" type="text/javascript"></script>


    </body>
</html>
