<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
<div id="footer">
    <div class="container">
        <form action="locale-change" method="post">
            <input type="submit" name="RU" value="RU"/>
            <input type="submit" name="EN" value="EN"/>
        </form>
    </div>
</div>
