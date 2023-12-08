
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html>
<head>
    <title>Dragonballz Characters</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Dragonballz Characters</h1>
    <p class="lead">There ${characters.size() == 1 ? "is" : "are"} ${characters.size()} character${characters.size() != 1 ? "s" : ""}</p>
    <c:if test="${characters.size() > 0}">
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Character ID</th>
                <th scope="col">Character Name</th>
                <th scope="col">Character Status</th>
                <th scope="col">Character Unlock Level</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${characters}" var="character">
                <tr>
                    <th scope="row">${character.characterID}</th>
                    <td>${character.characterName}</td>
                    <td>${character.characterStatus}</td>
                    <td>${character.fk_character_unlock_level}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
