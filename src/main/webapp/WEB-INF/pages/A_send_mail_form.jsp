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
<input type="text" name="topic" placeholder="Enter the topic of the message">
    <textarea name="body">Enter message here</textarea>
    <br><br>

        <input type="submit" value="Send"/>
        <!--  submit automaticaly setFirsnName and setLastName in to Student -->
    </form:form>

<br><br>

</body>

</html>