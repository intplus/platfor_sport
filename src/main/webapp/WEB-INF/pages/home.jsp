<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--&lt;%&ndash;<%@ include file="/WEB-INF/tags/layout/includes.jsp"%>&ndash;%&gt;--%>
<%--&lt;%&ndash;<t:dashboard>&ndash;%&gt;--%>
	<%--<jsp:body>--%>

		<%--<h1>welcome <c:out value="${user.username}"></c:out>, </h1>--%>
		<%--<p>This is sample project Spring MVC Spring security and  Hibernate for mysql connectivity</p>--%>
		<%--<p><b>note :</b> after run this project make changes db.propersie file hibernate.hnb2ddl.auto property create to update--%>
			<%--otherwise every time database drop and create data will be lost--%>
		<%--</p>--%>
		<%--<p>This is an open source project</p>--%>

	<%--</jsp:body>--%>
<%--&lt;%&ndash;</t:dashboard>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
Home

<a href='<c:url value="/logout"></c:url>' class="btn btn-default btn-flat">Sign out</a>
</body>
</html>