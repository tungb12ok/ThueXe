<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Registration</title>
        <!-- Link to Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

        <%@include file="common/header.jsp" %>
        <%@include file="common/Message.jsp" %>

        <div class="container mt-5">
            <h2>User Registration</h2>
            <form action="register" method="post" onsubmit="return validateForm()" class="needs-validation" novalidate>
                <div class="mb-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" id="username" name="username" class="form-control" required>
                    <div class="invalid-feedback">
                        Please enter a username.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" required>
                    <div class="invalid-feedback">
                        Please enter a valid email address.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                    <div class="invalid-feedback">
                        Please enter a password.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
                    <div class="invalid-feedback">
                        Passwords do not match.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address:</label>
                    <input type="text" id="address" name="address" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone:</label>
                    <input type="text" id="phone" name="phone" class="form-control">
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>

        <%@include file="common/footer.jsp" %>

        <script>
            // Use Bootstrap's validation styles and feedback
            function validateForm() {
                var form = document.forms[0];
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
                return form.checkValidity();
            }
        </script>

        <!-- Link to Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
    </body>
</html>
