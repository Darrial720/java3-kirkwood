<%@include file="/WEB-INF/learnx/top.jsp"%>
<main>
    <div class="container">
        <hi>All Applications</hi>
        <div class="row">
            <div class="col-xl-12">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Application ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">email</th>
                            <th scope="col">Desired Salary</th>
                            <th scope="col">Earliest Start Date</th>
                            <th scope="col">Date Submitted</th>
                            <th scope="col">Status</th>
                            <th scope="col">Job ID</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${applications}" var="application">
                            <tr>
                                <td>${application.applicationID}</td>
                                <td>${fn:escapeXml(application.firstName)}&nbsp;${fn:escapeXml(application.lastName)}</td>
                                <td>${application.email}</td>
                                <td><fmt:formatNumber value="${application.desiredSalary}" type="currency" currencyCode="USD" /></td>
                                <td>${application.earliestStartDate}</td>
                                <td>${application.dateSubmitted}</td>
                                <td>${application.status}</td>
                                <td>${application.job_id}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>

</main>

<%@include file="/WEB-INF/learnx/bottom.jsp"%>

