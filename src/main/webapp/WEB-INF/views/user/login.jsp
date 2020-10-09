<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <H1>Logowanie</H1><br>
</div>
<div class="container">
    <form method="post">
        <div class="form-group">
            <label for="username">Email:</label>
            <input type="text" name="username" id="username" class="form-control"/>
        </div>
        <div>
            <label for="password">Hasło:</label>
            <input type="password" name="password" id="password" class="form-control"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Zaloguj</button>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>
</div>
</body>
</html>
