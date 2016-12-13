<%-- 
    Document   : Catalogue
    Created on : 9 déc. 2016, 10:31:30
    Author     : Pauline
--%>

<%@page import="fr.utbm.formation.core.repository.LocationDAO"%>
<%@page import="fr.utbm.formation.core.entity.*"%>
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
        <table >
            <caption>Liste des formations existantes</caption>
            <%
                ServiceFormation service = new ServiceFormation();
                List result = service.getAllFormation();
            %>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Training sessions</th>
                    <th>Location</th>
                </tr>
                <tr>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    
                                    // TODO : Course c needs to be changed ... 
                                    Course c = (Course) iterator.next();
                                    out.print("<option value=\""+ c.getCode() + "\">"); 
                                    out.print(c.getCode() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    
                                    // TODO : Course c needs to be changed ...
                                    Course c = (Course) iterator.next();
                                    out.print("<option value=\"" + c.getTitle() + "\">"); 
                                    out.print(c.getTitle() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    
                                    // TODO : Course c needs to be changed ...
                                    Course c = (Course) iterator.next();
                                    out.print("<option value=\"" + c.getTitle() + "\">"); 
                                    out.print(c.getTitle() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                </tr>
            </thead>
            
            <tbody>                
                <%
                    for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                        out.print("iterator");
                        Course c = (Course) iterator.next();
                        out.print("<tr> <td>" + c.getCode() + "</td>");
                        out.print("<td>" + c.getTitle() + "</td>");
                        out.print("<td>" + c.getTitle() + "</td> </tr>");
                    }
                    
                        
                %>
            </tbody>
        </table>
                    
        <a href="/lo54/src/report1.jasper"><button>Print PDF</button></a>
    </body>
</html>
