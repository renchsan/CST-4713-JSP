<!--
Create a tag "MyClasses" that shows all classes I registered.

You need to create a hanlder class, .tld file, and a .jsp file that calls this tag to show my classes as following:
Intro. Java
Servlet with Database
 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Some 50-Digit Primes</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Show Registered Classes</H1>
<%@ taglib uri="/WEB-INF/tlds/csajsp-taglib.tld" 
           prefix="csajsp" %>
<H3>
  <csajsp:myClasses/>
</H3>

</BODY></HTML>