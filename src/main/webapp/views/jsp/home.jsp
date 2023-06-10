<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/10/2023
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid d-block mx-auto p-2 text-center">
    <h1 class="h1 badge bg-primary text-wrap fs-2 mx-auto">
        <%= "IDM" %>
    </h1>
</div>
<div class="container-fluid d-block mx-auto p-2 text-center">
    <%-- iterate through websites array and display them--%>
    <c:forEach var="website" items="${websites}">
        <p>${website.url}</p>
    </c:forEach>
</div>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>
