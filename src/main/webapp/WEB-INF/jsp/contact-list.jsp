<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Phonebook: list</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <%@ page isELIgnored="false" %>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h3 class="text-center">All contacts/h3>
        <hr/>

        <input class="btn btn-primary" type="button" value="Add Contact"
               onclick="window.location.href='showForm'; return false;"/>
        <br/>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Contact List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Phones</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our contacts -->
                    <c:forEach var="tempContact" items="${contacts}">

                        <!-- construct an "update" link with contact id -->
                        <c:url var="updateLink" value="/contact/updateForm">
                            <c:param name="contactId" value="${tempContact.id}"/>
                        </c:url>

                        <!-- construct an "delete" link with contact id -->
                        <c:url var="deleteLink" value="/contact/delete">
                            <c:param name="contactId" value="${tempContact.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempContact.name}</td>
                            <td>${tempContact.phones}</td>
                            <td>
                                <!-- display the update link -->
                                <a href="${updateLink}">Update</a> | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this contact?')))
                                         return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p>Footer</p>
</div>
</body>

</html>