<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Task Page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
</head>

<body>

<div class="generic-container">
    <div class="well lead">Please, type numbers of coefficients for your QE</div>
    <%--@elvariable id="numbers" type=""--%>
    <form:form method="POST" modelAttribute="numbers" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="numbA">numbA</label>
                <div class="col-md-7">
                    <form:input type="text" path="numbA" id="numbA" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="numbA" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="numbB">numbB</label>
                <div class="col-md-7">
                    <form:input type="text" path="numbB" id="numbB" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="numbB" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="numbC">numbC</label>
                <div class="col-md-7">
                    <form:input type="text" path="numbC" id="numbC" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="numbC" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Calculate" class="btn btn-primary btn-sm"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>