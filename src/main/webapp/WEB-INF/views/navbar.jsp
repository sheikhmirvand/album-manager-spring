<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
    request.setAttribute("role", role);
%>

<nav>
    <div class="flex h-12 justify-between px-6 bg-blue-300 items-center font-mono">
        <div class="right_nav">
            <a href="/">
                <h1>LOGO</h1>
            </a>
        </div>
        <div class="left_nav">
            <ul class="flex gap-4 text-xl font-medium">
                <c:if test="${role.contains('ROLE_ADMIN')}">
                    <li class="hover:text-red-200 duration-250"><a href="/admin/create-artist">create artist</a></li>
                    <li class="hover:text-red-200 duration-250"><a href="/admin/create-album">create album</a></li>
                    <li class="hover:text-red-200 duration-250"><a href="/artists">artists</a></li>
                    <li class="hover:text-red-200 duration-250"><a href="/album">album</a></li>
                </c:if>
                <c:if test="${role.contains('ROLE_USER')}">
                    <li><a href="/artists">artists</a></li>
                    <li><a href="/album"></a></li>
                    <li><a href=""></a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>