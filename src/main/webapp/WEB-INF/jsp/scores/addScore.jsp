<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        body{
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
            font-weight: normal;
        }
        #formularz{
            display: flex;
            justify-content: center;
            width: 450px;
            background-color: #c0c0c0;
        }
    </style>
</head>
<body>

<form:form action="/scores/addScore" method="post" modelAttribute="score">
    <form:label path="points1">${score.player1Name} sets:</form:label>
    <form:input path="points1"/><br/>

    <form:button>Add score</form:button>
</form:form>


</body>
</html>
