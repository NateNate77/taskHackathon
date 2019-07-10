<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 24.04.2019
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloworld</title>

    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

</head>
<body>
<%--<h1>${greeting}</h1>--%>
<br>
<h3>Persons List</h3>
<br>
<table class="tg">
    <tr>
        <th>Person ID</th>
        <th>Person Name</th>
        <th>Person birthDay</th>
        <th>Info</th>

    </tr>

    <c:forEach var="person" items="${persons}">
        <tr>
            <%--<td>--%>
                <%--<c:out value="${person.id}"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<c:out value="${person.name}"/>--%>
            <%--</td>--%>

                <td>
                        ${person.id}
                </td>
                <td>
                        ${person.name}
                </td>
                <td>
                        <%--${person.dateOfBirth}--%>
                                ${person.dateOfBirtToString}
                </td>
                <td><a href="<c:url value='/showCard/${person.id}' />" >Persons card</a></td>

            <%--<td>--%>
                <%--<a href="<c:url value="/delete/${user.id}"/>" >Delete user</a>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
    <c:if test="${empty persons}">
        no users added yet.
    </c:if>
</table>


<br>
<br>
<br>

<%--<div>--%>
    <%--<button onclick="location.href='/add-new-person'">Создать</button>--%>

<%--</div>--%>


<%--<div>--%>
    <%--<a href="<c:url value="/add-new-person"/>" >Add person</a>--%>
<%--</div>--%>

<%--<div>--%>
    <%--<c:url var="action" value="/add-new-person" >Add person</c:url>--%>
<%--</div>--%>


<div>
    <a href="/HelloSpringMVC/add-new-person" >Add person</a>
</div>
<br>
<br>
<div>
    <a href="/HelloSpringMVC/delete-persons" >Clear Table</a>
</div>
<br>
<div>
    <a href="/HelloSpringMVC">Go to main</a>
</div>

<%--<a href="<c:url value="/add"/>" >Add new user</a>--%>

</body>
</html>
