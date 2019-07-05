<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 24.04.2019
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<button href="<c:url value="/hello">go</button>--%>
  <div>
    <a href="<c:url value="/hello"/>" >Show persons list</a>
  </div>
  <%--<button>--%>
    <%--<a href="<c:url value="/hello"/>" >Hello hibernate</a>--%>
  <%--</button>--%>
  <br>
  <br>

  <div>
    <a href="<c:url value="/listCars"/>" >Show cars list</a>
  </div>

  <br>
  <br>
  <div>
    <a href="<c:url value="/statistics"/>" >Show statistics</a>
  </div>

  </body>
</html>
