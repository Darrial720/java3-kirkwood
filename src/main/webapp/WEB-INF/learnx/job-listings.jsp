<%@include file="/WEB-INF/learnx/top.jsp"%>
<main>
    <div class="container">
        <c:forEach items="${jobListings}" var="jobListing">
        <div class="row border border-dark my-4 p-2">
            <div class="col-md-6 text-start d-flex flex-column">
                <div class="mt-2">
                    <strong>${jobListing.department_name}</strong>
                    <span class="badge bg-success">Badge</span>
                    <span class="badge bg-warning text-dark">Badge</span>
                </div>
                <h4 class="my-2">${jobListing.position}</h4>
                <div class="mb-2">
                    <span class="me-2"><fmt:formatDate value="${jobListing.posted_at_toDate}" type="date" dateStyle="long" /></span>
                    <span class="me-2">${jobListing.contract}</span>
                    <span>${jobListing.location}</span>
                </div>
            </div>
            <div class="col-md-6 text-md-end d-flex justify-content-md-end align-items-md-center">
                <div class="mb-2">
                    <span class="badge bg-primary rounded-pill">Tag</span>
                    <span class="ms-2 badge bg-secondary rounded-pill">Tag</span>
                    <span class="ms-2 badge bg-dark rounded-pill">Tag</span>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</main>
<%@include file="/WEB-INF/learnx/bottom.jsp"%>
