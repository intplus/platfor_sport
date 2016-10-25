<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send mail</title>
</head>

<body>
ololo
<h1>you trying to sent email to this students: </h1>
<c:forEach items="${students}" var="students">
    <p>${students.name} ${students.surname}</p>
</c:forEach>
<br/><br/>
<form:form  action="sendMail" method="post">
<input type="text" name="topic" placeholder="">
    <textarea name="body" placeholder="Enter message here"></textarea>
    <br><br>

        <input type="submit" value="Send"/>
        <!--  submit automaticaly setFirsnName and setLastName in to Students -->
    </form:form>

<br><br>

</body>

</html>