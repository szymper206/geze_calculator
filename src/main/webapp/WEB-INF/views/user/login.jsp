<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form method="post">
    <div><label> Email : <input type="text" name="username"/> </label></div>
    <div><label> Hasło: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Zaloguj"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
