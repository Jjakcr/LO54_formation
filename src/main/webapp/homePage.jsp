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
        <h1><font color="blue"><u>All training sessions</u></font></h1>
        
        <table>
            
            <%
                ServiceFormation service = new ServiceFormation();
                List result = service.getAllFormationSession();
            %>
            
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Training sessions</th>
                    <th>Location</th>
                    <th>Start date</th>
                    <th>End dates</th>
                </tr>
                
                <tr>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                                    CourseSession csS = (CourseSession) iterator.next();
                                    out.print("<option value=\""+ csS.getCourse().getCode()+ "\">"); 
                                    out.print(csS.getCourse().getCode() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    CourseSession csS = (CourseSession) iterator.next();
                                    out.print("<option value=\"" + csS.getCourse().getTitle() + "\">"); 
                                    out.print( csS.getCourse().getTitle() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    CourseSession csS = (CourseSession) iterator.next();
                                    out.print("<option value=\"" + csS.getLocation().getCity() + "\">"); 
                                    out.print(csS.getLocation().getCity() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    CourseSession csS = (CourseSession) iterator.next();
                                    out.print("<option value=\"" + csS.getStartDate() + "\">"); 
                                    out.print(csS.getStartDate() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                    <th>
                        <select>
                            <%
                                for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
                                    CourseSession csS = (CourseSession) iterator.next();
                                    out.print("<option value=\"" + csS.getEndDate() + "\">"); 
                                    out.print(csS.getEndDate() + "</option>");
                                }
                            %>
                        </select>
                    </th>
                </tr>
            </thead>
            
            <tbody>                
                <%
                    for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                        CourseSession csS = (CourseSession) iterator.next();
                        out.print("<tr>"
                                    + "<td>" + csS.getCourse().getCode() + "</td>"
                                    + "<td>" + csS.getCourse().getTitle()+ "</td>"
                                    + "<td>" + csS.getLocation().getCity()+ "</td>"
                                    + "<td>" + csS.getStartDate() + "</td>"
                                    + "<td>" + csS.getEndDate() + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
        </table>
        </br>                    
        <a href="/lo54/src/report1.jasper"><button>Print PDF</button></a>
    </body>
</html>
