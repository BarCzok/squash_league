<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

                <center>
                    <h1>Players/Groups/${roundName}</h1>
                    <c:forEach var="entry" items="${players.entrySet()}">
                        <c:set var="group" value="${entry.key}"/>
                        <c:set var="place" value="0"/>
                        <table>
                            <colgroup>
                                <col span="1" style="background-color: white">
                            </colgroup>
                            <thead>
                            <td>Place</td>
                            <td>Player</td>
                            <td>Group</td>
                            <td>Points</td>
                            </thead>

                            <c:forEach var="player" items="${entry.value}">
                                <tr>
                                    <td>${place=place+1}</td>
                                    <td>${player.name}</td>
                                    <td>${group.name}</td>
                                    <td>${player.totalPoints}</td>
                                </tr>


                            </c:forEach>
                        </table>

                        <br>

                    </c:forEach>
                </center>