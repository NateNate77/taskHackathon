
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>
<h2>Count added persons:</h2>
${fn:length(persons)}

<br>
<h2>Count added cars:</h2>
${fn:length(cars)}

<br>
<h2>Count unique manufacturer:</h2>
<%--${fn:length(cars)}--%>
${fn:length(manufacturers)}

<br>
<br>

<div>
    <a href="/HelloSpringMVC">Go to main</a>
</div>

</body>
</html>
