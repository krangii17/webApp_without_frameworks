<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><i18n:locale message="test_result"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
</head>
<body>
<center>
    <table class="table" style="width:500px">
        <thead>
        <tr>
            <th><i18n:locale message="result_id"/></th>
            <th><i18n:locale message="user_id"/></th>
            <th><i18n:locale message="test_id"/></th>
            <th><i18n:locale message="passed"/></th>
            <th><i18n:locale message="time"/></th>
        </tr>
        </thead>
        <c:forEach var="result" items="${results}">
            <tbody>
            <tr>
                <th>${result.resultID}</th>
                <th>${result.userID}</th>
                <th>${result.testID}</th>
                <th>${result.passed}</th>
                <th>${result.points}</th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</center>

</body>
</html>
