
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Meal Category Directory</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Category Directory</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Sort
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="meals-json?sort=az&q=${q}&category=${strCategory}">A-Z</a></li>
                        <li><a class="dropdown-item" href="meals-json?sort=za&q=${q}&category=${strCategory}">Z-A</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Filter by Category
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <li><a class="dropdown-item" href="meals-json?sort=${s}&q=${q}&category=">ALL</a></li>
                        <c:forEach items="${cats}" var="strCategory">
                            <li><a class="dropdown-item" href="meals-json?sort=${s}&q=${q}&strCategory=${strCategory}">${strCategory}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="meals-json" method="GET">
                <input name="q" value="${q}" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <input name="sort" value="${s}" type="hidden">
                <input name="strCategory" value="${strCategory}" type="hidden">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>

</nav>
<div class="container my-4">
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Category</th>
                <th scope="col">Image Example</th>
                <th scope="col">Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="category" varStatus="count">
                <tr>
                    <th scope="row">${count.count}</th>
                    <td>${category.strCategory}</td>
                    <td><img src="${category.strCategoryThumb}"></td>
                    <td>${category.strCategoryDescription}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
