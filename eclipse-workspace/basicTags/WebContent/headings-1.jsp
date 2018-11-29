<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Headings</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<%@ taglib uri="/WEB-INF/tlds/csajsp-taglib.tld" 
           prefix="csajsp" %>
<csajsp:heading align="LEFT" bgColor="CYAN"
                border="10" fgColor="BLACK" 
                font="Arial Black" size="78">
  First Heading
</csajsp:heading>
<csajsp:heading align="RIGHT" bgColor="RED"
                border="1" fgColor="YELLOW" 
                font="Times New Roman" size="50">
  Second Heading
</csajsp:heading>
<csajsp:heading align="CENTER" bgColor="#C0C0C0"
                border="20" fgColor="BLUE" 
                font="Arial Narrow" size="100">
  Third Heading
</csajsp:heading>
</BODY></HTML>