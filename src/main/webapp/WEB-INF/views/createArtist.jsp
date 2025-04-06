<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <title>create artist</title>
</head>
<body>
    <div class="absolute right-0 top-0">
        <c:if test="${not empty errors}">
            <c:forEach items="${errors}" var="error">
                <c:set var="message" value="${error.defaultMessage}" scope="request"></c:set>
                <jsp:include page="errorToast.jsp"></jsp:include>
            </c:forEach>
        </c:if>
    </div>
    <jsp:include page="navbar.jsp"/>
    <form:form action="/admin/create-artist" modelAttribute="createArtistInput" method="post" class="flex">
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