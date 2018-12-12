<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>

  <%-- <li>First name: ${name.firstName}</li>
  <li>Last name: ${name.lastName}</li> --%>  
  <li>SSN: <%= request.getAttribute("ssn") %>
  <li>First Name: <%= request.getAttribute("firstName") %>
  <li>Last Name: <%= request.getAttribute("lastName") %>
  <li>Phone: <%= request.getAttribute("phone") %>
  <li>Address: <%= request.getAttribute("address") %>
</ul> 
</body>
</html>