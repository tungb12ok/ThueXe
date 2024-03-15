<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Vehicles</title>
        <!-- Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="common/header.jsp" %>

        <div class="container mt-5">
            <h2>List of Vehicles</h2>
            <div class="row">
                <c:forEach var="vehicle" items="${vehicleList}">
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <%@include file="common/Message.jsp" %>
                            <img src="${vehicle.image}" class="card-img-top" alt="Vehicle Image">
                            <div class="card-body">
                                <h5 class="card-title">${vehicle.name}</h5>
                                <p class="card-text">${vehicle.description}</p>
                                <p class="card-text">Price: $${vehicle.price}</p>
                                <a href="booking?id=${vehicle.vehicleID}" class="btn btn-primary">Book Now</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <%@include file="common/footer.jsp" %>
    </body>
</html>
