
<%@include file="/WEB-INF/learnx/top.jsp"%>
<main>
    <div class="container">
        <div class="row">
            `           <%@include file="/WEB-INF/learnx/left-side-bar.jsp"%>

            <dv class="col-xl-9">
                <div class="card border rounded-3">
                    <div class="card-header border-bottom">
                        <h3 class="card-header-title">${pageTitle}</h3>
                    </div>
                    <div class="card-body">
                        <%@include file="/WEB-INF/shared/flashMessage.jsp"%>

                        <form action="${appURL}/edit-user" method="POST">
                            <input type="hidden" name="id" value="${user.id}">


                            <div class="row g-4">
                                <!-- First Name -->
                                <div class="col-md-6">
                                    <label for="firstNameInput" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="firstNameInput" name="firstNameInput" value="${fn:escapeXml(user.firstName)}">
                                </div>

                                <!-- Last Name -->
                                <div class="col-md-6">
                                    <label for="lastNameInput" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="lastNameInput" name="lastNameInput" value="${fn:escapeXml(user.lastName)}">
                                </div>

                                <!-- Email id -->
                                <div class="col-md-6">
                                    <label class="form-label" for="emailInput">Email</label>
                                    <input class="form-control" type="text" id="emailInput" name="emailInput" value="${fn:escapeXml(user.email)}">
                                </div>

                                <!-- Phone number -->
                                <div class="col-md-6">
                                    <label class="form-label" for="phoneInput">Phone number</label>
                                    <input type="text" class="form-control" id="phoneInput" name="phoneInput" value="${fn:escapeXml(user.phone)}">
                                </div>

                                <div class="col-md-6">
                                    <label for="languageInput" class="form-label">Language</label>
                                    <select name="languageInput" id="languageInput" class="form-select <c:if test="${not empty results.languageError}">is-invalid</c:if>">
                                        <option value="en-US" ${user.language eq 'en-US' ? 'selected' : ''}>English</option>
                                        <option value="fr-FR" ${user.language eq 'fr-FR' ? 'selected' : ''}>French</option>
                                        <option value="ja-JP" ${user.language eq 'ja-JP' ? 'selected' : ''}>Japanese</option>
                                    </select>
                                    <c:if test="${not empty results.languageError}">
                                        <div class="invalid-feedback">
                                                ${results.languageError}
                                        </div>
                                    </c:if>
                                </div>

                                <div class="col-md-6">
                                    <label for="statusInput" class="form-label">Language</label>
                                    <select name="statusInput" id="statusInput" class="form-select <c:if test="${not empty results.statusError}">is-invalid</c:if>">
                                        <option value="inactive" ${user.status eq 'inactive' ? 'selected' : ''}>Inactive</option>
                                        <option value="active" ${user.status eq 'active' ? 'selected' : ''}>Active</option>
                                        <option value="locked" ${user.status eq 'locked' ? 'selected' : ''}>Locked</option>
                                    </select>
                                    <c:if test="${not empty results.statusError}">
                                        <div class="invalid-feedback">
                                                ${results.statusError}
                                        </div>
                                    </c:if>
                                </div>

                                <div class="col-md-6">
                                    <label for="privilegesInput" class="form-label">Language</label>
                                    <select name="privilegesInput" id="privilegesInput" class="form-select <c:if test="${not empty results.privilegesError}">is-invalid</c:if>">
                                        <option value="student" ${user.privileges eq 'student' ? 'selected' : ''}>Student</option>
                                        <option value="teacher" ${user.privileges eq 'teacher' ? 'selected' : ''}>Teacher</option>
                                        <option value="admin" ${user.privileges eq 'admin' ? 'selected' : ''}>Admin</option>
                                    </select>
                                    <c:if test="${not empty results.privilegesError}">
                                        <div class="invalid-feedback">
                                                ${results.privilegesError}
                                        </div>
                                    </c:if>
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
