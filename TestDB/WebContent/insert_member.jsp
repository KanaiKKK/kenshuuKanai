<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,javax.naming.*,javax.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Member</title>
</head>
<%
Context context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/dbtest");
Connection db = ds.getConnection();
PreparedStatement ps = db.prepareStatement("INSERT INTO member(nam,sex,old,enter,memo)VALUES(?,?,?,?,?)");
ps.setString(1, request.getParameter("nam"));
ps.setString(2, request.getParameter("sex"));
ps.setString(3, request.getParameter("old"));
ps.setString(4, request.getParameter("enter"));
ps.setString(5, request.getParameter("memo"));
ps.executeUpdate();
%>
<body>

</body>
</html>