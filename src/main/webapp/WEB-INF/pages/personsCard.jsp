
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Persons Card</title>

    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

</head>
<body>

<h2>Name:</h2>
<div>
    ${person.name}
</div>
<br>

<h2>Date of Birth</h2>
<div>
    ${person.dateOfBirth}
</div>

<br>

<table class="tg">
    <tr>
        <th>Cars list</th>

    </tr>

    <c:forEach var="car" items="${person.cars}">
        <tr>

            <td>
                    ${car.model}
            </td>

        </tr>
    </c:forEach>
    <c:if test="${empty person.cars}">
        no cars added yet.
    </c:if>
</table>
</body>
</html>
