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
            <h2>Add Vehicle</h2>
            <form action="updateVehicle" method="post">
                <div class="form-group">
                    <input type="hidden" name="vehicleID" value="${vehicle.vehicleID}">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${vehicle.name}" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" required>${vehicle.description}</textarea>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" value="${vehicle.price}" required>
                </div>
                <div class="form-group">
                    <label for="image">Image:</label>
                    <input type="text" class="form-control-file" id="image" name="image" value="${vehicle.image}">
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status" required>
                        <c:forEach var="i" items="${listS}">
                            <option value="${i.id}" <c:if test="${i.id eq vehicle.status}">selected</c:if>>${i.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Update Vehicle</button>
            </form>
        </div>
        <%@include file="common/footer.jsp" %>
    </body>
</html>
