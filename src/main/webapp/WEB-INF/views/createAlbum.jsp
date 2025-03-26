<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>create album</title>
</head>
<body>
    <h1>create album</h1>
    <form:form action="/admin/create-album" modelAttribute="inputAlbum" method="post">
        <label>name</label>
        <form:input path="name" htmlAttributes="{placeholder='Enter name'}"></form:input>
        <label>price</label>
        <form:input path="price" htmlAttributes="{placeholder='Enter price'}"></form:input>
        <label>artist nikname</label>
        <form:input path="nikName" htmlAttributes="{placeholder='Enter name'}"></form:input>
        <input type="submit" value="submit">
    </form:form>
</body>
</html>