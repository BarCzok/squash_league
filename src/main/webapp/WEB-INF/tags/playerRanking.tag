<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

                <center>
                    <h1>Players</h1><br>
                    <c:forEach var="entry" items="${players.entrySet()}">
                        <c:set var="group" value="${entry.key}"/>
                        <h3>${group.name}</h3>
                        <table class="resolut">
                            <colgroup>
                                <col span="1" style="background-color: white">
                            </colgroup>
                            <tr>
                            <td>Place</td>
                            <td>Player</td>
                            <td>Group</td>
                            <td>Points</td>
                            <td>Next group</td>
                            </tr>

                            <c:forEach var="player" items="${entry.value}">
                                <tr>
                                    <td>${player.placeInGroup}</td>
                                    <td>${player.name}</td>
                                    <td>${group.name}</td>
                                    <td>${player.totalPoints}</td>
                                    <td>${player.nextGroup.name}</td>
                                </tr>



                            </c:forEach>
                        </table>
                       <br><br>
                        <br>

                    </c:forEach>
                </center>