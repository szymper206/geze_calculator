<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Geze Calculator Ver. 0.0.1<br>
<spring:message code="homepage.welcome"/>
<br>
<sec:authorize access="hasRole('ADMIN')">
<a href="/user/register"><input type="submit" value="Rejestracja"></a>
</sec:authorize>
<a href="/login"><input type="submit" value="Logowanie"></a><br>
<sec:authorize access="hasRole('ADMIN')">
<a href="/user/all"><input type="submit" value="Wszyscy użytkownicy"></a>
</sec:authorize>
<a href="/typeOfDrive"><input type="submit" value="Wybór napędu"></a>
<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
