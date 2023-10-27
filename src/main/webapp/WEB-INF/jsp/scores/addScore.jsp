<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

</head>
<body>
<c:if test="${not empty errorMsg}">
    <b style="color:#FF0000">${errorMsg}</b>
</c:if>

<form:form action="/scores/addScore" method="post" modelAttribute="score">
    <form:label path="points1">player${score.player1Id} sets:</form:label>
    <form:input path="points1"/><br/>
    <form:label path="points2">player${score.player2Id} sets:</form:label>
    <form:input path="points2"/><br/>
    <form:button>Add score</form:button>
    <form:input type="hidden" path="player1Id"/><br/>
    <form:input type="hidden" path="player2Id"/><br/>
    <form:input type="hidden" path="gameId"/><br/>
</form:form>


</body>
</html>