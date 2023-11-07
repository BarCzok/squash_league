<html>
<head>
    <title>Dane Zawodnika</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>

</head>
<body>
<center>
<h1>Dane Zawodnika ${player.id}</h1>

    <table class="player">
    <tr><td>imie:</td><td> ${player.name}</td></tr>
    <tr><td>nr tel:</td><td> ${player.phoneNumber}</td></tr>
        <tr><td>adres:</td><td>${player.adress}</td></tr>
    </table>
</center>
</body>
</html>