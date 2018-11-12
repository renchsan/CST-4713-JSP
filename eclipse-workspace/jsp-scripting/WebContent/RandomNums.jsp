<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
One of four random-number examples. This one uses expressions. 
-->
<HTML>
<HEAD>
<TITLE>Random Numbers</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Random Numbers</H1>
<UL>
  <LI><%= coreservlets.RanUtilities.randomInt(10) %></LI>
  <LI><%= coreservlets.RanUtilities.randomInt(10) %></LI>
  <LI><%= coreservlets.RanUtilities.randomInt(10) %></LI>
  <LI><%= coreservlets.RanUtilities.randomInt(10) %></LI>
  <LI><%= coreservlets.RanUtilities.randomInt(10) %></LI>
</UL>

<br><br><br><br><br><br>
<font size="-3">All code from the
<a href="http://courses.coreservlets.com/Course-Materials/">
coreservlets.com J2EE tutorials (servlets, JSP, Struts, JSF 1.x, JSF 2.0, Ajax [with jQuery, Prototype,
Scriptaculous, Dojo, Ext-JS, and Google Closure], GWT 2.0, Spring, Hibernate, JPA,
SOAP-based and RESTful Web Services, &amp; Java 6 programming)</a>. There are also live instructor-led
<a href="http://courses.coreservlets.com/">training courses on
the same J2EE topics (servlets, JSP, Struts, JSF 1.x, JSF 2.0, Ajax [with jQuery, Prototype,
Scriptaculous, Dojo, Ext-JS, and Google Closure], GWT 2.0, Spring, Hibernate, JPA,
SOAP-based and RESTful Web Services, &amp; Java 6 programming)</a>.
</font>
</BODY></HTML>