<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 03.07.2019
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Add new car</title>
</head>
<body>

<form:form method="post" action="/HelloSpringMVC/add-new-car" modelAttribute="carRequest">

    <%--<form:hidden path="id" />--%>

    <div >
        <h3>Введите данные</h3>

        <div>
            <label>Model</label>
            <form:input path="model" />
        </div>
        <br>

        <br>
        <div>
            <label >Horse Power</label>
            <form:input path="horsePower" />
        </div>
        <br>
        <br>
        <div>
            <label >Owner ID</label>
            <form:input path="personID" />
        </div>

        <br>

        <div class="col-md-offset-3 col-md-9">
            <form:button cssClass="btn btn-primary">Submit</form:button>
        </div>
    </div>

</form:form>

</body>
</html>
