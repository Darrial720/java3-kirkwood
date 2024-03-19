<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main>
    <div class="container">
        <hi>All Playable Characters</hi>
        <div class="row">
            <div class="col-xl-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Status</th>
                            <th scope="col">Unlock Level</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${characters}" var="character">
                            <tr>
                                <td>${character.character_name}</td>
                                <td>${character.character_status}</td>
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
