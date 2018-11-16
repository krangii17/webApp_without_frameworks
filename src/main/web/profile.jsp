<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="profile"/></title>
</head>
<body>
<jsp:include page="/authorizedHeader.jsp"/>
<br>
<center>
    <blockquote style="width: 400px">
        <i18n:locale message="user_login"/>: ${loggedUser.login}
        <br>
        <i18n:locale message="email"/>: ${loggedUser.email}
        <br>
        <i18n:locale message="user_name"/>: ${loggedUser.userName}
        <br/>
        <i18n:locale message="age"/>: ${loggedUser.age}
        <br>
    </blockquote>
</center>
<br>
</body>
</html>
