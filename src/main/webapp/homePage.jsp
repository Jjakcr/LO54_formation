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

<%@include file="htmlTemplates/header.html"%>

<body>
    <h1><font color="blue"><u>All training sessions</u></font></h1>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Code</th>
                <th>Training sessions</th>
                <th>Location</th>
                <th>Start date</th>
                <th>End dates</th>
                <th></th>
            </tr>
            <tr>
                <th>
                    <select>
                        <%  
                            ServiceFormation service = new ServiceFormation();
                            List result = service.getAllFormationSession();
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
                <th></th>
            </tr>
        </thead>

        <tbody>                
            <%
                for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                    CourseSession csS = (CourseSession) iterator.next();
            %>
            <tr>
                <%
                out.print("<td>" + csS.getCourse().getCode() + "</td>"
                + "<td>" + csS.getCourse().getTitle()+ "</td>"
                + "<td>" + csS.getLocation().getCity()+ "</td>"
                + "<td>" + csS.getStartDate() + "</td>"
                + "<td>" + csS.getEndDate() + "</td>");
                %>
                <td>
                    <button type="button" class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-plus" data-toggle="modal" data-target="#register">
                        </span>
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                          </div>
                          <div class="modal-body">
                            ...
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                          </div>
                        </div>
                      </div>
                    </div>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
        
    </div>
    </br>
    
    <button class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span> Previous </button>
    <a href="/lo54/src/report1.jasper"><button class="btn btn-success"><span class="glyphicon glyphicon-save-file"></span> Print PDF </button></a>
    <button class="btn btn-primary"> Next <span class="glyphicon glyphicon-chevron-right"></span></button>

<%@include file="htmlTemplates/footer.html"%>