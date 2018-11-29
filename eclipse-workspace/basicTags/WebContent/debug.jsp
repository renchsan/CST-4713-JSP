<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Some Hard-to-Debug Page</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Some Hard-to-Debug Page</H1>
<%@ taglib uri="/WEB-INF/tlds/csajsp-taglib.tld" 
           prefix="csajsp" %>
Top of regular page. Blah, blah, blah. 
Yadda, yadda, yadda.
<csajsp:debug>
<H2>Debug Info:</H2>
********************<BR>
-Remote Host: ${pageContext.request.remoteHost}<BR>
-Session ID: ${pageContext.session.id}<BR>
-The foo parameter: ${param.foo}<BR>
********************<BR>
</csajsp:debug>
<P>
Bottom of regular page. Blah, blah, blah. 
Yadda, yadda, yadda.
</BODY></HTML>