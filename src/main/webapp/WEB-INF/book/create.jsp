<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create A Book</h1>

<form:form action="/book/process/create" modelAttribute="book" method="post">
		<form:input type="hidden" path="user" value="${user_id }"/>
		<div>
			<form:label path="title">Title</form:label>
			<form:input type="text" path="title"/>
			<form:errors path="title"/>
		</div>
		<div>
			<form:label path="author">Author</form:label>
			<form:input type="text" path="author"/>
			<form:errors path="author"/>
		</div>
		<div>
			<form:label path="thoughts">My thoughts</form:label>
			<form:textarea path="thoughts"></form:textarea>
			<form:errors path="thoughts"/>
		</div>
			<button class="btn btn-outline-success">Submit</button>
		</form:form>
</body>
</html>