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
    <style><%@include file="/WEB-INF/css/style.css"%></style>

</head>

<body>
<div>
    <center><h1>Games/${roundName}</h1></center>
    <br>
    <tags:games games="${games}"/>

    <tags:playerRanking/>


    <center><button><a href="/rounds/xd/${roundId}">Zakoncz runde</a></button></center>
</div>
</body>
</html>