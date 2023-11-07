<%--@elvariable id="games" type="java.util.List<com.praktyki.squash.facades.dto.GameDTO>"--%>
<%--@elvariable id="rounds" type="java.util.List<com.praktyki.squash.facades.dto.RoundDTO>"--%>
<%--@elvariable id="games" type="java.util.List<com.praktyki.squash.facades.dto.ScoreDTO>"--%>
<%--@elvariable id="rounds" type="java.util.List<com.praktyki.squash.facades.dto.PlayerDTO>"--%>
<%--@elvariable id="rounds" type="java.util.List<com.praktyki.squash.facades.dto.GroupDTO>"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <title>Tabela Games</title>
    <style>
        a {
            text-decoration: none;
            color: black;
        }
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 70%;

        }

        body{
            /*font-family: Tahoma, sans-serif;*/
            display: flex;
            justify-content: center;
        }

        td, th {
            border: 4px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        td:nth-child(even) {
            background-color: #D6EEEE;
        }


        .div{
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

    </style>
</head>

<body>
<div class =  "div">
   <center><h1>Games</h1></center>

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
        <td>Round</td>
        </thead>
        <c:forEach var="game" items="${games}">

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
                    <td><a href="/rounds/${game.round.id}/view">${game.round.name}</a></td>

                </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>