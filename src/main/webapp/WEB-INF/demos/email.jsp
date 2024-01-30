<%@include file="/WEB-INF/shared/top.jsp"%>
    <title>Email</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/loading.css">
</head>
<body>
<c:if test="${success}">
    <p>Email sent</p>
</c:if>
<%--<form action="${appUrl}/email" method="post">
    <input type="text" name="email">
    <input type="text" name="message">
</form>--%>
<form action="email" method="post">
    <!-- Email Address -->
    <label for="email1">Email Address:</label>
    <input type="email" id="email1" name="email1" required>
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
<script src="$js/loading.js"></script>
<%@include file="/WEB-INF/shared/bottom.jsp"%>

