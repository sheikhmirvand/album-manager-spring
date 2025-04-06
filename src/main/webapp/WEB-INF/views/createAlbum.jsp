<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <title>create album</title>
</head>
<body>
<div class="absolute h-[300px] right-0 top-0">
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="error">
            <c:set var="message" value="${error.defaultMessage}" scope="request" />
            <jsp:include page="errorToast.jsp" />
        </c:forEach>
    </c:if>
</div>
    <jsp:include page="navbar.jsp"/>
    <h1>create album</h1>
    <form:form action="/admin/create-album" modelAttribute="inputAlbum" method="post" enctype="multipart/form-data">
        <label>name</label>
        <form:input path="name" htmlAttributes="{placeholder='Enter name'}"></form:input>
        <label>price</label>
        <form:input path="price" htmlAttributes="{placeholder='Enter price'}"></form:input>
        <label>artist nikname</label>
        <form:input path="nikName" htmlAttributes="{placeholder='Enter name'}"></form:input>
        <label>file</label>
        <input type="file" name="file" id="">
        <input type="submit" value="submit">
    </form:form>
</body>
</html>