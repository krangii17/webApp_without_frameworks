<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="list_of_test"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>

<center>
    <div class="form-group" style="width: 250px">
        <form method="get" action="${pageContext.request.contextPath}/user/tests">
            <label for="sel1"><i18n:locale message="select_from_list"/></label>
            <select class="form-control" id="sel1" name="sort">
                <option value="name"><i18n:locale message="sorted_by_name"/></option>
                <option value="topic"><i18n:locale message="sorted_by_topic"/></option>
                <option value="questions"><i18n:locale message="sorted_by_questions"/></option>
                <option value="hard"><i18n:locale message="sorted_by_hard"/></option>
            </select>
            <input type="submit" value="<i18n:locale message="submit"/>">
        </form>
    </div>
    <table class="table" style="width:500px">
        <thead>
        <tr>
            <th><i18n:locale message="start_test"/></th>
            <th><i18n:locale message="test_name"/></th>
            <th><i18n:locale message="level"/></th>
            <th><i18n:locale message="topic"/></th>
            <th><i18n:locale message="time"/></th>
        </tr>
        </thead>
        <c:forEach var="testsResult" items="${tests}">
            <tbody>
            <tr>
                <th>
                    <form action="${pageContext.request.contextPath}/home/tests/testing" method="post">
                        <input type="hidden" name="testID" value="${testsResult.testID}">
                        <button type="submit" class="button"><i18n:locale message="start_test"/></button>
                    </form>
                </th>
                <th>${testsResult.testName}</th>
                <th>${testsResult.level}</th>
                <th>${testsResult.topic}</th>
                <th>${testsResult.testTime}</th>
            </tr>
            </tbody>
        </c:forEach>


    </table>
</center>

</body>
</html>
