<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="admin_home"/></title>
    <jsp:include page="/authorizedHeader.jsp"/>
</head>
<body>
<center>
    <jsp:include page="menu.jsp"/>
    <table class="table" style="width:500px; margin: 10px; text-align: center">
        <thead>
        <tr>
            <th><i18n:locale message="user_id"/></th>
            <th><i18n:locale message="user_login"/></th>
            <th><i18n:locale message="email"/></th>
            <th><i18n:locale message="user_name"/></th>
            <th><i18n:locale message="ban"/></th>
            <th><i18n:locale message="change_ban_status"/></th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tbody>
            <tr>
                <th>${user.userID}</th>
                <th>${user.login}</th>
                <th>${user.email}</th>
                <th>${user.userName}</th>
                <th>${user.ban}</th>
                <th>
                    <form action="${pageContext.request.contextPath}/admin/ban" method="post">
                        <input type="hidden" name="userID" value="${user.userID}"/>
                        <button type="submit" class="btn btn-success"><i18n:locale message="change"/></button>
                    </form>
                </th>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</center>
</body>
</html>
