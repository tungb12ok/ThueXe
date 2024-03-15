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
            <form action="addVehicle" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" required></textarea>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" required>
                </div>
                <div class="form-group">
                    <label for="image">Image:</label>
                    <input type="text" class="form-control-file" id="image" name="image">
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status" required disabled="">
                        <c:forEach var="i" items="${listS}">
                            <option value="${i.id}">${i.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add Vehicle</button>
            </form>
        </div>
        <%@include file="common/footer.jsp" %>
    </body>
</html>
