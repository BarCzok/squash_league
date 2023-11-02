<%@ attribute name="games" type="java.util.Map<com.praktyki.squash.facades.dto.GroupDTO, java.util.List<com.praktyki.squash.facades.dto.GameDTO>>" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<c:forEach var="entry" items="${games.entrySet()}">
        <c:set var="group" value="${entry.key}"/>
            <center><h1>Games/${roundName}/${group.name}</h1></center>
            <table>
                <colgroup>
                    <col span="2" style="background-color: #D6EEEE">
                </colgroup>
                <thead>
                <td>Player1</td>
                <td>Player2</td>
                <td>Score</td>
                <td>SetPoints</td>
                <td>WinPoints</td>
                <td>PlayPoints</td>
                <td>TotalPoints</td>
                </thead>


                <c:forEach var="game" items="${entry.value}">
                <c:set var="score1" value="${game.scores[0]}"/>
                <c:set var="score2" value="${game.scores[1]}"/>

                <tr>
                    <td><a href="/players/${game.player1.id}">${game.player1.name}</a></td>
                    <td><a href="/players/${game.player2.id}">${game.player2.name}</a></td>
                    <td>
                        <c:if test="${game.scores.size() ne 0}">
                            ${score1.sets}:${score2.sets}
                        </c:if>
                        <c:if test="${game.scores.size() eq 0}">
                            <a href="/scores/score/${game.id}">Podaj</a>
                        </c:if>
                    </td>
                    <td>${score1.pointsForSets}:${score2.pointsForSets}</td>
                    <td>${score1.pointsForWinning}:${score2.pointsForWinning}</td>
                    <td>${score1.pointsForPlaying}:${score2.pointsForPlaying}</td>
                    <td>${score1.totalPoints}:${score2.totalPoints}</td>
                </tr>


            </c:forEach>
            </table>
        <br><br>
    </c:forEach>