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
        <%@include file="common/Message.jsp" %>

        <div class="container mt-5">
            <h2>Vehicle Booking</h2>
            <!-- Booking Form -->
            <form action="booking" method="post" onsubmit="return validateForm()">
                <input type="text" name="id" value="${vehicle.vehicleID}" hidden="" />
                <div class="form-group">
                    <label for="vehicleImage">Image</label>
                    <img src="${vehicle.image}" alt="alt"/>
                </div>
                <div class="form-group">
                    <label for="vehiclePrice">Price (a day)</label>
                    <input type="text" class="form-control" name="price" value="${vehicle.price}" required>
                </div>
                <!-- Start Date -->
                <div class="form-group">
                    <label for="startDate">Start Date:</label>
                    <input type="date" class="form-control" id="startDate" name="startDate" onchange="calculateAmount()" required>
                </div>

                <!-- End Date -->
                <div class="form-group">
                    <label for="endDate">End Date:</label>
                    <input type="date" class="form-control" id="endDate" name="endDate" onchange="calculateAmount()" required>
                </div>

                <!-- Amount -->
                <div class="form-group">
                    <label for="amount">Amount:</label>
                    <input type="text" class="form-control" id="amount" name="amount" readonly>
                </div>

                <button type="submit" class="btn btn-primary">Book Vehicle</button>
            </form>
        </div>

        <script>
            function calculateAmount() {
                var startDate = new Date(document.getElementById("startDate").value);
                var endDate = new Date(document.getElementById("endDate").value);
                var pricePerDay = parseFloat(document.getElementsByName("price")[0].value);

                if (startDate && endDate && !isNaN(pricePerDay)) {
                    var timeDiff = Math.abs(endDate.getTime() - startDate.getTime());
                    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
                    var amount = diffDays * pricePerDay;
                    document.getElementById("amount").value = amount.toFixed(2);
                }
            }

            function validateForm() {
                var startDate = new Date(document.getElementById("startDate").value);
                var endDate = new Date(document.getElementById("endDate").value);

                if (startDate >= endDate) {
                    alert("End date must be after start date");
                    return false;
                }

                return true;
            }
        </script>


        <%@include file="common/footer.jsp" %>
    </body>
</html>
