<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 70%;

        }

        body{
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
        tr:hover {background-color: #ddd;}

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
            <col span="2" style="background-color: D6EEEE">
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
        <c:forEach var="game" items="${games}">
            <c:set var="score1" value="${game.score[0]}"/>
            <c:set var="score2" value="${game.score[1]}"/>
            <tr>
                <td><a href="/players/${score1.player.id}">${score1.player.name}</a></td>
                <td><a href="/players/${score2.player.id}">${score2.player.name}</a></td>
                <td>${score1.sets}:${score2.sets}</td>
                <td>${score1.pointsForSets}:${score2.pointsForSets}</td>
                <td>${score1.pointsForWinning}:${score2.pointsForWinning}</td>
                <td>${score1.pointsForPlaying}:${score2.pointsForPlaying}</td>
                <td>${score1.totalPoints}:${score2.totalPoints}</td>

            </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>