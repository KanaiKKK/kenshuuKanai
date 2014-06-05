<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book タスク</title>
</head>
<body>
<table border="1">
	<tr>
		<th>ISBNコード</th>
		<th>書名</th>
		<th>価格</th>
		<th>出版社</th>
		<th>刊行年月日</th>
	</tr>
	<c:forEach items="${list}" var="books">
	<tr>
		<td><c:out value="${books.isbn}" /></td>
		<td><c:out value="${books.title}" /></td>
		<td><c:out value="${books.price}" /></td>
		<td><c:out value="${books.publish}" /></td>
		<td><c:out value="${books.published}" /></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>