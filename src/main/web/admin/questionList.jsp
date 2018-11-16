<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="question_list"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <c:set var="test" value="${testID}"/>
    <table class="table" style="width:500px">
        <thead>
        <tr>
            <th><i18n:locale message="question_id"/></th>
            <th><i18n:locale message="question_name"/></th>
            <th><i18n:locale message="change_question"/></th>
            <th><i18n:locale message="delete_question"/></th>
            <th><i18n:locale message="add_answer"/></th>
            <th><i18n:locale message="answers_list"/></th>
        </tr>
        </thead>
        <c:forEach var="question" items="${questions}">
            <tbody>
            <tr>
                <th>${question.questionID}</th>
                <th>${question.question}</th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/question/update" method="get">
                        <input type="hidden" name="questionID" value="${question.questionID}">
                        <button type="submit" class="btn-link"><i18n:locale message="change"/></button>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/question/delete" method="post">
                        <input type="hidden" name="questionID" value="${question.questionID}">
                        <input type="hidden" name="testID" value="${test}">
                        <button type="submit" class="btn-link"><i18n:locale message="delete"/></button>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/tests/answer/create" method="get">
                        <input type="hidden" name="questionID" value="${question.questionID}">
                        <input type="hidden" name="testID" value="${test}">
                        <button type="submit" class="btn-link"><i18n:locale message="add_answer"/></button>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/answer/list" method="post">
                        <input type="hidden" name="questionID" value="${question.questionID}">
                        <input type="hidden" name="testID" value="${test}">
                        <button type="submit" class="btn-link"><i18n:locale message="answers_list"/></button>
                    </form>
                </th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <a class="button" href="${pageContext.request.contextPath}/admin/tests">
        <i18n:locale message="back"/>
    </a>
</center>

</body>
</html>
