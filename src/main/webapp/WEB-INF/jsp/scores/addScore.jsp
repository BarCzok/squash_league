<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>

        body {
            font-family: Tahoma, sans-serif;
        }

        input[type=text] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: none;
            background-color: #D6EEEE;
            color: #000000;
            width: 40%;
        }

        button {
            background-color: white;
            color: #484545;
            border: 2px solid #484545;
            border-radius: 5px;
            margin: 4px 2px;
            cursor: pointer;
            transition-duration: 0.4s;
            display: inline-block;
        }

        button:hover {
            background-color: #484545;
            color: white;
        }


    </style>

</head>
<body>
<center>
    <h1>Add Game</h1><br/>

<form:form action="/scores/addScore" method="post" modelAttribute="score">
    <form:label path="points1">player${score.player1Id} sets:</form:label><br/>
    <form:input path="points1"/><br/>
    <form:label path="points2">player${score.player2Id} sets:</form:label><br/>
    <form:input path="points2"/><br/>
    <c:if test="${not empty errorMsg}">
        <b style="color:#FF0000">${errorMsg}</b>
    </c:if><br/>
    <form:button>Add score</form:button>
    <form:input type="hidden" path="player1Id"/><br/>
    <form:input type="hidden" path="player2Id"/><br/>
    <form:input type="hidden" path="gameId"/><br/>
</form:form>

</center>


</body>
</html>