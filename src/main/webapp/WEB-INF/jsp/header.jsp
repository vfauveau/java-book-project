<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header class="header container-fluid bg-dark shadow- m-0 p-0">
    <nav class="navbar navbar-light bg-dark p-3">
        <div class="navbar-nav  d-flex flex-row">
            <a class="nav-item nav-link text-white mx-2"
               href="${pageContext.request.contextPath}/books/all">Home</a>
            <a class="nav-item nav-link text-white mx-2" href="#">Our books</a>
            <a class="nav-item nav-link text-white mx-2" href="#">Discover</a>
            <a class="nav-item nav-link text-white mx-2" href="${pageContext.request.contextPath}/books/add">Add a
                book</a>
        </div>
    </nav>
</header>
</html>