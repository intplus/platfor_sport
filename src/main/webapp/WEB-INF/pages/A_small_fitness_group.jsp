<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> First Work Page</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <spring:url value="/resources/css/first_work_page.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />

    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >

</head>


<body>

<SCRIPT language="javascript">
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
<!-- HEADER -->
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
            <li><a href="#">Группы</a></li>
            <li><a href="/registerPerson/showFirstWorkPage">Кабинет</a></li>
            <%--<li><a href="#">РџСЂРѕСЃРјРѕС‚СЂ РјРѕРµР№ СЃС‚СЂР°РЅРёС†Рё</a></li>--%>
            <%--<li><a href="#">РЎС‚Р°С‚РёСЃС‚РёРєР°</a></li>--%>
            <%--<li><a href="#">Р Р°СЃС‡РµС‚С‹</a></li>--%>
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
<!-- /NAVIGATION -->
<!-- MAIN SECTION -->
<main>


    <div>
        <%--<div>--%>
            <%--<input type="button" value="Add1">--%>
            <%--<input type="button" value="Add2">--%>
            <%--<input type="button" value="Add3">--%>
            <%--<input type="button" value="Add4">--%>
        <%--</div>--%>
        <br/><br/>
        <br/><br/>

        <input type="button" value="найти">
        <input type="button" value="редактировать">
        <div style="font-weight: bold;
	width: 130px;
	padding: 5px 10px;
	margin-top: 30px;
	margin-left: 800px;
    background: #cccccc; "
            <form:form method="get" action="delete">


            <button><a href="/registerPerson/addStudent">добавить</a></button>
            <input type="submit" value="удалить">
            <input type="button" value="Отправить смс">
            <input type="button" value="отправить письмо">
        </div>
    </div>
    <br/><br/>
    <br/><br/>
    <br/><br/>





    <table border="3"  width="100%"   cellpadding="4" cellpacing="3">
        <tr>
            <th colspan="7">
                <h3><br>Список групп</h3>
            </th>
        </tr>
        <th>Название группы</th>
        <th>Тренер</th>
        <th>Спорт</th>
        <th>Количество студентов</th>
        <th>комментарий</th>
        <th><input type="checkbox" id="selectall"></th>
        <c:forEach items="${students}" var="student">
            <tr align="center">
                <td>${student.name}</td>
                <td align="left">${student.surname}</td>
                <td align="left">${student.phone}</td>
                <td>${student.email}</td>
                <td>${student.birthday}</td>
                <td></td>
                <td></td>
                <td><input type="checkbox" class="case", name="case" value="${student.id}"></td>
                <td align="left"></td>
            </tr>
        </c:forEach>

    </table>
    </form:form>


    <br><br>
    <br><br>
</main>
<!-- /MAIN SECTION -->
<!-- FOOTER -->
<footer class="footer">
    <div class="container">

    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>
