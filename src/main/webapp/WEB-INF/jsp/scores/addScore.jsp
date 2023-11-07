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
            background-color:  #f2f2f2;
            color: #000000;
            width: 40%;
        }

        button{
            display: inline-block;
            outline: 0;
            border: 0;
            cursor: pointer;
            border-radius: 8px;
            padding: 8px 18px 10px;
            font-size: 18px;
            font-weight: 700;
            line-height: 1;
            transition: transform 200ms,background 200ms;
            background: transparent;
            color: #484343;
            box-shadow: 0 0 0 3px #484343 inset;
        }

        button:hover{
            transform: translateY(-2px);
        }


    </style>

</head>
<body>
<center>
    <h1>Add Game</h1><br/>

<form:form action="/scores/addScore" method="post" modelAttribute="score">
    <form:label path="points1">Player${score.player1Id} sets:</form:label><br/>
    <form:input path="points1"/><br/>
    <form:label path="points2">Player${score.player2Id} sets:</form:label><br/>
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