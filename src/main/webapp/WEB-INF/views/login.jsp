<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />

    <title>Document</title>
</head>
<body>
    <form action="/login" method="post">
        <input type="text" name="username" placeholder="enter your username">
        <input type="password" name="password" placeholder="enter your password">
        <input type="submit" value="submit">
    </form>
</body>
</html>