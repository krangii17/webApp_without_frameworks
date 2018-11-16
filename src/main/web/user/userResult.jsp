<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="your_result"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <h1><i18n:locale message="your_result"/> : ${percentage}%</h1>
</center>
</body>
</html>
