<%--@elvariable id="players" type="java.util.Map<com.praktyki.squash.facades.dto.GroupDTO, java.util.List<com.praktyki.squash.facades.dto.PlayerDTO>>"--%>
<%--@elvariable id="games" type="java.util.Map<com.praktyki.squash.facades.dto.GroupDTO, java.util.List<com.praktyki.squash.facades.dto.GameDTO>>"--%>
<%--@elvariable id="rounds" type="java.util.List<com.praktyki.squash.facades.dto.RoundDTO>"--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Games Table</title>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
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
            font-family: Tahoma, sans-serif;
            display: flex;
            justify-content: center;
            height: 1500px;
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
            margin-top: 10px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

    </style>
</head>

<body>
<div class =  "div">
    <center><h1>Games/${roundName}</h1></center>
    <br>
    <tags:games games="${games}"/>

    <tags:playerRanking/>

</div>


</body>
</html>