<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Show One Book</h1>
	
	<p>Book Id:<c:out value="${book.id }"/></p>
	<p>Book Title:<c:out value="${book.title }"/></p>
	<p>Book Author:<c:out value="${book.author }"/></p>
	<p>Book Thoughts:<c:out value="${book.thoughts }"/></p>
	<p>Posted By:<c:out value="${book.user.userName }"/></p>
	
	 <c:if test="${book.user.id == user_id }">
     <a href="/book/edit/${book.id}" class="btn btn-outline-warning">Edit</a>
     <form action="/book/delete/${book.id }" method="post">
     		<input type="hidden" name="_method" value="Delete"/>
     		<input type="submit" value="delete" class="btn btn-outline-danger"/>
     </form>
     </c:if>
</body>
</html>