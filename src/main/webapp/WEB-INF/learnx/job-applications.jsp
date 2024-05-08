<%@include file="/WEB-INF/learnx/top.jsp"%>
<main class="container">
    <section class="p-0 d-flex align-items-center position-relative overflow-hidden">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-lg-8 m-auto">
                    <div class="row my-5">
                        <c:choose>
                            <c:when test="${not empty results.Success}">
                                <div class="alert alert-success mb-2">
                                        ${results.Success}
                                </div>
                            </c:when>
                            <c:when test="${not empty results.applicationFail}">
                                <div class="alert alert-danger mb-2">
                                        ${results.applicationFail}
                                </div>
                            </c:when>
                            <c:when test="${not empty results.ApplicationCreationFailure}">
                                <div class="alert alert-danger mb-2">
                                        ${results.ApplicationCreationFailure}
                                </div>
                            </c:when>
                        </c:choose>
                        <div class="col-sm-10 col-xl-8 m-auto">
                            <!-- Form START -->
                            <form action="${appURL}/application?job_id=${jobListing.job_id}" method="post">
                                <c:choose>
                                <c:when test="${not empty results.jobFail}">
                                    <p>${rsults.jobFail}</p>
                                </c:when>
                                <c:otherwise>
                                    <h3>${jobListing.position} Application</h3>
                                    <div class="row g-4">
                                        <!-- Job ID -->
                                        <input type="hidden" name="jobID" value="${jobListing.job_id}">

                                        <!-- First Name -->
                                        <div class="col-md-6">
                                            <label for="firstNameInput" class="form-label">First Name</label>
                                            <input type="text" class="form-control" id="firstNameInput" name="firstNameInput" value="${jobApplication.firstName}" required="required">
                                        </div>

                                        <!-- Last Name -->
                                        <div class="col-md-6">
                                            <label for="lastNameInput" class="form-label">Last Name</label>
                                            <input type="text" class="form-control" id="lastNameInput" name="lastNameInput" value="${jobApplication.lastName}" required="required">
                                        </div>

                                        <!-- Email id -->
                                        <div class="col-md-6">
                                            <label class="form-label" for="emailInput">Email</label>
                                            <input class="form-control" type="text" id="emailInput" name="emailInput" value="${jobApplication.email}" required="required">
                                        </div>

                                        <!-- Desired Salary -->
                                        <div class="col-md-6">
                                            <label class="form-label" for="desiredSalaryInput">Desired Salary</label>
                                            <input type="number" min="10000" max="1000000" class="form-control" id="desiredSalaryInput" name="desiredSalaryInput" value="${jobApplication.desiredSalary}">
                                        </div>

                                        <!-- Earliest Start Date -->
                                        <div class="col-md-6">
                                            <label class="form-label" for="startDateInput">Earliest Start Date</label>
                                            <input type="datetime-local" class="form-control" id="startDateInput" name="startDateInput" value="<fmt:formatDate value="${jobApplication.earliestStartDate}" pattern="MM-dd-yyyy"/>" required="required" >
                                        </div>

                                        <!-- Button -->
                                        <div class="align-items-center ">
                                            <div class="d-grid">
                                                <button class="btn btn-orange mb-0" type="submit">Submit Application</button>
                                            </div>
                                        </div>
                                </c:otherwise>
                                </c:choose>
                            </form>
                            <!-- Form END -->

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</main>
<%@include file="/WEB-INF/learnx/bottom.jsp"%>