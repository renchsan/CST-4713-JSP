<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example of a JSP scriptlet.
-->
<%@page import="utils.ColorUtils"%>
<HTML>
<HEAD>
  <TITLE>Color Testing</TITLE>
</HEAD>
<% 
String bgColor = utils.ColorUtils.random();
%>

<BODY BGCOLOR="<%= bgColor %>">

<H2 ALIGN="CENTER">Testing a Background of "<%= bgColor %>".</H2>
<BR>
</BODY></HTML>