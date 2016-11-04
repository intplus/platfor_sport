<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send mail</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script  type="text/javascript" src="/resources/script/bootstrap.min.js"></script>
</head>

<body>
<form:form  action="sendMail" method="post">



    <input name="email" placeholder="Enter email you want to send from"  type="text">

        <!-- Password input-->


                    <input type="password" name="password" placeholder="Enter password from your email"  >



        <!-- Text input-->

                    <input name="topic" placeholder="Topic of the letter" class="form-control" type="text">

        <!-- Text area -->


                    <textarea class="form-control" name="body" placeholder="Enter message here"></textarea>


        <!-- Success message -->
        <div class="alert alert-success" role="alert" id="success_message"> <i class="glyphicon glyphicon-thumbs-up"></i> </div>

        <!-- Button -->

              <input type="submit" value="save">

</form:form>

<br><br>


</body>

</html>