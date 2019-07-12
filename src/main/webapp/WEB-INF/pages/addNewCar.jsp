
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forEach" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add new car</title>
</head>
<body>

<form:form method="post" action="/HelloSpringMVC/add-new-car" modelAttribute="carRequest">

    <div >
        <h3>Введите данные</h3>
        <br>
        <c:if test="${not empty logErrorEmptyOwner}">
            ${logErrorEmptyOwner}
            <br>
        </c:if>


        <div>
            <label>Model</label>
            <form:input path="vendor" required="required" />-<form:input path="model" required="required" />

            <c:if test="${not empty logErrorEmptyName}">
                ${logErrorEmptyName}
                <br>
            </c:if>


        </div>
        <br>

        <br>
        <div>
            <label >Horse Power</label>
            <form:input path="horsePower" required="required"/>
            <c:if test="${not empty logError}">
                ${logError}
            </c:if>

        </div>
        <br>
        <br>
        <div>
            <label >Owner ID</label>


            <select name="persons" id="personsID" onchange="change()">
                <c:forEach var="person" items="${person}">
                    <option value="${person.id}">${person.name}</option>
                </c:forEach>
            </select>


            <script>
                window.onload = function() {
                    document.getElementById("personsID").options[0].selected=true;
                    document.getElementById('personID').value = document.getElementById("personsID").options[0].value;
                };
            </script>


           <script>
               var targetValue;
               var sel = document.getElementById("personsID");

               function change(){
                   targetValue = sel.value;
                   document.getElementById('personID').value = targetValue;
               }


           </script>

            <form:hidden path="personID"/>

        </div>

        <br>

        <div class="col-md-offset-3 col-md-9">
            <form:button cssClass="btn btn-primary">Submit</form:button>
        </div>
    </div>

</form:form>


<a href="/HelloSpringMVC">Go to main</a>

</body>
</html>
