
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

                <td>
                        ${person.id}
                </td>
                <td>
                        ${person.name}
                </td>
                <td>
                                ${person.dateOfBirtToString}
                </td>
                <td><a href="<c:url value='/showCard/${person.id}' />" >Persons card</a></td>

        </tr>
    </c:forEach>
    <c:if test="${empty persons}">
        no users added yet.
    </c:if>
</table>


<br>
<br>
<br>


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


</body>
</html>
