
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddNewPerson</title>
</head>
<body>

<form:form method="post" action="/HelloSpringMVC/add-new-person" modelAttribute="person">

    <form:hidden path="id" />


    <div >
        <h3>Введите данные</h3>

        <div>
            <label>Name</label>
            <form:input path="name" required="required"/>
            <c:if test="${not empty logError}">
                ${logError}
            </c:if>

        </div>
        <br>

        <br>
        <div>
            <label >Date of birth</label>
            <form:input type="date" path="dateOfBirth" required="required"/>
            <c:if test="${not empty logError2}">
                ${logError2}
            </c:if>

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
