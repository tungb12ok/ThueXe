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
            <h2>Management Booking</h2>
            <table class="table mt-3">
                <thead>
                    <tr>
                        <th>bookingID</th>
                        <th>userID</th>
                        <th>vehicleID</th>
                        <th>startDate</th>
                        <th>endDate</th>
                        <th>amount</th>
                        <th>status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="b" items="${bookL}">
                        <tr>
                            <td>${b.bookingID}</td>
                            <td>${b.userID}</td>
                            <td>${b.vehicleID}</td>
                            <td>${b.startDate}</td>
                            <td>${b.endDate}</td>
                            <td>${b.amount}</td>
                            <td>${sDAO.getStatusById(b.status).getName()}</td>
                            <c:if test="${b.status == 3}">
                                <td>
                                    <a href="updateStatus?id=${b.bookingID}&status=5" class="btn btn-primary">Paid</a>
                                    <a href="updateStatus?id=${b.bookingID}&status=7" class="btn btn-danger">Cancel</a>
                                </td>
                            </c:if>
                            <c:if test="${b.status == 5}">
                                <td>
                                    <a href="updateStatus?id=${b.bookingID}&status=8" class="btn btn-primary">Ative</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%@include file="common/footer.jsp" %>
    </body>
</html>
