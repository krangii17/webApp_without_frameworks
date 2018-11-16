<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><i18n:locale message="create_test"/></title>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <jsp:include page="menu.jsp"/>
    <form style="width: 500px" role="form" method="post" action="${pageContext.request.contextPath}/admin/tests/create"
          accept-charset="UTF-8">
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
