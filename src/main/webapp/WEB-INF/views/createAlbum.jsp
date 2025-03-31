<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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