<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dashboard</h1>
	
	
	<a href="/users/logout" class="btn btn-outline-danger">LogOut</a>
	
	<a href="/book/create" class="btn btn-outline-success">+ Add a book to my shelf</a>
	
	<h1>Books from everyone's shelves:</h1>
	<table class="table table-dark">
  <thead>
    <tr>
      <th>id</th>
      <th>Title</th>
      <th>Author</th>
      <th>My Thoughts</th>
      <th>Posted by</th>
      <th>Actions</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${allBooks}">
    <tr>
      <td><c:out value="${book.id }"/></td>
     <td><a href="/book/display/${book.id}"><c:out value="${book.title }"/></a></td>
     <td><c:out value="${book.author }"/></td>
     <td><c:out value="${book.thoughts }"/></td>
     <td><c:out value="${book.user.userName }"/></td>
     <td>
     <c:if test="${book.user.id == user_id }">
     <a href="/book/edit/${book.id}" class="btn btn-outline-warning">Edit</a>
     <form action="/book/delete/${book.id }" method="post">
     		<input type="hidden" name="_method" value="Delete"/>
     		<input type="submit" value="delete" class="btn btn-outline-danger"/>
     </form>
     </c:if>
    </td>
    </c:forEach>
</body>
</html>