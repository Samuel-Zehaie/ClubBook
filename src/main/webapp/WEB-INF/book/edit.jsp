<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Edit A Book</h1>
	
	
	<form:form action="/book/process/edit/${book.id}" modelAttribute="book" method="post">
		<input type="hidden" value="patch" name="_method"/>
		<form:hidden  path="user"/>
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
			<button>Submit</button>
		</form:form>
</body>
</html>