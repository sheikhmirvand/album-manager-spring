<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />--%>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <title>create artist</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <form:form action="/admin/create-artist" modelAttribute="artist" method="post" class="flex">
        <label>first name</label>
        <form:input path="firstName" htmlAttributes="{placeholder='Enter first name'}"></form:input>
        <label>last name</label>
        <form:input path="lastName" htmlAttributes="{placeholder='Enter last name'}"></form:input>
        <label>nik name</label>
        <form:input path="nikName" htmlAttributes="{placeholder='Enter nik name'}"></form:input>
        <input type="submit" value="submit">
    </form:form>
</body>
</html>