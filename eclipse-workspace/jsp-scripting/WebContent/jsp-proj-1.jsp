<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Matt Rencher JSP-1
Make a JSP page that randomly selects a 
background color for each request.
-->

<HTML>
<HEAD>
  <TITLE>Color Testing 1</TITLE>
</HEAD>
<% 
String bgColor = utils.ColorUtils.random();
%>

<BODY BGCOLOR="<%= bgColor %>">

<H2 ALIGN="CENTER">Testing a Background of "<%= bgColor %>".</H2>
<BR>
</BODY></HTML>