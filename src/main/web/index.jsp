<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="quiz"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container" style="width:60%; height:60%">
    <center>
        <img src="image/quiz.png" style="width:80%; height:90%">
    </center>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
