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



    <div class="flex justify-center items-center h-screen p-10 ">
        <div class="grid md:grid-cols-2 grid-cols-1  border rounded-3xl">
            <div class="flex justify-center items-center p-5 flex-col">
                <form action="/login" method="post" class="">
                    <h1 class="text-center mb-10 font-bold text-4xl">Login</h1>

                    <input type="text" name="username" placeholder="enter your username" class="bg-gray-100 border outline-none rounded-md py-3 w-full px-4 mb-3">
                    <input type="password" name="password" placeholder="enter your password" class="bg-gray-100 border outline-none rounded-md py-3 w-full px-4 mb-3">
                    <input type="submit" value="submit" class="bg-yellow-400 hover:bg-yellow-500 border outline-none rounded-md py-3 w-full px-4 font-semibold text-white">
                </form>
                <div class="m-8">
                    <span>you dont have an account ? </span>
                    <a href="${pageContext.request.contextPath}/register" class="text-blue-500">register</a>
                </div>
            </div>
            <div class="">
                <img src="${pageContext.request.contextPath}/assets/authbanner.jpg" class="rounded-3xl"  alt="">
            </div>
        </div>
    </div>
</body>
</html>