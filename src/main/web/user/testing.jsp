<%@ taglib uri="/WEB-INF/tag/locale.tld" prefix="i18n" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <title><i18n:locale message="testing"/></title>
</head>
<body>
<center>
    <h2><i18n:locale message="timer"/>: <span id="time"></span></h2>
    <form style="width: 500px" action="${pageContext.request.contextPath}/home/testing/result" method="post">
        <c:forEach var="question" items="${questions}">
            <div class="panel panel-default">
                <div class="panel-heading"><i18n:locale message="question"/> : ${question.question}</div>
                <c:forEach var="answer" items="${question.answerList}">
                    <div class="panel-body">
                        <div style="text-align: center" class="checkbox">
                            <label>
                                <input type="checkbox" name="${answer.answerID}" value="true">
                                    ${answer.answer}
                            </label>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
        <input type="submit" value="<i18n:locale message="submit"/>">
    </form>
</center>
</body>
<script>
    function setTime(mins) {
        var seconds = 60;

        function tick() {
            var counter = document.getElementById("time");
            var current_minutes = mins - 1;
            seconds--;
            counter.innerHTML = current_minutes.toString() + ":" + (seconds < 10 ? "0" : "") + String(seconds);
            if (seconds > 0) {
                setTimeout(tick, 1000);
            } else {
                if (mins > 1) {
                    setTime(mins - 1);
                } else {
                    document.forms[0].submit();
                }
            }
        }

        tick();
    }

    var minutes = ${test.testTime};
    setTime(minutes);
</script>
</html>
