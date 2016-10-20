<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send mail</title>
</head>

<body>
ololo
<br/><br/>
<form:form action="sendMail" modelAttribute="student"  method="POST">


        <form:hidden path="id" />
    First name  <form:input path="name"/>

    Last name  <form:input path="surname"/>

    <br><br>

        <input type="submit" value="Submit"/>
        <!--  submit automaticaly setFirsnName and setLastName in to Student -->
    </form:form>

<br><br>

</body>

</html>