<%@ include file="/WEB-INF/shared/top.jsp"%>
    <title>Email</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${appURL}/css/loading.css">
</head>
<body>
<%--<c:if test="${not empty success}">
    <p>Email sent</p>
</c:if>--%>

<c:choose>
    <c:when test="${not empty success and success eq true}">
        <p>Email Sent</p>
    </c:when>
    <c:when test="${not empty success and success eq false}">
        <p>Email was not sent</p>
    </c:when>
    <c:otherwise>
        <p>Use the form below to send an email</p>
    </c:otherwise>
</c:choose>
<form action="${appURL}/email" method="post">
    <!-- Email Address -->
    <label for="email1">Email Address:</label>
    <input type="text" id="email1" name="email1" required>
    <br>

    <!-- Subject -->
    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" required>
    <br>

    <!-- Message -->
    <label for="message">Message:</label>
    <textarea id="message" name="message" rows="4" required></textarea>
    <br>

    <!-- Submit Button -->
    <input type="submit" value="Submit">
</form>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.js"></script>
<script src="${appURL}/js/loading.js"></script>
<%@include file="/WEB-INF/shared/bottom.jsp"%>

