<%--@elvariable id="rounds" type="java.util.List<com.praktyki.squash.facades.dto.RoundDTO>"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allRounds</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<center>
<div>
    <h1>Rounds</h1><br><br>
    <table class="currentRound">
        <colgroup>
            <col span="1" style="background-color: white">
        </colgroup>

            <th>RoundName</th>
            <th>StartDate</th>
            <th>EndDate</th>


        <c:forEach var="round" items="${rounds}">
            <tr>
                <td><a href="${round.id}/view">${round.name}</a></td>
                <td>${round.startDate}</td>
                <td>${round.endDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</center>





</body>
</html>
