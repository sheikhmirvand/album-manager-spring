<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <title>album</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <h1>${album.name}</h1>
        <button class="addToCartButton">add to cart</button>
        <input type="number" name="quantity" id="" class="quantity"/>
    </div>

    <script>
        const addToCartButton = document.querySelector(".addToCartButton");
        const albumQuantity = document.querySelector(".quantity");

        addToCartButton.addEventListener("click",e=>{
            e.preventDefault();
            const path = window.location.pathname.split("/").at(-1);
            console.log(albumQuantity.value);

            fetch("/order/create-order/"+path+"?quantity="+albumQuantity.value,{
                method : "POST",
            }).then(response=>{
                if(response.redirected) {
                    window.location.href = response.url
                }
            })
        })
    </script>
</body>
</html>