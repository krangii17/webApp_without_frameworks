<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><i18n:locale message="answer_create"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>

    <form style="width: 500px" method="post" action="${pageContext.request.contextPath}/admin/tests/answer/create"
          accept-charset="UTF-8">
        <br>
        <i18n:locale message="question_id"/>: <input type="text" name="question" value="${param.questionID}"
                                                     readonly><br>
        <h4><i18n:locale message="answer"/>:</h4>
        <textarea class="form-control" rows="5" name="answer" required></textarea>
        <hr>
        <div class="form-check">
            <input type="hidden" name="IDOfQuestion" value="${param.questionID}">
            <input type="hidden" name="IDOfTest" value="${testID}">
            <br>
            <i18n:locale message="right_answer"/> <input type="checkbox" name="isRight" value="true">
            <br>
        </div>
        <input type="submit" value="<i18n:locale message="submit"/>">
    </form>
    <a class="button" href="${pageContext.request.contextPath}/admin/questions?testID=${testID}">
        <i18n:locale message="back"/>
    </a>
</center>

</body>
</html>
