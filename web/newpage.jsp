<%-- 
    Document   : newpage
    Created on : Mar 27, 2019, 11:58:16 AM
    Author     : Lyda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${lala.scode}</h1>
        <hi>${lala.sdate}</hi>

        ${lala.ccode.name}
        
        <table>
       <c:forEach items="${list}" var="value">
           <tr>
               <td>
                   <c:out value="${value.scode}"/>
               </td>
               <td>
                   ${value.sdate}
               </td>
               <td>
                   ${value.quant}
               </td>
           </tr>
       </c:forEach>
        </table>
    </body>
</html>
