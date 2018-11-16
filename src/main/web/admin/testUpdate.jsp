<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><i18n:locale message="test_update"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
</head>
<body>
<center>
    <form style="width: 500px" role="form" method="post" action="${pageContext.request.contextPath}/admin/tests/update"
          accept-charset="UTF-8">
        <input type="hidden" name="testID" value="${testID}">
        <p class="help-block"><i18n:locale message="${error}"/></p>
        <input type="text" name="name" placeholder="<i18n:locale message="test_name"/>" value="" required>
        <br>
        <input type="text" name="level" placeholder="<i18n:locale message="level"/>" value="" required>
        <br>
        <input type="text" name="topic" placeholder="<i18n:locale message="topic"/>" value="" required>
        <br/>
        <input type="text" name="time" placeholder="<i18n:locale message="time"/>" value="" required>
        <br>
        <hr>
        <button type="submit" class="btn-link"><i18n:locale message="submit"/></button>
    </form>
</center>
</body>
</html>
