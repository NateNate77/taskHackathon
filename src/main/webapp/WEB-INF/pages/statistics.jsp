<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 05.07.2019
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Statistica</title>
</head>
<body>
<h2>Count added persons:</h2>
${fn:length(persons)}

<br>
<h2>Count added cars:</h2>
${fn:length(cars)}

<br>
<br>
<div>
    <a href="/HelloSpringMVC">Go to main</a>
</div>

</body>
</html>
