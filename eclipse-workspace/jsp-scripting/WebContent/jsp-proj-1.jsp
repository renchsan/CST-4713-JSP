<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Matt Rencher JSP-1
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