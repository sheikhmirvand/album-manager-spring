<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container mx-auto">
        <c:forEach var="album" items="${order.albums}">
            <div class="flex justify-between h-34 bg-green-300 items-center my-4">
                <img src="${pageContext.request.contextPath}/upload/cover/${album.album.cover}" class=" h-full"/>
                <div>
                    <p>${album.album.name}</p>
                    <p>${album.album.price}</p>
                    <p>${album.quantity}</p>
                </div>
            </div>
        </c:forEach>

        <button class="payButton">pay</button>
    </div>

    <script>
        const payButton = document.querySelector(".payButton");

        payButton.addEventListener("click",(e)=> {
            e.preventDefault();
            fetch("/order/pay-order",{
                method : "POST"
            }).then(response=>{
                console.log("its run")
                window.location.href = response.url
            })
        })
    </script>
</body>
</html>