<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<html>
<head></head>

<body>
<h1>Games</h1>

<table>
    <thead>
        <td>Player1</td>
        <td>Player2</td>
        <td>Score</td>
    </thead>
    <c:forEach var="game" items="${games}">
        <tr>
            <td>${game.score[0].player.name}</td>
            <td>${game.score[1].player.name}</td>
            <td>${game.score[0].sets}:${game.score[1].sets}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>