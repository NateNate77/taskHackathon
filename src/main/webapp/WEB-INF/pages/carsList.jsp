<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 03.07.2019
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarsList</title>

    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<br>
<h3>Cars List</h3>
<br>
<table class="tg">
    <tr>
        <th>Car ID</th>
        <th>Model</th>
        <th>Horse Power</th>
        <th>Owner ID</th>
    </tr>

    <c:forEach var="car" items="${cars}">
        <tr>
                <%--<td>--%>
                <%--<c:out value="${person.id}"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                <%--<c:out value="${person.name}"/>--%>
                <%--</td>--%>

            <td>
                    ${car.id}
            </td>
            <td>
                    ${car.model}
            </td>
            <td>
                    ${car.horsepower}
            </td>

                    <td>
                            ${car.ownerId}
                    </td>
                <%--<td>--%>
                <%--<a href="<c:url value="/delete/${user.id}"/>" >Delete user</a>--%>
                <%--</td>--%>
        </tr>
    </c:forEach>
    <c:if test="${empty cars}">
        no cars added yet.
    </c:if>
</table>

<br>
<br>
<br>
<div>
    <a href="/HelloSpringMVC/add-new-car" >Add car</a>
</div>

<br>
<br>
<div>
    <a href="/HelloSpringMVC">Go main</a>
</div>

</body>
</html>
