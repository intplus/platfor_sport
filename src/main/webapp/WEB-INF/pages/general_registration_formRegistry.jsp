<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <title> General Register Form</title>
</head>


<body>


<form:form action="showFirstWorkPage" >

Hello on this page

        <%--First name  <form:input type="text" path="firstName"  />--%>

        <%--Last name  <form:input type="text" path="lastName" />--%>

        <%--You Email  <form:input type="text" path="email" />--%>

        <%--You number  <form:input type="text" path="phone" />--%>








<input type="submit" value="Submit">

</form:form>

</body>
</html>