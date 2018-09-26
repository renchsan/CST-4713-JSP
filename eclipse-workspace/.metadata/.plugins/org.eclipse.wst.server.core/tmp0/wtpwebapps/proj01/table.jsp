<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<HTML>
 <HEAD>
  <TITLE>Hello World</TITLE>
 </HEAD>
 <BODY>
  <H1>Hello World</H1>
    <table>
     <% for(int rows = 0; rows < 25; rows++){ %>
     <tr>
       <% for (int cols = 0; cols < 10; cols++){ %>
        <td> Col:<%= cols %> - Row:<%= rows %> </td>
           <% } %>
     </tr>
       <% } %>
      </table>
 </BODY>
</HTML>