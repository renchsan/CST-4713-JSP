<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Matt Rencher JSP-3
-->

<HTML>
<HEAD>
  <TITLE>Color Testing</TITLE>
</HEAD>

<% 
String bgParam = request.getParameter("bgColor");
String bgColor = "";
if ((bgParam == null) || (bgParam.trim().equals(""))) { 
	bgColor = lastColor;
} else {
	bgColor = bgParam;
}
%>
<%! lastColor = bgParam; %>
<BODY BGCOLOR="<%= bgColor %>">

<H2 ALIGN="CENTER">Testing a Background of "<%= bgColor %>".</H2>

<BR>
<FORM>
  Color: <INPUT TYPE="TEXT" NAME="bgColor"><BR>
  <INPUT TYPE="SUBMIT" VALUE="Try the Color">
</FORM>
</BODY></HTML>