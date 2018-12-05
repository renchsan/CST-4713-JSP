<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
1. Create a bean class "studentInfo" that collects following information from StudentInfo.html.
First name, Middle Initial, Last Name, SSN

2. Create a showStudentInfo.jsp page that shows what user typed
in using studentInfo bean class. No java codes are allowed in this page.
-->
<HTML>
<HEAD>
<TITLE>Using JavaBeans with JSP</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Using JavaBeans with JSP</TABLE>
          
<jsp:useBean id="studentInfo" class="coreservlets.StudentInfo" />
<jsp:setProperty property="*" name="studentInfo"/>
<UL>
	<LI><I>First Name: </I>
	<jsp:getProperty name="studentInfo" property="firstName" />
	<LI><I>Middle Initial: </I>
	<jsp:getProperty name="studentInfo" property="middleInitial" />
	<LI><I>Last Name: </I>
	<jsp:getProperty name="studentInfo" property="lastName" />
	<LI><I>SSN: </I>
	<jsp:getProperty name="studentInfo" property="ssn" />
</UL>         
</BODY></HTML>