<%@ taglib prefix="form" url="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" url="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create an account</title>
</head>
<body>
<form:form method="POST" modelAttribute="userForm">
    <h2>Create your account</h2>
    <spring:bind path="username">
        <div class="${status.error ? 'hass-error' :''}">
            <form:input type="text" path="username" >
            </form:input>
            <form:error path="username"></form:error>
        </div>
    </spring:bind>
    <spring:bind path="password">
        <div class="${status.error ? 'hass-error' :''}">
            <form:input type="password" path="password" >
            </form:input>
            <form:error path="password"></form:error>
        </div>
    </spring:bind>
    <spring:bind path="passwordConfirm">
        <div class="${status.error ? 'hass-error' :''}">
            <form:input type="password" path="passwordConfirm" >
            </form:input>
            <form:error path="passwordConfirm"></form:error>
        </div>
    </spring:bind>
    <button type="submit">Submit</button>
</form:form>