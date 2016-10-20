<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.10.2016
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
            <li><a href="#">Главная</a></li>
            <li><a href="/group/ShowGroupPage">Группы</a></li>
            <li><a href="/registerPerson/showFirstWorkPage">Кабинет</a></li>
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
    <form:form action="saveStudentAfterUpdate" modelAttribute="student" method="POST">

        <form:hidden path="id" />

    <table>
        <tbody>
        <tr>
            <td><label>First name:</label></td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td><label>Last name:</label></td>
            <td><form:input path="surname" /></td>
        </tr>

        <tr>
            <td><label>Email:</label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><label>Phone:</label></td>
            <%--<td><form:input path="phone" /></td>--%>
        </tr>

        <tr>
            <td><label>Birthday:</label></td>
            <td><form:input path="birthday" /></td>
        </tr>



        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>

        </tbody>
    </table>
    </form:form>
</div>

<a href="A_small_fitness_first_work_Page.jsp"></a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>