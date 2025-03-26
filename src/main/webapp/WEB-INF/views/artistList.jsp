<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
	<body>
		<c:forEach items="${artists}" var="artist">
			<a href="/artist/${artist.id}">got to ${artist.id} </a>
		</c:forEach>
	</body>
</html>