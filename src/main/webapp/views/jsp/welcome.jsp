<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid ">
    <div class="container-fluid d-block mx-auto p-2 text-center">
        <h1 class="h1 badge bg-primary text-wrap fs-2 mx-auto">
            <%= "IDM" %>
        </h1>
    </div>
    <div class="container-fluid d-block mx-auto p-2 text-center">
        <form action="/download" method="post" class="row g-2 text-center justify-content-md-center" >
            <div class="col-auto">
                <input class="form-control" type="text" placeholder="enter url to download website" aria-label="default input example" name="url" id="url" required>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>
                <div id="emailHelp" class="form-text">Make sure to give a correct and full url</div>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-1">Submit</button>
            </div>
        </form>

        <c:if test="${isLoading}">
            <div class="spinner-border text-primary" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
        </c:if>
    </div>
</div>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>