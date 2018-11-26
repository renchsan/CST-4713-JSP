<!-- Matt Rencher // JSP -->
<!-- File Inclusion Project 2 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Inclusion Project 2</title>
</head>
<body>
<h1>This is a Random news example page</h1>
<% 
String message;
if (Math.random() > 0.5) {
	message = "/WEB-INF/includes/goodNews.jsp";
} else {
	message = "/WEB-INF/includes/badNews.jsp";
}
%>
<h3>
<jsp:include page="<%= message %>"/>
</h3>
</body>
</html>