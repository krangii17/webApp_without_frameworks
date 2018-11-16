<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div style="padding: 5px;">
    <a class="button" href="${pageContext.request.contextPath}/admin"><i18n:locale message="home_page"/></a>
    <a class="button" href="${pageContext.request.contextPath}/admin/tests"><i18n:locale message="test_list"/></a>
    <a class="button" href="${pageContext.request.contextPath}/admin/result"><i18n:locale message="test_results"/></a>
    <a class="button" href="${pageContext.request.contextPath}/admin/tests/create"><i18n:locale
            message="create_test"/> </a>
</div>