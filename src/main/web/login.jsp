<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l18n" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="login_name"/></title>
</head>
<body>
<center>
    <form style="width: 250px" role="form" method="post" action="login" accept-charset="UTF-8">
        <p class="help-block"><i18n:locale message="${error}"/></p>
        <div class="form-group">
            <label for="email"><i18n:locale message="email"/></label>
            <input type="email" name="email" class="form-control" id="email" placeholder=<i18n:locale message="email"/>>
        </div>
        <div class="form-group">
            <label for="pass"><i18n:locale message="password"/></label>
            <input type="password" name="pass" class="form-control" id="pass" placeholder=<i18n:locale
                    message="password"/>>
        </div>
        <button type="submit" class="btn btn-success"><i18n:locale message="enter"/></button>
        <button type="button" class="btn btn-link"><a
                href="${pageContext.request.contextPath}/registration.jsp"><i18n:locale message="not_registered"/></a>
        </button>
    </form>
</center>
</body>
</html>
