<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><i18n:locale message="question_create"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <form style="width: 500px" method="post" action="${pageContext.request.contextPath}/admin/tests/question/create"
          accept-charset="UTF-8">
        <br>
        <i18n:locale message="test_id"/>: <input type="text" name="testID" value="${param.testID}" readonly><br>
        <h4><i18n:locale message="question"/>:</h4>
        <textarea class="form-control" rows="5" name="question" required></textarea>
        <hr>
        <input type="submit" value="<i18n:locale message="submit"/>">
    </form>
</center>
</body>
</html>