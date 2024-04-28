<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main>
    <div class="container">
        <hi>All Items and Abilities</hi>
        <div class="row">
            <div class="col-xl-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Ability Match up</th>
                            <th scope="col">Unlock Level</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ItemsAbilities}" var="itemAbility">
                            <tr>
                                <td>${itemAbility.item_ability_name}</td>
                                <td>${itemAbility.fk_ability_match_up}</td>
                                <td>${character.fk_item_unlock_level}</td>
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