<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main>
    <form class="d-flex" action="all-characters" method="POST">
        <input name="q" value="${q}" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <input name="sort" value="${s}" type="hidden">
        <input name="strCategory" value="${strCharacter}" type="hidden">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
    <c:if test="${sessionScope.activeUser.privileges eq 'admin'}">
        <a href="${appURL}/create-character" class="btn btn-outline-orange me-2">Create Character</a>
    </c:if>
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
                                <%--<c:if test="${sessionScope.activeUser.privileges eq 'admin'}">
                                <td><a href="${appURL}/delete-character" class="btn btn-outline-orange me-2">Delete Character</a></td>
                                <td></td>
                                </c:if>--%>
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
