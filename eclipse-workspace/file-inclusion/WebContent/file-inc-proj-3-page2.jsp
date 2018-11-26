<!-- Matt Rencher // JSP -->
<!-- File Inclusion Project 3 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% String title = "File Inclusion Project 3 -- Page 2"; %>

<title><%= title %></title>
</head>
<body>
<h1>  <%= title %>	</h1>

<% 
String color = request.getParameter("bgColor");
%>

<% if (color != null) {  %>
	<body bgcolor=<%= color %>>
<% } %>


<TABLE BORDER=1>
  <TR><TH></TH>         <TH>Apples<TH>Oranges
  <TR><TH>First Quarter <TD>2307  <TD>4706
  <TR><TH>Second Quarter<TD>2982  <TD>5104
  <TR><TH>Third Quarter <TD>3011  <TD>5220
  <TR><TH>Fourth Quarter<TD>3055  <TD>5287
</TABLE>

<h3>

<%@ include file="/WEB-INF/includes/signature.jsp" %> 
</h3>
</body>
</html>