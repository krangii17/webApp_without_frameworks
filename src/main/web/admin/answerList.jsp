<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="answers_list"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <table class="table" style="width:500px">
        <thead>
        <tr>
            <th><i18n:locale message="answer_id"/></th>
            <th><i18n:locale message="answer"/></th>
            <th><i18n:locale message="answer_correct"/></th>
        </tr>
        </thead>
        <c:forEach var="answer" items="${answerList}">
            <tbody>
            <tr>
                <th>${answer.answerID}</th>
                <th>${answer.answer}</th>
                <th>${answer.correct}</th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <a class="button" href="${pageContext.request.contextPath}/admin/questions?testID=${testID}">
        <i18n:locale message="back"/>
    </a>
</center>
</body>
</html>
