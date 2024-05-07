<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-2 mb-md-0">
            <a href="${appURL}" class="d-inline-flex link-body-emphasis text-decoration-none">

            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${appURL}/dbzGame" class="nav-link px-2 link-info<c:if test="${pageTitle eq 'Home'}"></c:if>"><fmt:message key="topNav.home"></fmt:message></a></li>
            <li><a href="${appURL}/all-characters" class="nav-link px-2 link-info<c:if test="${pageTitle eq 'Characters'}"></c:if>"><fmt:message key="topNav.Characters"></fmt:message></a></li>
            <li><a href="${appURL}/all-maps" class="nav-link px-2 link-info<c:if test="${pageTitle eq 'Maps'}"></c:if>"><fmt:message key="topNav.Maps"></fmt:message></a></li>
            <li><a href="${appURL}/all-abilities-items" class="nav-link px-2 link-info<c:if test="${pageTitle eq 'Abilities and Items'}"></c:if>"><fmt:message key="topNav.AbilitiesAndItems"></fmt:message></a></li>
            <li><a href="${appURL}/about" class="nav-link px-2 link-info<c:if test="${pageTitle eq 'About'}"></c:if>"><fmt:message key="topNav.About"></fmt:message></a></li>


            <%--<c:if test="${sessionScope.activeUser.privileges eq 'player'}">
                <li><a href="#" class="nav-link px-2 link-info">Player Info</a></li>
            </c:if>--%>

            <c:if test="${sessionScope.activeUser.privileges eq 'admin'}">
                <li><a href="${appURL}/all-players" class="nav-link px-2 link-info<c:if test="${pageTitle eq 'All Accounts'}"></c:if>"><fmt:message key="topNav.AllAccounts"></fmt:message></a></li>
            </c:if>

            <%--<c:if test="${sessionScope.activeUser.privileges eq 'player' or sessionScope.activeUser.privileges eq 'admin'}">
                <li><a href="#" class="nav-link px-2 link-info">The Dbz Game</a></li>
            </c:if>--%>

        </ul>

        <div class="col-md-3 text-end">
            <c:choose>
                <c:when test="${empty sessionScope.activeUser}">
                    <a href="${appURL}/login" class="btn btn-outline-orange me-2">Log in</a>
                    <a href="${appURL}/createAccount" type="button" class="btn btn-orange">Create Account</a>
                </c:when>
                <c:otherwise>
                    <a href="${appURL}/logout" type="button" class="btn btn-outline-orange me-2">Log out</a>
                    <a href="${appURL}/edit-profile-servlet" type="button" class="btn btn-orange">Edit Profile</a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</div>
