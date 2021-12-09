<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset ="UTF-8"/>
<title>First JSP App</title>
</head>
<body>

<h2>JSP EXPRESSION</h2>
<p>2 + 2 = <%= 2 + 2 %></p>
<p>6 > 2 = <%= 6 > 2 %></p>
<p><%= new String("Hello").toUpperCase()%></p>
<p>Today<%= new java.util.Date()%></p>
</body>

</html>