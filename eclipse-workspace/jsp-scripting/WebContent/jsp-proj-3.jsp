<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Matt Rencher JSP-3
Make a JSP page that lets the user supply a request parameter indicating the back-
ground color. If no parameter is supplied, 
the most recently used background color 
(from a previous request by any user) should be used.
-->

<HTML>
<HEAD>
  <TITLE>Color Testing</TITLE>
</HEAD>

<%! private String lastColor = ""; %>
<%
String bgParam = request.getParameter("bgColor");
String bgColor = "";
if ((bgParam == null) || (bgParam.trim().equals(""))) { 
	if (!lastColor.isEmpty()){
		bgColor = lastColor;
	}
} else {
	bgColor = bgParam;
	lastColor = bgParam;
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