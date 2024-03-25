<%@include file="/WEB-INF/learnx/top.jsp"%>
<main>
    <%@include file="/WEB-INF/learnx/left-side-bar-header.jsp"%>
    <div class="container">
        <div class="row">
`           <%@include file="/WEB-INF/learnx/left-side-bar.jsp"%>

            <dv class="col-xl-9">
                <div class="card border rounded-3">
                    <div class="card-header border-bottom">
                        <h3 class="card-header-title">${pageTitle}</h3>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty flashMessageSuccess}">
                            <div class="alert alert-success">
                                    ${flashMessageSuccess}
                            </div>
                            <c:remove var="flashMessageSuccess"></c:remove>
                        </c:if>
                        <c:if test="${not empty flashMessageWarning}">
                            <div class="alert alert-warning">
                                    ${flashMessageWarning}
                            </div>
                            <c:remove var="flashMessageSuccess"></c:remove>
                        </c:if>

                        <form action="${appURL}/edit-profile" method="POST">
                        <div class="row g-4">
                            <!-- First Name -->
                            <div class="col-md-6">
                                <label for="firstNameInput" class="form-label">First Name</label>
                                <input type="text" class="form-control" id="firstNameInput" name="firstNameInput" value="${fn:escapeXml(activeUser.firstName)}">
                            </div>

                            <!-- Last Name -->
                            <div class="col-md-6">
                                <label for="lastNameInput" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="lastNameInput" name="lastNameInput" value="${fn:escapeXml(activeUser.lastName)}">
                            </div>

                            <!-- Email id -->
                            <div class="col-md-6">
                                <label class="form-label" for="emailInput">Email</label>
                                <input class="form-control" type="text" id="emailInput" name="emailInput" value="${fn:escapeXml(activeUser.email)}">
                            </div>

                            <!-- Phone number -->
                            <div class="col-md-6">
                                <label class="form-label" for="phoneInput">Phone number</label>
                                <input type="text" class="form-control" id="phoneInput" name="phoneInput" value="${fn:escapeXml(activeUser.phone)}">
                            </div>

                            <div class="col-md-6">
                                <label for="languageInput" class="form-label">Language</label>
                                <select name="languageInput" id="languageInput" class="form-select <c:if test="${not empty results.languageError}">is-invalid</c:if>">
                                    <option value="en-US" ${activeUser.language eq 'en-US' ? 'selected' : ''}>English</option>
                                    <option value="fr-FR" ${activeUser.language eq 'fr-FR' ? 'selected' : ''}>French</option>
                                    <option value="ja-JP" ${activeUser.language eq 'ja-JP' ? 'selected' : ''}>Japanese</option>
                                </select>
                                <c:if test="${not empty results.languageError}">
                                    <div class="invalid-feedback">
                                            ${results.languageError}
                                    </div>
                                </c:if>
                            </div>

                            <div class="col-md-6">
                                <label for="languageInput" class="form-label">Timezone</label>
                                <select name="languageInput" id="timezoneInput" class="form-select">
                                </select>
                            </div>

                            <!-- Save button -->
                            <div class="d-sm-flex justify-content-end">
                                <button type="submit" class="btn btn-primary mb-0">Save changes</button>
                            </div>

                        </div>
                        </form>
                    </div>
                </div>
            </dv>



        </div>
    </div>
</main>
<%@include file="/WEB-INF/learnx/bottom.jsp"%>
