<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main>
    <div class="container">
        <hi>All Maps</hi>
        <div class="row">
            <div class="col-xl-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Map Name</th>
                            <th scope="col">Map Unlock Level</th>
                            <th scope="col">Map GameModes</th>
                            <th scope="col">Max Allowable Players</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${maps}" var="map">
                            <tr>
                                <%--<td><img src="${appURL}/images/personal_project/${character.character_name}.jpg"></td>--%>
                                    <td>${map.mapName}</td>
                                    <td>${map.mapUnlockLevel}</td>
                                <td>${map.mapGameModes}</td>
                                <td>${map.playerCount}</td>
                                <%--<c:if test=""--%>
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
