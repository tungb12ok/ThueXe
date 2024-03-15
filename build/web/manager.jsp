<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="common/header.jsp" %>
        <%@include file="common/Message.jsp" %>


        <div class="container mt-5">
            <h2>CRUD Vehicle</h2>
            <div>
                <a href="addVehicle" class="btn btn-primary">Add Vehicle</a>
            </div>
            <table class="table mt-3">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>image</th>
                        <th>status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vehicle" items="${listV}">
                        <tr>
                            <td>${vehicle.vehicleID}</td>
                            <td>${vehicle.name}</td>
                            <td>${vehicle.description}</td>
                            <td>
                                <img src="${vehicle.image}" alt="alt" class="w-30 h-30"/>
                            </td>
                            <td>${vehicle.price}</td>
                            <td>${vehicle.status}</td>
                            <td>
                                <a href="updateVehicle?id=${vehicle.vehicleID}" class="btn btn-primary">Update</a>
                                <a href="deleteVehicle?id=${vehicle.vehicleID}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%@include file="common/footer.jsp" %>
    </body>
</html>
