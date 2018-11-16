<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="i18" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
<html>
<head>
    <title><i18n:locale message="test_list"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <table class="table" style="width:500px">
        <thead>
        <tr>
            <th><i18n:locale message="test_id"/></th>
            <th><i18n:locale message="test_name"/></th>
            <th><i18n:locale message="level"/></th>
            <th><i18n:locale message="topic"/></th>
            <th><i18n:locale message="time"/></th>
            <th><i18n:locale message="change_test"/></th>
            <th><i18n:locale message="delete_test"/></th>
            <th><i18n:locale message="add_question"/></th>
            <th><i18n:locale message="question_list"/></th>
        </tr>
        </thead>
        <c:forEach var="testsResult" items="${tests}">
            <tbody>
            <tr>
                <th>${testsResult.testID}</th>
                <th>${testsResult.testName}</th>
                <th>${testsResult.level}</th>
                <th>${testsResult.topic}</th>
                <th>${testsResult.testTime}</th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/tests/update" method="get">
                        <input type="hidden" name="testID" value="${testsResult.testID}">
                        <button type="submit" class="btn-link"><i18n:locale message="change"/></button>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/tests/delete" method="post">
                        <input type="hidden" name="testID" value="${testsResult.testID}">
                        <button type="submit" class="btn-link"><i18n:locale message="delete"/></button>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/tests/question/create" method="get">
                        <input type="hidden" name="testID" value="${testsResult.testID}">
                        <button type="submit" class="btn-link"><i18n:locale message="add_question"/></button>
                    </form>
                </th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/questions" method="get">
                        <input type="hidden" name="testID" value="${testsResult.testID}">
                        <button type="submit" class="btn-link"><i18n:locale message="question_list"/></button>
                    </form>
                </th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</center>
</body>
</html>
