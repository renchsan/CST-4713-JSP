<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example of the import attribute of the page directive. 
-->
<HTML>
<HEAD>
<TITLE>The import Attribute</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H2>The import Attribute</H2>
<%-- JSP page Directive --%>
<%@ page import="java.util.*,coreservlets.*" %>
<%-- JSP Declaration --%>
<%!
private String randomID() {
  int num = (int)(Math.random()*10000000.0);
  return("id" + num);
}
private final String NO_VALUE = "<I>No Value</I>";
%>
<%-- JSP Scriptlet --%>
<%
String oldID = 
  CookieUtilities.getCookieValue(request, "userID", NO_VALUE);
if (oldID.equals(NO_VALUE)) {
  String newID = randomID();
  Cookie cookie = new LongLivedCookie("userID", newID);
  response.addCookie(cookie);
}
%>
<%-- JSP Expressions --%>
This page was accessed on <%= new Date() %> with a userID
cookie of <%= oldID %>.


<br/><br/><br/><br/><br/><br/>
<font size="-3">All code from the
<a href="http://courses.coreservlets.com/Course-Materials/">
coreservlets.com J2EE tutorials (servlets, JSP, Struts, JSF 1, JSF 2, PrimeFaces, Ajax [with jQuery], GWT 2, Spring, Hibernate, JPA,
SOAP-based and RESTful Web Services, Hadoop, &amp; Java 7 programming)</a>. There are also live instructor-led
<a href="http://courses.coreservlets.com/">training courses on
the same J2EE topics (servlets, JSP, Struts, JSF 1, JSF 2, PrimeFaces, Ajax [with jQuery], GWT 0, Spring, Hibernate, JPA,
SOAP-based and RESTful Web Services, Hadoop, &amp; Java 7 programming)</a>.
</font>
</BODY></HTML>