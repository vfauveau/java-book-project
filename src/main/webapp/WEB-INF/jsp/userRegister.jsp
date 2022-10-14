<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Book Project | Register</title>
</head>
<body>
<%--
<form action="${pageContext.request.contextPath}/register" method="post">
    <h1>REGISTER</h1>
    <div>
        <label for="email">Email</label>
        <input id="email" type="email" name="email" required>
    </div>
    <div>
        <label for="password">Password</label>
        <input id="password" type="password" name="password" required>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button type="submit">Sign Up</button></form>
    --%>
<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="createUser">
    <h1>REGISTER</h1>

    <form:errors path="*" cssClass="alert alert-danger"></form:errors>

    <div>
        <label for="email">Email</label>
        <form:input id="email" type="email" path="email"/>
        <form:errors path="email" cssClass="alert alert-danger"> </form:errors>
    </div>
    <div>
        <label for="password">Password</label>
        <form:input id="password" type="password" path="password" />
        <form:errors path="password" cssClass="alert alert-danger"> </form:errors>
    </div>
    <from:button>Sign Up</from:button>
</form:form>
</body>
</html>