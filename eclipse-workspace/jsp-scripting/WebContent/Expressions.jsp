<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>JSP Expressions</TITLE>
<META NAME="keywords"
      CONTENT="JSP,expressions,JavaServer Pages,servlets">
<META NAME="description"
      CONTENT="A quick example of JSP expressions.">
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H2>JSP Expressions</H2>
<UL>
  <LI>Current time: <%= new java.util.Date() %></LI>
  <LI>Server: <%= application.getServerInfo() %></LI>
  <LI>Session ID: <%= session.getId() %></LI>
  <LI>The <CODE>testParam</CODE> form parameter:
      <%= request.getParameter("testParam") %></LI>
</UL>

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