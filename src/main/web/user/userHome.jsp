<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="home_page"/></title>
</head>
<body>
<jsp:include page="/authorizedHeader.jsp"/>
<center>
    <jsp:include page="userMenu.jsp"/>
    <div class="form-group" style="width: 250px">
        <form method="get" action="${pageContext.request.contextPath}/home">
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
</center>
<center>
    <table class="table" style="width:500px">
        <thead>
        <tr>
            <th><i18n:locale message="test_name"/></th>
            <th><i18n:locale message="topic"/></th>
            <th><i18n:locale message="level"/></th>
            <th><i18n:locale message="points"/></th>
        </tr>
        </thead>
        <c:forEach var="result" items="${resultList}">
            <tbody>
            <tr>
                <th>${result.test.testName}</th>
                <th> ${result.test.topic}</th>
                <th>${result.test.level}</th>
                <th>${result.points}</th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</center>

</body>
</html>
