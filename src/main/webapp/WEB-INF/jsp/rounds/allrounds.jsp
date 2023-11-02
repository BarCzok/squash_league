<%--@elvariable id="rounds" type="java.util.List<com.praktyki.squash.facades.dto.RoundDTO>"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allRounds</title>
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

    </style>
</head>
<body>
<div>
    <table>
        <colgroup>
            <col span="1" style="background-color: white">
        </colgroup>
        <thead>
            <td>RoundName</td>
            <td>StartDate</td>
            <td>EndDate</td>
        </thead>

        <c:forEach var="round" items="${rounds}">
            <tr>
                <td><a href="view/${round.id}">${round.name}</a></td>
                <td>${round.startDate}</td>
                <td>${round.endDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>




</body>
</html>
