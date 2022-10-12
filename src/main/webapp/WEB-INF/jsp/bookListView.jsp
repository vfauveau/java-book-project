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

    <c:import url="header.jsp"/>
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
              class="form-inline w-50 d-flex">
            <input class="form-control mr-sm-2 btn-outline-dark text-dark mx-2" type="search" name="search"
                   placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-dark my-2 my-sm-0 w-25" type="submit">Search</button>
        </form>
    </div>
    <!-- Book list display -->
    <div class="container">
        <div class="row d-flex flex-wrap justify-content-center justify-content-lg-start">
            <c:forEach items="${books}" var="book">
                <div style="min-height: 500px; max-height: max-content" class="col-8 col-md-5 col-lg-4 col-xl-3 mb-2">
                    <div class="card h-100 p-2 shadow d-flex flex-column" style="min-height: 500px; max-height: max-content" >
                        <img class="card-img-top border shadow-sm h-75 " src="${book.pictureUrl}"
                             alt="Card image cap">
                        <div class="card-body h-25">
                            <span class="card-title"><b>${book.name}</b></span>
                            <p class="card-text">Prix : ${book.price}€</p>
                            <a class="btn btn-dark mb-1 w-100" data-toggle="collapse1"
                               href="${pageContext.request.contextPath}/books/details/${book.id}" role="button"
                               aria-expanded="false" aria-controls="collapseExample1">
                                Buy
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<c:import url="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>