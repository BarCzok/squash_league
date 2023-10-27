<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

</head>
<body>
<c:set var="score1" value="${game.scores[0]}"/>
<c:set var="score2" value="${game.scores[1]}"/>

<form:form action="/scores/addScore" method="post" modelAttribute="score">
    <form:label path="points1">player${score.player1Id} sets:</form:label>
    <form:input path="points1"/><br/>
    <form:label path="points2">player${score.player2Id} sets:</form:label>
    <form:input path="points2"/><br/>

    <form:button>Add score</form:button>
</form:form>


</body>
</html>
