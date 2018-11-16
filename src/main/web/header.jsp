<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
<header>
    <div class="container">
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/registration.jsp"> <i18n:locale
                            message="registration"/> </a></li>
                    <li><a href="${pageContext.request.contextPath}/login.jsp"> <i18n:locale message="sign_in"/> </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</header>
