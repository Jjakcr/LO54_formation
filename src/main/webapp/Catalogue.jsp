<%-- 
    Document   : Catalogue
    Created on : 9 déc. 2016, 10:15:30
    Author     : Jean- Jacques
--%>

<%@page import="fr.utbm.formation.core.entity.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.formation.core.service.ServiceFormation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue en ligne</title>
    </head>
    <body>
        <h1>test!</h1>
        <table border="1">
            <caption>Liste des formations existantes</caption>
            <tr>
                <th>Code formation</th>
                <th>Titre formation</th>
            </tr>
            <tbody>
                
                    <%
                        ServiceFormation service = new ServiceFormation();
                        List result = service.getAllFormation();
                        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                            Course c = (Course) iterator.next();

                            out.print("<tr> <td>" + c.getCode() + "</td>");
                            out.print("<td>" + c.getTitle() + "</td> </tr>");
                        }


                    %>
               

            </tbody>
        </table>
    </body>
</html>
