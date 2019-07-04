<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 01.07.2019
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddNewPerson</title>
</head>
<body>
<%--<form ng-submit="addNewUser()">--%>

<%--<form:form method="post" action="${action}" modelAttribute="person">--%>


<%--<tr>--%>
    <%--<td>--%>
        <%--<form:label path="name">--%>
            <%--<spring:message text="Name"/>--%>
        <%--</form:label>--%>
    <%--</td>--%>
    <%--<td>--%>
        <%--<form:input path="name" />--%>
    <%--</td>--%>
<%--</tr>--%>

    <%--<div >--%>
        <%--<h3>Введите данные</h3>--%>

        <%--<div>--%>
            <%--<label>Name</label>--%>
        <%--</div>--%>
        <%--<br>--%>
        <%--<div>--%>
            <%--<input  id="nameUser" type="text" name="name" >--%>
        <%--</div>--%>
        <%--<br>--%>
        <%--<div>--%>
            <%--<label >Date of birth</label>--%>
        <%--</div>--%>
        <%--<br>--%>
        <%--<div>--%>
            <%--<input id = "dayOfBirth" type="text" name="dayOfBirth" >--%>
        <%--</div>--%>
        <%--<br>--%>

            <%--<div>--%>
                <%--<input  type="submit" value="Добавить">--%>
            <%--</div>--%>

    <%--</div>--%>
<%--</form>--%>
<%--</form:form>--%>



<form:form method="post" action="/HelloSpringMVC/add-new-person" modelAttribute="person">

    <form:hidden path="id" />






    <div >
        <h3>Введите данные</h3>

        <div>
            <label>Name</label>
            <form:input path="name" />
        </div>
        <br>

        <br>
        <div>
            <label >Date of birth</label>
            <form:input path="dateOfBirth" />

        </div>
        <br>
        <br>

        <div class="col-md-offset-3 col-md-9">
            <form:button cssClass="btn btn-primary">Submit</form:button>
        </div>
    </div>

</form:form>

</body>
</html>
