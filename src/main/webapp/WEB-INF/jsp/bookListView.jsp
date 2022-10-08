<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Book Project | Home - List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>

<body style="height: 100vh" class="p-0 d-flex flex-column">
<!-- Image and text -->
<main class="flex-grow-1 d-flex flex-column">
    <header class="header container-fluid bg-dark shadow- m-0 p-0">
        <nav class="navbar navbar-light bg-dark p-3">
            <div class="navbar-nav  d-flex flex-row">
                <a class="nav-item nav-link text-white mx-2"
                   href="${pageContext.request.contextPath}/books/all">Home</a>
                <a class="nav-item nav-link text-white mx-2" href="#">Our books</a>
                <a class="nav-item nav-link text-white mx-2" href="#">Discover</a>
                <a class="nav-item nav-link text-white mx-2" href="${pageContext.request.contextPath}/books/add">Add a book</a>
            </div>
        </nav>
    </header>
    <div class="shadow p-2 mb-3" style="height: 4rem;
    background-color: rgba(0, 0, 0, .1);
    border: solid rgba(0, 0, 0, .15);
    border-width: 1px 0;
    box-shadow: inset 0 0.5em 1.5em rgb(0 0 0 / 10%), inset 0 0.125em 0.5em rgb(0 0 0 / 15%);">
        <h1 class="text-center">
            Book List
        </h1>
    </div>
    <!-- Search bar -->
    <div class="container-fluid align-items-center d-flex justify-content-center mt-4 mb-5">
        <form method="get" action="${pageContext.request.contextPath}/books/all"
              class="form-inline w-25 d-flex">
            <input class="form-control mr-sm-2 btn-outline-dark text-dark mx-2" type="search" name="search"
                   placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-dark my-2 my-sm-0 w-25" type="submit">Search</button>
        </form>
    </div>
    <!-- Book list display -->
    <div class="container">
        <div class="row d-flex flex-wrap justify-content-center justify-content-md-start">
            <c:forEach items="${books}" var="book">
                <div style="min-height: 500px" class="col-8 col-md-3 col-lg-3 mb-2">
                    <div class="card h-100 p-2 shadow">
                        <img class="card-img-top border shadow-sm" src="${book.pictureUrl}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${book.name}</h5>
                            <p class="card-text">Publication date : ${book.publishingDate}</p>
                        </div>
                        <a href="#" class="btn btn-dark mb-1">${book.author}</a>
                        <a class="btn btn-dark mb-1" data-toggle="collapse1"
                           href="${pageContext.request.contextPath}/books/details/${book.id}" role="button"
                           aria-expanded="false" aria-controls="collapseExample1">
                            Buy
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>
<footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Features</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Pricing</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
    </ul>
    <p class="text-center text-muted">© 2021 Company, Inc</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>