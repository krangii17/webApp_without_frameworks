<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="registration"/></title>
</head>
<body>
<center>
    <form style="width: 250px" role="form" method="post" action="registration" accept-charset="UTF-8">
        <p class="help-block"><i18n:locale message="${error_name}"/></p>
        <div class="form-group">
            <label for="user_name"><i18n:locale message="user_name"/></label>
            <input type="text" name="user_name" class="form-control" id="user_name" placeholder=<i18n:locale
                    message="user_name"/>>
        </div>
        <p class="help-block"><i18n:locale message="${error_email}"/></p>
        <div class="form-group">
            <label for="email"><i18n:locale message="email"/></label>
            <input type="email" name="email" class="form-control" id="email" placeholder=<i18n:locale message="email"/>>
        </div>
        <p class="help-block"><i18n:locale message="${error_password}"/></p>
        <div class="form-group">
            <label for="pass"><i18n:locale message="password"/></label>
            <input type="password" name="pass" class="form-control" id="pass" placeholder=<i18n:locale
                    message="password"/>>
        </div>
        <p class="help-block"><i18n:locale message="${error_login}"/></p>
        <div class="form-group">
            <label for="user_login"><i18n:locale message="login_name"/></label>
            <input type="text" name="user_login" class="form-control" id="user_login" placeholder=<i18n:locale
                    message="login_name"/>>
        </div>
        <p class="help-block"><i18n:locale message="${error_age}"/></p>
        <div class="form-group">
            <label for="age"><i18n:locale message="age"/></label>
            <input type="text" name="age" class="form-control" id="age" placeholder=<i18n:locale message="age"/>>
        </div>
        <button type="submit" class="btn btn-success"><i18n:locale message="enter"/></button>
    </form>
</center>
</body>
</html>
