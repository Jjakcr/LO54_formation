<%-- 
    Document   : Catalogue
    Created on : 9 déc. 2016, 10:15:30
    Author     : Jean- Jacques
--%>

<%@page import="fr.utbm.formation.core.entity.CourseSession"%>
<%@page import="fr.utbm.formation.core.tools.JasperUtil"%>
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
                       
                        List result = (List) request.getAttribute("result");
                        if (result.isEmpty()){
                            out.println("ohohoh");
                        }
                           for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                                CourseSession csS = (CourseSession) iterator.next();
                                out.println("<h1>" + csS.getCourse().getCode() + "</h1>");
                                out.println("<h1>"+csS.getCourse().getCode() + "</h1>");
                            }

                        
                    %>
               

            </tbody>
        </table>
                    
                   
                    <button type="submit" name="pdf">créer un pdf</button>
    </body>
</html>
