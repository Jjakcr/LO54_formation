<%-- 
    Document   : Catalogue
    Created on : 9 déc. 2016, 10:31:30
    Author     : Pauline
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


        <div class="alert alert-info" role="alert" style="display: ${visible}">
            Aucun résultat trouvé
        </div>

        <h1>${inscritOK}</h1>
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
            <form method="post" action="Filter">
                <th>
                </th>
                <th>
                    <input class="form-control" type="text" id="title" name="titleFilter" value="" size="20" maxlength="20" />

                </th>
                <th>
                    <select class="form-control" name="locFilter">
                        <option value = "vide"></option>
                        <c:forEach var="listloc" items="${listLocation}">
                            <option value ="${listloc.city}">${listloc.city}</option>
                        </c:forEach>
                    </select>
                </th>
                <th>

                    <input id="startFilter" name="dateFilter" type="text" class="form-control datepicker" onclick="datePickBug()" >


                </th>
                <th>

                </th>
                <th> <input type="submit" value="Search" class="btn btn-success" /></th>
            </form>
            </tr>


            </thead>

            <tbody>   

                <c:forEach var="list" items="${result}">
                    <tr>

                        <td>

                            ${list.course.code}

                        </td>
                        <td id="title${list.idSession}">

                            ${list.course.title}

                        </td>
                        <td>

                            ${list.location.city}

                        </td>
                        <td>

                            ${list.startDate}

                        </td>
                        <td>

                            ${list.endDate}

                        </td>

                        <td>
                            <button type="button" value="${list.idSession}" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#register" onclick="returnValue(this)">
                                <span class="glyphicon glyphicon-plus" >
                                </span>
                            </button>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
    </br>

    <button class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span> Previous </button>
    <a href="RequestPdf"><button class="btn btn-success"><span class="glyphicon glyphicon-save-file"></span> Print PDF </button></a>
    <button class="btn btn-primary"> Next <span class="glyphicon glyphicon-chevron-right"></span></button>

    <!-- Modal -->
    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Subscribe</h4>
                </div>
                <form class="form-horizontal" method="post" action="Sub">
                    <div  class="modal-body">
                        <input id ="idSess" type="hidden" name="idSess">


                        <div class="form-group">
                            <label class="control-label col-sm-2" for="fisrtN">Firstname:</label>
                            <div class="col-sm-10">
                                <input type="text"  name="firstName" class="form-control" id="fisrtN" placeholder="Enter firstname">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="lastN">Lastname:</label>
                            <div class="col-sm-10">
                                <input type="text"  name="lastName" class="form-control" id="lasrtN" placeholder="Enter lastname">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="addr">Address:</label>
                            <div class="col-sm-10">
                                <input type="text"  name="address" class="form-control" id="addr" placeholder="Enter address">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="phone">Phone:</label>
                            <div class="col-sm-10">
                                <input type="text"  name="phone" class="form-control" id="phone" placeholder="Enter phone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Email:</label>
                            <div class="col-sm-10">
                                <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Subcribe</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@include file="htmlTemplates/footer.html"%>