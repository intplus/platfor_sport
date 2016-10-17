<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.10.2016
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new user</title>
    <spring:url value="/resources/css/first_work_page.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />

    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
</head>
<body>
<header class="header">
    <div class="container">
        <h1>World Sport Platform BF 1.0</h1>
        <h2>
            <small>Movement breeds success!</small>
        </h2>
    </div>
</header>
<!-- /HEADER -->
<!-- NAVIGATION -->
<nav class="page-navigation">
    <div class="container">
        <ul>
            <li><a href="/">Главная</a></li>
            <li><a href="">Группы</a></li>
            <li><a href="#">Кабинет</a></li>
            <%--<li><a href="#">Просмотр моей страници</a></li>--%>
            <%--<li><a href="#">Статистика</a></li>--%>
            <%--<li><a href="#">Расчеты</a></li>--%>
        </ul>

        <!-- LOGIN FORM -->
        <form action="#" class="login">
            <input type="text" placeholder="Login" required>
            <input type="password" placeholder="Password" required>
            <input type="submit" value="Sign In">
        </form>
        <!-- /LOGIN FORM -->
    </div>
</nav>

<div class="container addstudent_form">
    <h1>Add student</h1>
    <br>
    <form:form modelAttribute="newStudent" method="post">
        <label for="name"><spring:message code="addStudent.form.name"></spring:message></label>
        <form:input id="name" path="name"></form:input>
        <br>
        <label for="lastName"><spring:message code="addStudent.form.lastName"></spring:message> </label>
        <form:input path="surname" id="lastName"></form:input>
        <br>
        <label for="email"><spring:message code="addStudent.form.email"></spring:message></label>
        <form:input id="email" path="email"></form:input>
        <br>
        <label for="phone"><spring:message code="addStudent.form.phone"></spring:message> </label>
        <form:input path="phone" id="phone"></form:input>
        <br>
        <label for="birthday"><spring:message code="addStudent.form.birthday"></spring:message> </label>
        <form:input path="birthday" id="birthday"></form:input>
        <br>
        <input type="submit" value="Add">
    </form:form>
</div>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>
