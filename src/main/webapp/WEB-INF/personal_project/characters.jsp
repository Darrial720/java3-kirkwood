<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Sort
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="/all-characters?sort=az&q=${q}&character=${strCharacter}">A-Z</a></li>
                    <li><a class="dropdown-item" href="/all-characters?sort=za&q=${q}&character=${strCharacter}">Z-A</a></li>
                </ul>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Filter by Character
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <li><a class="dropdown-item" href="/all-characters?sort=${s}&q=${q}&character=">ALL</a></li>
                    <c:forEach items="${cats}" var="strCategory">
                        <li><a class="dropdown-item" href="/all-characters?sort=${s}&q=${q}&strCharacter=${strCharacter}">${strCharacter}</a></li>
                    </c:forEach>
                </ul>
            </li>
        </ul>
    </div>
        <form class="d-flex" action="all-characters" method="POST">
            <input name="q" value="${q}" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <input name="sort" value="${s}" type="hidden">
            <input name="strCategory" value="${strCharacter}" type="hidden">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <div class="container">
        <hi>All Playable Characters</hi>
        <div class="row">
            <div class="col-xl-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Character Image</th>
                            <th scope="col">Name</th>
                            <th scope="col">Unlock Level</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${characters}" var="character">
                            <tr>
                                <td><img src="${appURL}/images/personal_project/${character.character_name}.jpg"></td>
                                <td>${character.character_name}</td>
                                <td>${character.character_unlock_level}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>


</main>

<%@include file="/WEB-INF/personal_project/bottom.jsp"%>
