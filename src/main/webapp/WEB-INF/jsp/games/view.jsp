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
        <td>SetPoints</td>
        <td>WinPoints</td>
        <td>PlayPoints</td>
        <td>TotalPoints</td>
    </thead>
    <c:forEach var="game" items="${games}">
        <c:set var="score1" value="${game.score[0]}"/>
        <c:set var="score2" value="${game.score[1]}"/>
        <tr>
            <td>${score1.player.name}</td>
            <td>${score2.player.name}</td>
            <td>${score1.sets}:${score2.sets}</td>
            <td>${score1.pointsForSets}:${score2.pointsForSets}</td>
            <td>${score1.pointsForWinning}:${score2.pointsForWinning}</td>
            <td>${score1.pointsForPlaying}:${score2.pointsForPlaying}</td>
            <td>${score1.pointsForSets + score1.pointsForWinning + score1.pointsForPlaying}:
                    ${score2.pointsForSets + score2.pointsForWinning + score2.pointsForPlaying}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>