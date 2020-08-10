<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" url="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form action="${contextPath}/login" method="POST">
    <h2>Login</h2>
    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input type="text" name="username" autofocus="true">
        <input type="password" name="password">
        <span>${error}</span>
        <input type="hidden" name="${_csrf.paramrterName}" value="${_csrf.token}"/>
        <button type="submit">Log In</button>
        <h4><a href="${contextPath}/registration">Create an account</a></h4>
    </div>
</form>
</body>
