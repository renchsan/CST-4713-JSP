<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Matt Rencher JSP-2
Make a JSP page that lets the user supply a request parameter indicating the back-
ground color. If no parameter is supplied, 
a background color should be selected at 
random.
-->

<HTML>
<HEAD>
  <TITLE>Color Testing 2</TITLE>
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