<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><i18n:locale message="question_update"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
</head>
<body>
<center>
    <form style="width: 500px" method="post" action="${pageContext.request.contextPath}/admin/question/update"
          accept-charset="UTF-8">
        <br>
        <i18n:locale message="question_id"/>: <input type="text" name="testID" value="${questionID}" readonly><br>
        <h4><i18n:locale message="question"/>:</h4>
        <textarea class="form-control" rows="5" name="question" required></textarea>
        <hr>
        <input type="hidden" name="questionID" value="${questionID}">
        <input type="submit" value="<i18n:locale message="submit"/>">
    </form>
</center>
</body>
</html>
