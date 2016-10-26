<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> First Work Page</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <spring:url value="/resources/script/js.js" var="js" />
    <spring:url value="/resources/css/first_work_page.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />
    <spring:url value="/resources/css/tableStyle.css" var="tableStyle" />

    <script src="<c:url value="/resources/script/js.js" />"></script>
    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
    <link rel="stylesheet" type="text/css" href="${tableStyle}" >

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
<!-- NAVIGATION -->
<div class="menu-navigation">
    <ul id="navbar">
        <li><a href="#">Main</a></li>
        <li><a href="/registerPerson/showFirstWorkPage">Cabinet</a></li>
        <c:forEach items="${groupsList}" var="groups">
        <%--<c:if test="${groups.id!=null}">--%>
        <%--<li><a href="#">${groups.name}</a>--%>
        <%--</c:if>--%>
        <li><a href="#">Groups</a>
            <ul id="group">

                <li><a href="/group/ShowGroupPage">overall</a></li>
                <%--<li id="create"><a href="javascript://" onclick="Add();return false;">Create</a>  </li>--%>
                <li id="create"   ><a href="/group//showFormForAddGroup">Create</a>  </li>
                <li><a href="#">Delete</a> </li>
                <li><a href="#">Categoty</a> </li>
                <li><a href="/group//showFormForUpdate">Update</a> </li>
                  <%--<c:forEach items="${groupsList}" var="groups">--%>
                      <c:url var="takeGroupId" value="/group//takeIdGroup" >
                          <c:param name="groupId" value="${groups.id}"/>
                      </c:url>
                    <c:if test="${groups.name!=null}">

                        <li >

                            <%--<a href="/group//ShowGroupPage" >--%>
                                <a href="${takeGroupId}" >

                            <c:out value="${groups.name}" />




                        </a> </li>

                    </c:if>

                </c:forEach>



            </ul>
        </li>

        <li><a href="#">instructors group</a>
            <ul>
                <li><a href="#">Create</a>  </li>
                <li><a href="#">Categoty</a></li>
                <li><a href="#">Delete</a> </li>
                <li><a href="#">Update</a> </li>

            </ul>
        </li>
        <li><a href="#">Statistics</a></li>
        <li><a href="#">Finance</a></li>
        <li id="out"><a href="">Out</a></li>

    </ul>

</div>



<!-- MAIN SECTION -->
<main>

    <div class="work_form">

        <div class="button_navigation_form">

            <div class=" fins_form">

                <form action="find" method="get">
                    <label for="surname"><spring:message code="firstWorkPage.findStudent.surname"></spring:message> </label>
                    <input type="text" id="surname" name="surname">
                    <input type="submit" value="найти">
                </form>

            </div>

            <div class="sort_form" >

                <form method="get" action="/registerPerson//sort">
                    <select name="option">
                        <option disabled selected><spring:message code="sort.selectSortType"></spring:message> </option>
                        <option value="ageAfterSixteen"><spring:message code="sort.sortByAgeAfter"></spring:message> </option>
                        <option value="ageBeforeSixteen"><spring:message code="sort.sortByAgeBefore"></spring:message> </option>
                        <option value="getUnknownStudent"><spring:message code="sort.getStudentByOnlyUnknownStudent"></spring:message> </option>
                        <option value="allStudent"><spring:message code="sort.sortByAll"></spring:message> </option>
                    </select>
                    <input type="submit" value="<spring:message code="Sort"></spring:message> ">
                </form>

            </div>

        </div>


        <%--Table form--%>
        <div class="table form">

            <form method="get" action="delete">
                <input type="hidden" id="txt" name="">
                <input type="button" value="Добавить"
                       onclick="window.location.href='addStudentToGroupForm'; return false;" class="add-button"
                />
                <input type="submit" name="deletee" value="удалить">
                <input type="submit" name="send_email" value="send email" class="add-button"
                />
                <input type="button" value="Отправить смс">
                <%--<input type="button" value="отправить письмо">--%>
        </div>
    </div>
    <br/><br/>
    <br/><br/>
    <br/><br/>

    <table border="3"  width="100%"   cellpadding="4" cellpacing="3">
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Телефон</th>
        <th>почта</th>
        <th>абонемент</th>
        <th>Разовое посещение</th>
        <th>Дата начала Абонемента</th>
        <th>Дата окончания Абонементадата</th>
        <th>Статус оплаты</th>
        <th><input type="checkbox" id="selectall"></th>

        <c:forEach items="${studentList}" var="student">
            <tr align="center">
                <td>${student.name}</td>
                <td align="left">${student.surname}</td>
                <td>${student.phone}</td>
                <td>${student.email}</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><input type="checkbox" class="case", name="case" value="${student.id}"></td>
                <td align="left"></td>
                <td>
                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/registerPerson/showFormForUpdate" >
                        <c:param name="studentId" value="${student.id}"/>
                    </c:url>

                    <!-- display the update link -->
                    <a href="${updateLink}">Редактировать</a>

                </td>
            </tr>
        </c:forEach>

    </table>
    </form>


    <br><br>
    <br><br>

    </div>

</main>


<!-- FOOTER -->
<footer class="footer">
    <div class="container">

    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>
