<!-- Matt Rencher // JSP -->
<!-- File Inclusion Project 4 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% String title = "File Inclusion Project 4 -- Page 1"; %>

<title><%= title %></title>
</head>
<body>
<h1>  <%= title %>	</h1>


<TABLE BORDER=1>
<UL>
<% for(int i = 0; i<7; i++) { %>
	<LI><%= javaUtils.RanUtilities.randomInt(10) %></LI>
<% } %>
</UL>
</TABLE>


<h3> <%@ include file="/WEB-INF/includes/signature.jsp" %> </h3>
</body>
</html>