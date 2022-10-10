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
    <!-- Book add form -->
    <div class="container">
        <div class="row d-flex flex-wrap justify-content-center justify-content-md-start">

            <form class="container h-25 w-50 bg-light rounded-1" method="post" action="${pageContext.request.contextPath}/books/add/">
                <h4 class="form-text h-25 text-center">Add a book</h4>
                <label class="my-2" for="name">Title</label>
                <input class="form-control" type="text" id="name" name="name">

                <%--
                <label class="my-2" for="author">Author</label>
                <input class="form-control" id="author" type="text" name="authorName">
                --%>

                <label class="my-2" for="date">Publishing date</label>
                <input class="form-control" id="date" type="date" name="publishingDate">

                <label class="my-2" for="price">Price</label>
                <input class="form-control" name="price" id="price" min="0" step="0.01" type="number">

                <label class="my-2" for="coverUrl">Picture url</label>
                <input class="form-control" id="coverUrl" type="text" name="pictureUrl">

                <label class="my-2" for="summary">Summary</label>
                <input class="form-control" id="summary" type="text" name="summary">

                <label class="my-2" for="rating">Rating</label>
                <input class="form-control" id="rating" type="number" min="0" max="5" name="rating">
                <input class="form-control my-2 " type="submit">
            </form>

        </div>
    </div>
</main>
<c:import url="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>