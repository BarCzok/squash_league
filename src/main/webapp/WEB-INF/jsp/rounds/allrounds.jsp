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
            font-family: Tahoma, sans-serif;
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
    <table>
        <colgroup>
            <col span="1" style="background-color: white">
        </colgroup>

            <th>RoundName</th>
            <th>StartDate</th>
            <th>EndDate</th>


        <c:forEach var="round" items="${rounds}">
            <tr>
                <td><a href="${round.id}/view">${round.name}</a></td>
                <td>${round.startDate}</td>
                <td>${round.endDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>




</body>
</html>
