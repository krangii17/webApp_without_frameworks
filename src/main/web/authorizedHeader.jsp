<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
<header>
    <div class="container">
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/logout"> <i18n:locale
                            message="logout"/> </a></li>
                    <li><a href="${pageContext.request.contextPath}/profile"> <i18n:locale
                            message="profile"/> </a></li>
                    <li><a href="${pageContext.request.contextPath}/user/userHome.jsp"> <i18n:locale
                            message="home_page"/> </a></li>
                </ul>
            </div>
        </div>
    </div>

</header>
