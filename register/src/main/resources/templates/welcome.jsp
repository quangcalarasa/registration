<%@ taglib prefix="form" url="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create an account</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form action="${contextPath}/logout" method="POST" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutFrom'].submit()">Logout</a></h2>
</c:if>
</body>