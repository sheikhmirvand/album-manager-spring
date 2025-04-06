<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>


    <title>register</title>
</head>
<body class="relative">
<div class="absolute top-0 right-0 h-[300px]">
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="error">
            <c:set var="message" value="${error.defaultMessage}" scope="request"/>
            <jsp:include page="errorToast.jsp"/>
        </c:forEach>
    </c:if>
</div>


<div class="flex justify-center items-center h-screen p-10 ">
    <div class="grid md:grid-cols-2 grid-cols-1  border rounded-3xl">

        <div class="">
            <img src="${pageContext.request.contextPath}/assets/authbanner.jpg" class="rounded-3xl rotate-180" alt="">
        </div>

        <div class="flex justify-center items-center p-5 flex-col">
            <form:form method="post" modelAttribute="registerInput"
                       action="${pageContext.request.contextPath}/register">
                <h1 class="text-center mb-10 font-bold text-4xl">register</h1>

                <form:input path="username" class="bg-gray-100 border outline-none rounded-md py-3 w-full px-4 mb-1"
                            placeholder="enter your username"/>


                <form:password path="password" class="bg-gray-100 border outline-none rounded-md py-3 w-full px-4 mb-1"
                               placeholder="enter your password"/>

                <input type="submit" value="submit"
                       class="bg-yellow-400 hover:bg-yellow-500 border outline-none rounded-md py-3 w-full px-4 font-semibold text-white">
            </form:form>

            <div class="m-8">
                <span>do you have an account ? </span>
                <a href="${pageContext.request.contextPath}/login" class="text-blue-500">login</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>