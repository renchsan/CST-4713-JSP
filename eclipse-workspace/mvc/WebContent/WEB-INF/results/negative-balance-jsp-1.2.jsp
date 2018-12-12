<!DOCTYPE html>
<html>
<head><title>You Owe Us Money!</title>
<link href="./css/styles.css" 
      rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
<table class="title">
  <tr><th>We Know Where You Live!</th></tr>
</table>
<p/>
<img src="./images/club.gif" align="left"/>
<jsp:useBean id="customer" 
             type="coreservlets.Customer"
             scope="request" />
<h2>Watch out, 
<jsp:getProperty name="customer" 
                 property="firstName"/>,  
we know where you live. </h2>
<h2>Pay us the 
$<jsp:getProperty name="customer" 
                  property="balanceNoSign"/>
you owe us before it is too late!</h2> 
</div></body></html>