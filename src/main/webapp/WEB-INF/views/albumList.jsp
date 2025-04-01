<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <title>Document</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
   <div class="m-auto bg-red-200 container">
       <h1 class="m-5 text-3xl text-center font-sans font-bold text-upper">artist list</h1>
       <div class="flex gap-12 ">
       <c:forEach items="${albums}" var="album">
           <a href="/album/${album.id}" class="w-64 h-80 border flex justify-center items-center hover:rounded-tl-3xl hover:rounded-br-3xl bg-white hover:rounded-bl-none hover:rounded-tr-none duration-250 overflow-hidden font-sans flex-col rounded-xl">
               <img src="${pageContext.request.contextPath}/upload/cover/${album.cover}" alt="" class="w-full h-full object-cover">
                <h2>${album.name}</h2>
                <h3>${album.artist.nikName}</h3>
                <div class="flex justify-between items-center w-full">
                    <c:if test="${album.price != 0.0}">
                        <strong class="mx-3">price : ${album.price}</strong>
                    </c:if>
                    <c:if test="${album.price == 0.0}">
                        <strong class="mx-3">free !</strong>
                    </c:if>
                    <button class="p-3 bg-blue-400 rounded-sm m-3 cursor-pointer">go to album</button>
                </div>
           </a>
       </c:forEach>
       </div>
   </div>
</body>
</html>