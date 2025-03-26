<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/admin/upload-music" method="post" enctype="multipart/form-data">
    <input type="file" name="music" id="" placeholder="upload your music">
    <input type="text" name="name" placeholder="enter music name">
    <input type="number" name="artistId" placeholder="enter artist id">
    <input type="submit" value="upload music">
</form>
</body>
</html>