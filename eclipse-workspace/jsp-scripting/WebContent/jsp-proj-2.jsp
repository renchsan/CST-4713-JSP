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
String bgParam = request.getParameter("bgColor");
String bgColor = "";
if ((bgParam == null) || (bgParam.trim().equals(""))) { 
	bgColor = utils.ColorUtils.random();
} else {
	bgColor = bgParam;
}
%>
<BODY BGCOLOR="<%= bgColor %>">

<H2 ALIGN="CENTER">Testing a Background of "<%= bgColor %>".</H2>
<BR>
<FORM>
  Color: <INPUT TYPE="TEXT" NAME="bgColor"><BR>
  <INPUT TYPE="SUBMIT" VALUE="Try the Color">
</FORM>
</BODY></HTML>