<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new user</title>
    <spring:url value="/resources/css/first_work_page_forOther.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />

    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
</head>
<body>
<SCRIPT language="javascript">
    $.noConflict();
    $(function(){

        // add multiple select / deselect functionality
        $("#selectall").click(function () {
            $('.case').attr('checked', this.checked);
        });

        // if all checkbox are selected, check the selectall checkbox
        // and viceversa
        $(".case").click(function(){

            if($(".case").length == $(".case:checked").length) {
                $("#selectall").attr("checked", "checked");
            } else {
                $("#selectall").removeAttr("checked");
            }

        });
    });
</SCRIPT>
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


<div class="container addgroup_form">

    <form:form action="deleteGroup" modelAttribute="group" method="POST">
    <form:hidden path="id" />
    <h3>Check groups for delete</h3>
    <li>Group List <input type="checkbox" id="selectall">
        <ul>
            <c:forEach items="${groupList}" var="groups">

                <c:choose>
                    <c:when test="${groups.name!=null}">
                      <li>  <c:out value="${groups.name}"/><input type="checkbox" class="case", name="case" value="${groups.id}"></li>
                    </c:when>
                    <c:when test="${groups.nameTraine!=null}">
                     <li>   <c:out value="${groups.nameTraine}"/> <input type="checkbox" class="case", name="case" value="${groups.id}"> </li>
                    </c:when>
                </c:choose>

            </c:forEach>
        </ul>


    </li>

        <input type="submit" value="Delete">
</form:form>
</div>
<a href="/group//ShowGroupPage">Return tu group</a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>
