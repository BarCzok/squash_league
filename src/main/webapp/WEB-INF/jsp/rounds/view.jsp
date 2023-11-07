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


        div{
            margin-top: 10px;
            display: flex;
            flex-direction: column;
            justify-content: center;
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
            width: 50px;
        }

        button:hover {
            background-color: #484545;
            color: white;
        }

    </style>
</head>

<body>
<div>
    <center><h1>Games/${roundName}</h1></center>
    <br>
    <tags:games games="${games}"/>

    <tags:playerRanking/>


    <button><a href="/rounds/xd/${roundId}">Zakoncz runde</a></button>
</div>


</body>
</html>